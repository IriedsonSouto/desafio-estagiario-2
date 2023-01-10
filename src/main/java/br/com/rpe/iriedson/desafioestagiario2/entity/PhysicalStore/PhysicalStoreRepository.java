package br.com.rpe.iriedson.desafioestagiario2.entity.PhysicalStore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhysicalStoreRepository extends JpaRepository<PhysicalStoreModel, String> {

    public PhysicalStoreModel findByUuid(String uuid);
    
}
