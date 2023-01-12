package br.com.rpe.iriedson.desafioestagiario2.unitary.ConverterMethods;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.rpe.iriedson.desafioestagiario2.entity.Store.VirtualStore.VirtualStoreDTO;
import br.com.rpe.iriedson.desafioestagiario2.entity.Store.VirtualStore.VirtualStoreModel;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConversionVirtualStore {

    @Test
	@Order(1)
    @Tag("convert_method")
    @DisplayName("Convert VirtualStoreModel to VirtualStoreDTO")
	void virtualStoreToVirtualStoreDTO() {
		try {
            VirtualStoreModel virtualStore = new VirtualStoreModel();
            virtualStore.setCnpj("11.111.111/0001-11");
            virtualStore.setName("Empresa show");
            virtualStore.setSegment("É show");
            virtualStore.setPhone("(00)0.0000-0000");
            virtualStore.setUrl("www.show.com");
            virtualStore.setRating(10);

			assertInstanceOf(VirtualStoreDTO.class, new VirtualStoreDTO(virtualStore));	
		} catch(Error e) {
            System.out.println(e.getMessage());
		}
	}

    @Test
	@Order(2)
    @Tag("convert_method")
    @DisplayName("Convert VirtualStoreModel to VirtualStoreDTO less attribute")
	void virtualStoreToVirtualStoreDTOLessAttribute() {
        VirtualStoreModel virtualStore = new VirtualStoreModel();
        virtualStore.setCnpj("11.111.111/0001-11");
        virtualStore.setName("Empresa show");

        assertInstanceOf(VirtualStoreDTO.class, new VirtualStoreDTO(virtualStore));
	}

    @Test
	@Order(3)
    @Tag("convert_method")
    @DisplayName("Convert VirtualStoreDTO to VirtualStoreModel")
	void virtualStoreDTOToVirtualStoreModel() {
		try {
            VirtualStoreDTO virtualStoreDTO = new VirtualStoreDTO();
            virtualStoreDTO.setCnpj("11.111.111/0001-11");
            virtualStoreDTO.setName("Empresa show");
            virtualStoreDTO.setSegment("É show");
            virtualStoreDTO.setPhone("(00)0.0000-0000");
            virtualStoreDTO.setUrl("www.show.com");
            virtualStoreDTO.setRating(10);

			assertInstanceOf(VirtualStoreModel.class, VirtualStoreDTO.convertDTO(virtualStoreDTO));	
		} catch(Error e) {
            System.out.println(e.getMessage());
		}
	}

    @Test
	@Order(4)
    @Tag("convert_method")
    @DisplayName("Convert VirtualStoreDTO to VirtualStoreModel less attribute")
	void virtualStoreDTOToVirtualStoreModelLessAttribute() {
        VirtualStoreDTO virtualStoreDTO = new VirtualStoreDTO();
        virtualStoreDTO.setCnpj("11.111.111/0001-11");
        virtualStoreDTO.setName("Empresa show");
        virtualStoreDTO.setSegment("É show");

        assertInstanceOf(VirtualStoreModel.class, VirtualStoreDTO.convertDTO(virtualStoreDTO));	
	}
}
