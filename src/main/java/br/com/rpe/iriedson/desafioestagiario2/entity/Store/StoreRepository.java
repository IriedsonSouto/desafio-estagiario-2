package br.com.rpe.iriedson.desafioestagiario2.entity.Store;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository<T extends StoreModel> extends JpaRepository<StoreModel, String> {

    public T findByUuid(String uuid);
    public T findByCnpj(String cnpj);
    public T findByPhone(String phone);
    
}