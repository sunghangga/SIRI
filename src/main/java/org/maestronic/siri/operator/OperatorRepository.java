package org.maestronic.siri.operator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class OperatorRepository {

    private final EntityManagerFactory emf;

    @Autowired
    public OperatorRepository(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<Operator> getOperators() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT o FROM Operator o");

        return query.getResultList();
    }
}
