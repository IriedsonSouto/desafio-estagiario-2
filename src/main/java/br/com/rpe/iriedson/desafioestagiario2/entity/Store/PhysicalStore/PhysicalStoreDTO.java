package br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore;

import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class PhysicalStoreDTO {
	
    private String uuid;
    private String cnpj;
    private String name;
    private String segment;
    private String phone;
    private AddressDTO address;
    private Integer numEmployees;

    public PhysicalStoreDTO(){}
    
	public PhysicalStoreDTO(PhysicalStoreModel physicalStore) {    
		
        this.uuid = physicalStore.getUuid();
        this.cnpj = physicalStore.getCnpj();
        this.name = physicalStore.getName();
        this.segment = physicalStore.getSegment();
        this.phone = physicalStore.getPhone();
        this.numEmployees = physicalStore.getNumEmployees();

        var addressModel = physicalStore.getAddress();
        this.address = addressModel != null ? new AddressDTO(addressModel) : null;
    }

	public static List<PhysicalStoreDTO> convert(List<PhysicalStoreModel> physicalStore){
        return physicalStore.stream().map(PhysicalStoreDTO::new).collect(Collectors.toList());
    }

    public static PhysicalStoreModel convertDTO(PhysicalStoreDTO dto){
        PhysicalStoreModel model = new PhysicalStoreModel();
        model.setCnpj(dto.getCnpj());
        model.setName(dto.getName());
        model.setSegment(dto.getSegment());
        model.setPhone(dto.getPhone());
        model.setAddress(AddressDTO.convertDTO(dto.getAddress()));
        model.setNumEmployees(dto.getNumEmployees());

        return model;
    }

}