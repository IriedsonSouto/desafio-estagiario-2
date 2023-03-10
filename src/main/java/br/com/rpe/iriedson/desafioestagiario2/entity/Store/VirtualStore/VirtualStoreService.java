package br.com.rpe.iriedson.desafioestagiario2.entity.Store.VirtualStore;

import br.com.rpe.iriedson.desafioestagiario2.service.ValidationService;
import br.com.rpe.iriedson.desafioestagiario2.template.ServiceTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VirtualStoreService extends ServiceTemplate {
    
    @Autowired
    private VirtualStoreRepository virtualStoreRepository;
    @Autowired
    private ValidationService validationService;
    
    public VirtualStoreModel create(VirtualStoreDTO virtualStoreDTO) throws Exception {
        try{
            validationService.validationCnpjFormat(virtualStoreDTO.getCnpj());
            validationService.validationPhoneFormat(virtualStoreDTO.getPhone());

            VirtualStoreModel virtualStore = VirtualStoreDTO.convertDTO(virtualStoreDTO);
            boolean create = super.create(virtualStore, this.virtualStoreRepository);
            if(create){
                return virtualStore;
            }
            return null;
        }catch (Exception error) {
            throw new Exception("Houve um problema para criar uma Loja Virtual. Error: "+error.getMessage());
        }
    }

    public VirtualStoreModel readByUuid(String uuid) throws Exception {
        return (VirtualStoreModel) super.readByUuid(uuid, this.virtualStoreRepository);
    }

    public VirtualStoreModel readByCnpj(String cnpj) throws Exception {
        cnpj = cnpj.replaceAll("%2F", "/");
        return (VirtualStoreModel) virtualStoreRepository.findByCnpj(cnpj);
    }

    public VirtualStoreModel readByPhone(String phone) throws Exception {
        return (VirtualStoreModel) virtualStoreRepository.findByPhone(phone);
    }

    public VirtualStoreModel readByUrl(String url) throws Exception {
        return (VirtualStoreModel) virtualStoreRepository.findByUrl(url);
    }

    public List<VirtualStoreModel> readAll(){
        return (List<VirtualStoreModel>) super.readAll(this.virtualStoreRepository);
    }

    public VirtualStoreModel update(VirtualStoreDTO virtualStoreDTO, String uuid) throws Exception {
        try{  
            VirtualStoreModel updateVirtualStore = (VirtualStoreModel) virtualStoreRepository.findByUuid(uuid);

            String cnpj = virtualStoreDTO.getCnpj() == null ? updateVirtualStore.getCnpj() : virtualStoreDTO.getCnpj();
            String name = virtualStoreDTO.getName() == null ? updateVirtualStore.getName() : virtualStoreDTO.getName();
            String segment = virtualStoreDTO.getSegment() == null ? updateVirtualStore.getSegment() : virtualStoreDTO.getSegment();
            String phone = virtualStoreDTO.getPhone() == null ? updateVirtualStore.getPhone() : virtualStoreDTO.getPhone();
            String url = virtualStoreDTO.getUrl() == null ? updateVirtualStore.getUrl() : virtualStoreDTO.getUrl();
            Integer rating = virtualStoreDTO.getRating() == null ? updateVirtualStore.getRating() : virtualStoreDTO.getRating();

            validationService.validationCnpjFormat(cnpj);
            validationService.validationPhoneFormat(phone);

            updateVirtualStore.setCnpj(cnpj);
            updateVirtualStore.setName(name);
            updateVirtualStore.setSegment(segment);
            updateVirtualStore.setPhone(phone);
            updateVirtualStore.setUrl(url);
            updateVirtualStore.setRating(rating);

            boolean update = super.update(updateVirtualStore, this.virtualStoreRepository);
            if(update){
                return updateVirtualStore;
            }
            return null;
        }catch (Exception error) {
            throw new Exception("Houve um problema para atualizar uma Loja Virtual. Error: "+error.getMessage());
        }
    }

    public boolean delete(String uuid) {
        return super.delete(uuid, this.virtualStoreRepository);
    }

}