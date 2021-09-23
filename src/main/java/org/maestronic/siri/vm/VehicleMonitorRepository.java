package org.maestronic.siri.vm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class VehicleMonitorRepository {

    private final EntityManagerFactory emf;

    @Autowired
    public VehicleMonitorRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Object[]> getVehicleMonitor() {
        EntityManager em = emf.createEntityManager();
        List<Object[]> resultList = em.createQuery(
                "SELECT l.name, a.name FROM Line l "
                        + "LEFT JOIN Authority a ON l.authority_ref = a.id"
        ).getResultList();

        return resultList;
    }
}
