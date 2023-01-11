package br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address;

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
@Entity(name = "address")
public class AddressModel implements Serializable {
    
    @Id
	private String uuid;
	private Date create_at = new Date();
	@Column(updatable = true)
	private Date update_at;
    
    @Column(length=9, nullable=false)
    private String cep;
    @Column(nullable=false)
    private String street;
    @Column(nullable=false)
    private String complement;
    @Column(nullable=false)
    private String neighborhood;
    @Column(length=2, nullable=false)
    private String uf;
    @Column(nullable=false)
    private Integer numer;
       

    public AddressModel() {
		this.uuid= Generators.randomBasedGenerator().generate().toString();
	}

}
