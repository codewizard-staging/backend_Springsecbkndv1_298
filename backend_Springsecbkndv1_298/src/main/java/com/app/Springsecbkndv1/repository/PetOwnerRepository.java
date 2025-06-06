package com.app.Springsecbkndv1.repository;


import com.app.Springsecbkndv1.model.PetOwner;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class PetOwnerRepository extends SimpleJpaRepository<PetOwner, String> {
    private final EntityManager em;
    public PetOwnerRepository(EntityManager em) {
        super(PetOwner.class, em);
        this.em = em;
    }
    @Override
    public List<PetOwner> findAll() {
        return em.createNativeQuery("Select * from \"springsecbkndv1_611\".\"PetOwner\"", PetOwner.class).getResultList();
    }
}