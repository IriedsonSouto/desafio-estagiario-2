package br.com.rpe.iriedson.desafioestagiario2.entity.VirtualStore;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class VirtualStoreDTO {
	
    private String uuid;
    private String cnpj;
    private String name;
    private String segment;
    private String phone;
    private String url;
    private Integer rating;

	public VirtualStoreDTO(VirtualStoreModel virtualStore) {    
		
        this.uuid = virtualStore.getUuid();
        this.cnpj = virtualStore.getCnpj();
        this.name = virtualStore.getName();
        this.segment = virtualStore.getSegment();
        this.phone = virtualStore.getPhone();
        this.url = virtualStore.getUrl();
        this.rating = virtualStore.getRating();
    }

	public static List<VirtualStoreDTO> convert(List<VirtualStoreModel> virtualStore){
        return virtualStore.stream().map(VirtualStoreDTO::new).collect(Collectors.toList());
    }

}