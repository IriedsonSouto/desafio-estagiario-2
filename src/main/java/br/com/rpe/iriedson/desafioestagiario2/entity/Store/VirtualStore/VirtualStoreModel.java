package br.com.rpe.iriedson.desafioestagiario2.entity.Store.VirtualStore;

import br.com.rpe.iriedson.desafioestagiario2.entity.Store.StoreModel;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.io.Serializable;


@Getter
@Setter
@Entity(name = "virtual_store")
public class VirtualStoreModel extends StoreModel implements Serializable {
    
    @Column(unique=true, nullable=false)
    private String url;
    @Column(nullable=false)
    private Integer rating;


    public VirtualStoreModel() {
        super();
    }
    
}
