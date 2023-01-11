package br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore;

import br.com.rpe.iriedson.desafioestagiario2.entity.Store.StoreModel;
import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressModel;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.io.Serializable;


@Getter
@Setter
@Entity(name = "physical_store")
public class PhysicalStoreModel extends StoreModel implements Serializable {
    
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address", nullable = false)
    private AddressModel address;
    @Column(nullable=false)
    private Integer numEmployees;
    

    public PhysicalStoreModel() {
        super();
    }

}
