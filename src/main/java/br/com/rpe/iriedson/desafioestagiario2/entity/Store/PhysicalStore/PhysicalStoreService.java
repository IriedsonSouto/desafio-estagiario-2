package br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore;

import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressDTO;
import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressModel;
import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressService;
import br.com.rpe.iriedson.desafioestagiario2.service.ValidationService;
import br.com.rpe.iriedson.desafioestagiario2.template.ServiceTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhysicalStoreService extends ServiceTemplate {
    
    @Autowired
    private PhysicalStoreRepository physicalStoreRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ValidationService validationService;
    
    public PhysicalStoreModel create(PhysicalStoreDTO physicalStoreDTO) throws Exception {
        try{
            validationService.validationCnpjFormat(physicalStoreDTO.getCnpj());
            validationService.validationPhoneFormat(physicalStoreDTO.getPhone());
            validationService.validationCepFormat(physicalStoreDTO.getAddress().getCep());

            AddressModel address = addressService.readByCepAndNumber(physicalStoreDTO.getAddress().getCep(), physicalStoreDTO.getAddress().getNumber());

            if(address == null){
                PhysicalStoreModel physicalStore = PhysicalStoreDTO.convertDTO(physicalStoreDTO);
                boolean create = super.create(physicalStore, this.physicalStoreRepository);
                return physicalStore;
            }
            throw new Exception("Já há uma loja com esse endereço.");
        }catch (Exception error) {
            throw new Exception("Houve um problema para criar uma Loja Física. Error: "+error.getMessage());
        }
    }

    public PhysicalStoreModel readByUuid(String uuid) throws Exception {
        return (PhysicalStoreModel) super.readByUuid(uuid, this.physicalStoreRepository);
    }

    public PhysicalStoreModel readByCnpj(String cnpj) throws Exception {
        cnpj = cnpj.replaceAll("%2F", "/");
        return (PhysicalStoreModel) physicalStoreRepository.findByCnpj(cnpj);
    }

    public PhysicalStoreModel readByPhone(String phone) throws Exception {
        return (PhysicalStoreModel) physicalStoreRepository.findByPhone(phone);
    }

    public PhysicalStoreModel readByCepAndNumer(String cep, Integer numer) throws Exception {
        AddressModel address = addressService.readByCepAndNumber(cep, numer); 
        return (PhysicalStoreModel) physicalStoreRepository.findByAddress(address);
    }

    public List<PhysicalStoreModel> readAll(){
        return (List<PhysicalStoreModel>) super.readAll(this.physicalStoreRepository);
    }

    public PhysicalStoreModel update(PhysicalStoreDTO physicalStoreDTO, String uuid) throws Exception {
        try{
            PhysicalStoreModel updatephysicalStore = physicalStoreRepository.findByUuid(uuid);

            if(physicalStoreDTO.getAddress() != null){
                if(!(physicalStoreDTO.getAddress().getCep().equals(updatephysicalStore.getAddress().getCep()) 
                && physicalStoreDTO.getAddress().getNumber().equals(updatephysicalStore.getAddress().getNumber()))){
                    AddressModel address = addressService.readByCepAndNumber(physicalStoreDTO.getAddress().getCep(), physicalStoreDTO.getAddress().getNumber());
                    if(address != null){
                        throw new Exception("Já há uma loja com esse endereço.");
                    }
                }
            }

            String cnpj = physicalStoreDTO.getCnpj() == null ? updatephysicalStore.getCnpj() : physicalStoreDTO.getCnpj();
            String name = physicalStoreDTO.getName() == null ? updatephysicalStore.getName() : physicalStoreDTO.getName();
            String segment = physicalStoreDTO.getSegment() == null ? updatephysicalStore.getSegment() : physicalStoreDTO.getSegment();
            String phone = physicalStoreDTO.getPhone() == null ? updatephysicalStore.getPhone() : physicalStoreDTO.getPhone();
            AddressModel address = physicalStoreDTO.getAddress() == null ? updatephysicalStore.getAddress() : AddressDTO.convertDTO(physicalStoreDTO.getAddress());
            Integer numEmployees = physicalStoreDTO.getNumEmployees() == null ? updatephysicalStore.getNumEmployees() : physicalStoreDTO.getNumEmployees();

            validationService.validationCnpjFormat(cnpj);
            validationService.validationPhoneFormat(phone);
            validationService.validationCepFormat(address.getCep());

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