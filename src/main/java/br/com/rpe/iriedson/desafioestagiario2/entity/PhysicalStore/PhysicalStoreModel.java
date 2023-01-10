package br.com.rpe.iriedson.desafioestagiario2.entity.PhysicalStore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import com.fasterxml.uuid.Generators;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "physical_store")
public class PhysicalStoreModel implements Serializable {
    
    @Column(length=18, nullable=false)
    private String cnpj;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String segment;
    @Column(length=15, nullable=false)
    private String phone;
    @Column(nullable=false)
    private String address;
    @Column(nullable=false)
    private Integer numEmployees;
    
    @Id
	private String uuid;
	private Date create_at = new Date();
	@Column(updatable = true)
	private Date update_at;


    public PhysicalStoreModel() {
		this.uuid= Generators.randomBasedGenerator().generate().toString();
	}

}
