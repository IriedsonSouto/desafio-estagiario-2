package br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore;

import org.springframework.stereotype.Repository;

import br.com.rpe.iriedson.desafioestagiario2.entity.Store.StoreRepository;
import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressModel;


@Repository
public interface PhysicalStoreRepository extends StoreRepository<PhysicalStoreModel> {

    public PhysicalStoreModel findByAddress(AddressModel address);
    
}
