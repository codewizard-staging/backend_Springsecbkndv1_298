package com.app.Springsecbkndv1.repository;


import com.app.Springsecbkndv1.model.PetCareCenter;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class PetCareCenterRepository extends SimpleJpaRepository<PetCareCenter, String> {
    private final EntityManager em;
    public PetCareCenterRepository(EntityManager em) {
        super(PetCareCenter.class, em);
        this.em = em;
    }
    @Override
    public List<PetCareCenter> findAll() {
        return em.createNativeQuery("Select * from \"springsecbkndv1_611\".\"PetCareCenter\"", PetCareCenter.class).getResultList();
    }
}