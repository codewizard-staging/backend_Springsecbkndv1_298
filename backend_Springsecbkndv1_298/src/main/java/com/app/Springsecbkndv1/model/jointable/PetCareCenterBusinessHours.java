package com.app.Springsecbkndv1.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

import com.app.Springsecbkndv1.model.Manager;
import com.app.Springsecbkndv1.model.Pet;
import com.app.Springsecbkndv1.model.PetCareCenter;
import com.app.Springsecbkndv1.model.PetOwner;
import com.app.Springsecbkndv1.model.Document;
import com.app.Springsecbkndv1.model.PetService;
import com.app.Springsecbkndv1.enums.PetServiceType;
import com.app.Springsecbkndv1.converter.PetServiceTypeConverter;

@Entity(name = "PetCareCenterBusinessHours")
@Table(schema = "\"springsecbkndv1_611\"", name = "\"PetCareCenterBusinessHours\"")
@Data
public class PetCareCenterBusinessHours{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"PcId\"")
	private Integer pcId;

    
    @Column(name = "\"BusinessHours\"")
    private Integer businessHours;
}