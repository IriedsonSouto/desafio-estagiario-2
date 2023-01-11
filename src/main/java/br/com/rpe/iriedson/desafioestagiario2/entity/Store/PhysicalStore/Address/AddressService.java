package br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address;

import br.com.rpe.iriedson.desafioestagiario2.template.ServiceTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService extends ServiceTemplate {
    
    @Autowired
    private AddressRepository addressRepository;
    
    public AddressModel create(AddressDTO addressDTO) throws Exception {
        try{
            AddressModel address = AddressDTO.convertDTO(addressDTO);
            boolean create = super.create(address, this.addressRepository);
            if(create){
                return address;
            }
            return null;
        }catch (Exception error) {
            throw new Exception("Houve um problema para criar um Endereço. Error: "+error.getMessage());
        }
    }

    public AddressModel readByUuid(String uuid) throws Exception {
        return (AddressModel) super.readByUuid(uuid, this.addressRepository);
    }

    public AddressModel readByCepAndNumer(String cep, Integer numer) throws Exception {
        return (AddressModel) addressRepository.findByCepAndNumer(cep, numer);
    }

    public List<AddressModel> readAll(){
        return (List<AddressModel>) super.readAll(this.addressRepository);
    }

    public AddressModel update(AddressDTO addressDTO, String uuid) throws Exception {
        try{
            AddressModel updateAddress = addressRepository.findByUuid(uuid);

            String cep = addressDTO.getCep() == null ? updateAddress.getCep() : addressDTO.getCep();
            String street = addressDTO.getStreet() == null ? updateAddress.getStreet() : addressDTO.getStreet();
            String complement = addressDTO.getComplement() == null ? updateAddress.getComplement() : addressDTO.getComplement();
            String neighborhood = addressDTO.getNeighborhood() == null ? updateAddress.getNeighborhood() : addressDTO.getNeighborhood();
            String uf = addressDTO.getUf() == null ? updateAddress.getUf() : addressDTO.getUf();
            Integer numer = addressDTO.getNumer() == null ? updateAddress.getNumer() : addressDTO.getNumer();

            updateAddress.setCep(cep);
            updateAddress.setStreet(street);
            updateAddress.setComplement(complement);
            updateAddress.setNeighborhood(neighborhood);
            updateAddress.setUf(uf);
            updateAddress.setNumer(numer);


            boolean update = super.update(updateAddress, this.addressRepository);
            if(update){
                return updateAddress;
            }
            return null;
        }catch (Exception error) {
            throw new Exception("Houve um problema para atualizar um Endereço. Error: "+error.getMessage());
        }
    }

    public boolean delete(String uuid) {
        return super.delete(uuid, this.addressRepository);
    }

}