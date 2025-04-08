package com.app.Springsecbkndv1.repository;


import com.app.Springsecbkndv1.model.Manager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class ManagerRepository extends SimpleJpaRepository<Manager, String> {
    private final EntityManager em;
    public ManagerRepository(EntityManager em) {
        super(Manager.class, em);
        this.em = em;
    }
    @Override
    public List<Manager> findAll() {
        return em.createNativeQuery("Select * from \"springsecbkndv1_611\".\"Manager\"", Manager.class).getResultList();
    }
}