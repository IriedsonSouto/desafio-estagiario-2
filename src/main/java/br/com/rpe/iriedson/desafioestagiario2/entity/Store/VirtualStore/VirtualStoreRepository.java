package br.com.rpe.iriedson.desafioestagiario2.entity.Store.VirtualStore;

import org.springframework.stereotype.Repository;

import br.com.rpe.iriedson.desafioestagiario2.entity.Store.StoreRepository;


@Repository
public interface VirtualStoreRepository extends StoreRepository<VirtualStoreModel> {

    public VirtualStoreModel findByUrl(String url);
    
}
