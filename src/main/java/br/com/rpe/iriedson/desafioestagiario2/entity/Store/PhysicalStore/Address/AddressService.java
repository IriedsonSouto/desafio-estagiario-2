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

    public AddressModel readByCepAndNumber(String cep, Integer number) throws Exception {
        return (AddressModel) addressRepository.findByCepAndNumber(cep, number);
    }

    public List<AddressModel> readAll(){
        return (List<AddressModel>) super.readAll(this.addressRepository);
    }

    public AddressModel update(AddressDTO addressDTO, String uuid) throws Exception {
        try{
            AddressModel updateAddress = addressRepository.findByUuid(uuid);

            String cep = addressDTO.getCep() == null ? updateAddress.getCep() : addressDTO.getCep();
            String city = addressDTO.getCity() == null ? updateAddress.getCity() : addressDTO.getCity();
            String street = addressDTO.getStreet() == null ? updateAddress.getStreet() : addressDTO.getStreet();
            String uf = addressDTO.getUf() == null ? updateAddress.getUf() : addressDTO.getUf();
            Integer number = addressDTO.getNumber() == null ? updateAddress.getNumber() : addressDTO.getNumber();

            updateAddress.setCep(cep);
            updateAddress.setCity(city);
            updateAddress.setStreet(street);
            updateAddress.setUf(uf);
            updateAddress.setNumber(number);


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