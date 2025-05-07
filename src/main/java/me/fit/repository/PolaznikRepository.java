package me.fit.repository;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
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
}
