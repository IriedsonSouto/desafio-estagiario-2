package br.com.rpe.iriedson.desafioestagiario2.entity.PhysicalStore;

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
    private String address;
    private Integer numEmployees;

	public PhysicalStoreDTO(PhysicalStoreModel physicalStore) {    
		
        this.uuid = physicalStore.getUuid();
        this.cnpj = physicalStore.getCnpj();
        this.name = physicalStore.getName();
        this.segment = physicalStore.getSegment();
        this.phone = physicalStore.getPhone();
        this.address = physicalStore.getAddress();
        this.numEmployees = physicalStore.getNumEmployees();
    }

	public static List<PhysicalStoreDTO> convert(List<PhysicalStoreModel> physicalStore){
        return physicalStore.stream().map(PhysicalStoreDTO::new).collect(Collectors.toList());
    }

}