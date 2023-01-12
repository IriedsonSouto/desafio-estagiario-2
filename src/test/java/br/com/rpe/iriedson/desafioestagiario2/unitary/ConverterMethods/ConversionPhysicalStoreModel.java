package br.com.rpe.iriedson.desafioestagiario2.unitary.ConverterMethods;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.PhysicalStoreDTO;
import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.PhysicalStoreModel;
import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressDTO;
import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressModel;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConversionPhysicalStoreModel {
    
    @Test
	@Order(1)
    @Tag("convert_method")
    @DisplayName("Convert PhysicalStoreModel to PhysicalStoreDTO")
	void physicalStoreToPhysicalStoreDTO() {
		try {
            AddressModel address = new AddressModel();
            address.setCep("55555-555");
            address.setCity("Coxixola");
            address.setStreet("Rua legal");
            address.setUf("PB");
            address.setNumber(2);

            PhysicalStoreModel physicalStore = new PhysicalStoreModel();
            physicalStore.setCnpj("11.111.111/0001-11");
            physicalStore.setName("Empresa show");
            physicalStore.setSegment("É show");
            physicalStore.setPhone("(00)0.0000-0000");
            physicalStore.setAddress(address);
            physicalStore.setNumEmployees(5);

			assertInstanceOf(PhysicalStoreDTO.class, new PhysicalStoreDTO(physicalStore));	
		} catch(Error e) {
            System.out.println(e.getMessage());
		}
	}

    @Test
	@Order(2)
    @Tag("convert_method")
    @DisplayName("Convert physicalStoreModel to physicalStoreDTO less attribute")
	void physicalStoreToPhysicalStoreDTOLessAttribute() {
        PhysicalStoreModel physicalStore = new PhysicalStoreModel();
        physicalStore.setCnpj("11.111.111/0001-11");
        physicalStore.setName("Empresa show");

        assertInstanceOf(PhysicalStoreDTO.class, new PhysicalStoreDTO(physicalStore));
	}

    @Test
	@Order(3)
    @Tag("convert_method")
    @DisplayName("Convert PhysicalStoreDTO to PhysicalStoreModel")
	void physicalStoreDTOToPhysicalStoreModel() {
		try {
            AddressDTO address = new AddressDTO();
            address.setCep("55555-555");
            address.setCity("Coxixola");
            address.setStreet("Rua legal");
            address.setUf("PB");
            address.setNumber(2);

            PhysicalStoreDTO physicalStoreDTO = new PhysicalStoreDTO();
            physicalStoreDTO.setCnpj("11.111.111/0001-11");
            physicalStoreDTO.setName("Empresa show");
            physicalStoreDTO.setSegment("É show");
            physicalStoreDTO.setPhone("(00)0.0000-0000");
            physicalStoreDTO.setAddress(address);
            physicalStoreDTO.setNumEmployees(5);

			assertInstanceOf(PhysicalStoreModel.class, PhysicalStoreDTO.convertDTO(physicalStoreDTO));	
		} catch(Error e) {
            System.out.println(e.getMessage());
		}
	}

    @Test
	@Order(4)
    @Tag("convert_method")
    @DisplayName("Convert PhysicalStoreDTO to PhysicalStoreModel less attribute")
	void physicalStoreDTOToPhysicalStoreModelLessAttribute() {
        PhysicalStoreDTO physicalStoreDTO = new PhysicalStoreDTO();
        physicalStoreDTO.setCnpj("11.111.111/0001-11");
        physicalStoreDTO.setName("Empresa show");
        physicalStoreDTO.setSegment("É show");

        assertThrows(Exception.class, () -> PhysicalStoreDTO.convertDTO(physicalStoreDTO));
	}

}
