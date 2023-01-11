package br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressRepository extends JpaRepository<AddressModel, String> {

    public AddressModel findByUuid(String uuid);

    @Query(nativeQuery = true, value = "SELECT * FROM address WHERE cep=:cep AND number=:number")
	public AddressModel findByCepAndNumber(String cep, Integer number);
    
}