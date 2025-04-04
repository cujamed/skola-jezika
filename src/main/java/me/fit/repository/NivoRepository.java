package me.fit.repository;

import java.util.HashSet;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Kurs;
import me.fit.model.Nivo;


@Dependent
public class NivoRepository {

	@Inject
	private EntityManager em;

	@Transactional
	public Nivo createNivo(Nivo n) {
		return em.merge(n);
	}

	@Transactional
	public List<Nivo> getAllLevels() {
		List<Nivo> levels = em.createNamedQuery(Nivo.GET_ALL_LEVELS, Nivo.class).getResultList();
		
		for (Nivo nivo : levels) {
			List<Kurs> kursevi = em.createNamedQuery(Kurs.GET_COURSES_FOR_LEVEL, Kurs.class)
					.setParameter("id", nivo.getId()).getResultList();
			
			nivo.setKursevi(new HashSet<>(kursevi));
		}

		return levels;
	}

}
