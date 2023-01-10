package br.com.rpe.iriedson.desafioestagiario2.template;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public abstract class ServiceTemplate {

    protected <T> boolean create(T object, JpaRepository repository) {
        try {
            if(object == null){
                return false;
            }
            repository.save(object);
            return true;
        }catch (Exception error){
            throw error;
        }
    }
     
    protected List<?> readAll( JpaRepository repository) {
        try {
            return repository.findAll();
        }catch (Exception error){
            return null;
        }
    }
    
    protected <T> Object readByUuid(String uuid, JpaRepository repository) {
        try {
            return repository.findById(uuid).get();
        }catch (Exception error){
            return null;
        }
    }

    protected <T> boolean update(T object, JpaRepository repository) {
        return this.create(object, repository);
    }

    protected boolean delete(String uuid, JpaRepository repository) {
        try {
            repository.deleteById(uuid);
            return true;
        }catch (Exception error){
            return false;
        }
    }

}
