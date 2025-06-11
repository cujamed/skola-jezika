package me.fit.resource;

import me.fit.model.client.HolidayClient;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.fit.model.Holiday;
import me.fit.model.HolidayType;
import me.fit.model.Polaznik;
import me.fit.model.api.AvailableCountry;
import me.fit.model.api.NextPublicHoliday;
import me.fit.model.client.PolaznikKurs;
import me.fit.repository.PolaznikRepository;

@Path("/polaznik/")
public class PolaznikResource {
    @Inject
    EntityManager em;

    @Inject
    @RestClient
    HolidayClient holidayClient;

    @Inject
    private PolaznikRepository polaznikRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/createPolaznik")
    public Response createPolaznik(Polaznik polaznik) {
        Polaznik p = polaznikRepository.createPolaznik(polaznik);
        return Response.ok().entity(p).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("createPolaznikKurs")
    public Response createPolaznikKurs(PolaznikKurs polaznikKurs) {
        PolaznikKurs pk = polaznikRepository.createPolaznikKurs(polaznikKurs);
        return Response.ok().entity(pk).build();
    }
    @GET
    @Path("/availableCountries")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AvailableCountry> getAvailableCountries() {
        return holidayClient.getAvailableCountries();
    }

    
    @GET
    @Path("/nextHolidays/{countryCode}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<NextPublicHoliday> getNextPublicHolidays(@PathParam("countryCode") String countryCode) {
        List<NextPublicHoliday> holidays = holidayClient.getNextPublicHolidays(countryCode);

        for (NextPublicHoliday apiHoliday : holidays) {
            int year = apiHoliday.getDate() != null ? LocalDate.parse(apiHoliday.getDate()).getYear() : LocalDate.now().getYear();
            String date = apiHoliday.getDate() != null ? apiHoliday.getDate() : "";
            String name = apiHoliday.getName() != null ? apiHoliday.getName() : "";
            
            TypedQuery<Long> query = em.createQuery(
            "SELECT COUNT(h) FROM Holiday h WHERE h.year = :year AND h.countryCode = :countryCode AND h.date = :date AND h.name = :name", Long.class);
            query.setParameter("year", year);
            query.setParameter("countryCode", countryCode);
            query.setParameter("date", date);
            query.setParameter("name", name);
            Long count = query.getSingleResult();

            if (count == 0) {
                Holiday holiday = new Holiday();
                holiday.setDate(apiHoliday.getDate() != null ? apiHoliday.getDate() : "");
                holiday.setLocalName(apiHoliday.getLocalName() != null ? apiHoliday.getLocalName() : "");
                holiday.setName(apiHoliday.getName() != null ? apiHoliday.getName() : "");
                holiday.setCountryCode(apiHoliday.getCountryCode() != null ? apiHoliday.getCountryCode() : "");
                holiday.setFixed(apiHoliday.isFixed());
                holiday.setGlobal(apiHoliday.isGlobal());
                holiday.setCounties(apiHoliday.getCounties() != null ? String.join(",", apiHoliday.getCounties()) : null);
                holiday.setLaunchYear(apiHoliday.getLaunchYear());
                holiday.setYear(year);

                Set<HolidayType> holidayTypes = new HashSet<>();
                if (apiHoliday.getTypes() != null) {
                    for (String type : apiHoliday.getTypes()) {
                        HolidayType holidayType = new HolidayType(type);
                        holidayTypes.add(holidayType);
                    }
                }
                holiday.setTypes(holidayTypes);

                polaznikRepository.saveHoliday(holiday);
            }
        }

        return holidays;
    }
}