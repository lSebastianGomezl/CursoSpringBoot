package edu.eud.springBootTest.persistent.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionEntity2 {
	
	   @Id
	    @Column(name = "region_id")
	    private Long id;

	    @Column(name = "region_name")
	    private String name;
	    
	    @OneToMany(targetEntity = CountryEntity2.class, fetch = FetchType.EAGER, mappedBy = "region")
	    @JsonIgnore
		private List<CountryEntity2> countries;

}
