package com.app.Springsecbkndv1.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.app.Springsecbkndv1.model.Manager;
import com.app.Springsecbkndv1.model.Pet;
import com.app.Springsecbkndv1.model.PetCareCenter;
import com.app.Springsecbkndv1.model.PetOwner;
import com.app.Springsecbkndv1.model.Document;
import com.app.Springsecbkndv1.model.PetService;
import com.app.Springsecbkndv1.enums.PetServiceType;
import com.app.Springsecbkndv1.converter.PetServiceTypeConverter;
import com.app.Springsecbkndv1.converter.DurationConverter;
import com.app.Springsecbkndv1.converter.UUIDToByteConverter;
import com.app.Springsecbkndv1.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "Pet")
@Table(name = "\"Pet\"", schema =  "\"springsecbkndv1_611\"")
@Data
                        
public class Pet {
	public Pet () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"PetId\"", nullable = true )
  private Integer petId;
	  
  @Column(name = "\"PetName\"", nullable = true )
  private String petName;
  
	  
  @Column(name = "\"Breed\"", nullable = true )
  private String breed;
  
	  
  @Column(name = "\"AnimalType\"", nullable = true )
  private String animalType;
  
	  
  @Column(name = "\"Gender\"", nullable = true )
  private String gender;
  
	  
  @Column(name = "\"Color\"", nullable = true )
  private String color;
  
	  
  @Column(name = "\"Weight\"", nullable = true )
  private Double weight;
  
	  
  @Column(name = "\"Height\"", nullable = true )
  private Double height;
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Pet [" 
  + "PetId= " + petId  + ", " 
  + "PetName= " + petName  + ", " 
  + "Breed= " + breed  + ", " 
  + "AnimalType= " + animalType  + ", " 
  + "Gender= " + gender  + ", " 
  + "Color= " + color  + ", " 
  + "Weight= " + weight  + ", " 
  + "Height= " + height 
 + "]";
	}
	
}
