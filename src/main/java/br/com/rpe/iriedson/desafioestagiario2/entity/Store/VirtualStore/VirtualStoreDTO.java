package br.com.rpe.iriedson.desafioestagiario2.entity.Store.VirtualStore;

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

    public VirtualStoreDTO(){}

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

    public static VirtualStoreModel convertDTO(VirtualStoreDTO dto){
        VirtualStoreModel model = new VirtualStoreModel();
        model.setCnpj(dto.getCnpj());
        model.setName(dto.getName());
        model.setSegment(dto.getSegment());
        model.setPhone(dto.getPhone());
        model.setUrl(dto.getUrl());
        model.setRating(dto.getRating());

        return model;
    }
}