package br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AddressDTO {
    
    private String uuid;
    private String cep;
    private String city;
    private String street;
    private String uf;
    private Integer number;

    public AddressDTO(){}
    
    public AddressDTO(AddressModel address) {    
		
        this.uuid = address.getUuid();
        this.cep = address.getCep();
        this.city = address.getCity();
        this.street = address.getStreet();
        this.uf = address.getUf();
        this.number = address.getNumber();

    }

	public static List<AddressDTO> convert(List<AddressModel> address){
        return address.stream().map(AddressDTO::new).collect(Collectors.toList());
    }

    public static AddressModel convertDTO(AddressDTO dto){
        AddressModel model = new AddressModel();
        model.setCep(dto.getCep());
        model.setCity(dto.getCity());
        model.setStreet(dto.getStreet());
        model.setUf(dto.getUf());
        model.setNumber(dto.getNumber());

        return model;
    }

}
