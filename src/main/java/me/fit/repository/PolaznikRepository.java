package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.Holiday;
import me.fit.model.Polaznik;
import me.fit.model.client.PolaznikKurs;

@Dependent
public class PolaznikRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public Polaznik createPolaznik(Polaznik polaznik) {
        return em.merge(polaznik);
    }

    @Transactional
    public PolaznikKurs createPolaznikKurs(PolaznikKurs polaznikKurs) {
        return em.merge(polaznikKurs);
    }
    @Transactional
    public Holiday saveHoliday(Holiday holiday) {
        return em.merge(holiday);
    }

    public Polaznik findById(Long id) {
        return em.find(Polaznik.class, id);
    }

    @Transactional
    public Polaznik savePolaznik(Polaznik polaznik) {
        return em.merge(polaznik);
    }
}
