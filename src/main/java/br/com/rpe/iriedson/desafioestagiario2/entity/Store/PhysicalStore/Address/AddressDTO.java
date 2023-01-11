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
    private String street;
    private String complement;
    private String neighborhood;
    private String uf;
    private Integer numer;

    public AddressDTO(AddressModel address) {    
		
        this.uuid = address.getUuid();
        this.cep = address.getCep();
        this.street = address.getStreet();
        this.complement = address.getComplement();
        this.neighborhood = address.getNeighborhood();
        this.uf = address.getUf();
        this.numer = address.getNumer();

    }

	public static List<AddressDTO> convert(List<AddressModel> address){
        return address.stream().map(AddressDTO::new).collect(Collectors.toList());
    }

    public static AddressModel convertDTO(AddressDTO dto){
        AddressModel model = new AddressModel();
        model.setCep(dto.getCep());
        model.setStreet(dto.getStreet());
        model.setComplement(dto.getComplement());
        model.setNeighborhood(dto.getNeighborhood());
        model.setUf(dto.getUf());
        model.setNumer(dto.getNumer());

        return model;
    }

}
