package br.com.rpe.iriedson.desafioestagiario2.entity.PhysicalStore;

import br.com.rpe.iriedson.desafioestagiario2.template.ServiceTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhysicalStoreService extends ServiceTemplate {
    
    @Autowired
    private PhysicalStoreRepository physicalStoreRepository;
    
    public PhysicalStoreModel create(PhysicalStoreDTO physicalStoreDTO) throws Exception {
        try{
            PhysicalStoreModel physicalStore = null;
            boolean create = super.create(physicalStore, this.physicalStoreRepository);
            if(create){
                return physicalStore;
            }
            return null;
        }catch (Exception error) {
            throw new Exception("Houve um problema para criar uma Loja Física. Error: "+error.getMessage());
        }
    }

    public PhysicalStoreModel readByUuid(String uuid) throws Exception {
        return (PhysicalStoreModel) super.readByUuid(uuid, this.physicalStoreRepository);
    }

    public List<PhysicalStoreModel> readAll(){
        return (List<PhysicalStoreModel>) super.readAll(this.physicalStoreRepository);
    }

    public PhysicalStoreModel update(PhysicalStoreDTO physicalStoreDTO, String uuid) throws Exception {
        try{
            PhysicalStoreModel updatephysicalStore = physicalStoreRepository.findByUuid(uuid);

            String cnpj = physicalStoreDTO.getCnpj() == null ? updatephysicalStore.getCnpj() : physicalStoreDTO.getCnpj();
            String name = physicalStoreDTO.getName() == null ? updatephysicalStore.getName() : physicalStoreDTO.getName();
            String segment = physicalStoreDTO.getSegment() == null ? updatephysicalStore.getSegment() : physicalStoreDTO.getSegment();
            String phone = physicalStoreDTO.getPhone() == null ? updatephysicalStore.getPhone() : physicalStoreDTO.getPhone();
            String address = physicalStoreDTO.getAddress() == null ? updatephysicalStore.getAddress() : physicalStoreDTO.getAddress();
            Integer numEmployees = physicalStoreDTO.getNumEmployees() == null ? updatephysicalStore.getNumEmployees() : physicalStoreDTO.getNumEmployees();

            updatephysicalStore.setCnpj(cnpj);
            updatephysicalStore.setName(name);
            updatephysicalStore.setSegment(segment);
            updatephysicalStore.setPhone(phone);
            updatephysicalStore.setAddress(address);
            updatephysicalStore.setNumEmployees(numEmployees);

            boolean update = super.update(updatephysicalStore, this.physicalStoreRepository);
            if(update){
                return updatephysicalStore;
            }
            return null;
        }catch (Exception error) {
            throw new Exception("Houve um problema para atualizar uma Loja Física. Error: "+error.getMessage());
        }
    }

    public boolean delete(String uuid) {
        return super.delete(uuid, this.physicalStoreRepository);
    }

}