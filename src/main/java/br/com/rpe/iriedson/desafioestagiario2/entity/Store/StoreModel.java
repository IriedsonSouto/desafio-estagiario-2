package br.com.rpe.iriedson.desafioestagiario2.entity.Store;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import com.fasterxml.uuid.Generators;

import jakarta.persistence.*;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class StoreModel {
    
    @Id
	private String uuid;
	private Date create_at = new Date();
	@Column(updatable = true)
	private Date update_at;
    
    @Column(length=18, unique=true, nullable=false)
    private String cnpj;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String segment;
    @Column(length=15, unique=true, nullable=false)
    private String phone;


    public StoreModel() {
		this.uuid= Generators.randomBasedGenerator().generate().toString();
	}
    
}
