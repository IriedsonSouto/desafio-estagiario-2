package br.com.rpe.iriedson.desafioestagiario2.entity.VirtualStore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VirtualStoreRepository extends JpaRepository<VirtualStoreModel, String> {

    public VirtualStoreModel findByUuid(String uuid);
    
}
