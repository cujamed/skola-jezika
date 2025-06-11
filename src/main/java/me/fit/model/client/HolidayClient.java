package me.fit.model.client;

import me.fit.model.api.AvailableCountry;
import me.fit.model.api.NextPublicHoliday;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.List;

@RegisterRestClient(configKey = "holiday-api")
@Path("/api/v3")
public interface HolidayClient {

    @GET
    @Path("/AvailableCountries")
    List<AvailableCountry> getAvailableCountries();

    @GET
    @Path("/NextPublicHolidays/{countryCode}")
    List<NextPublicHoliday> getNextPublicHolidays(@PathParam("countryCode") String countryCode);
}

