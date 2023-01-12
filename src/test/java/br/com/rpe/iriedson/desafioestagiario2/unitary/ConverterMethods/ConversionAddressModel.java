package br.com.rpe.iriedson.desafioestagiario2.unitary.ConverterMethods;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressDTO;
import br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore.Address.AddressModel;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConversionAddressModel {
    
    @Test
	@Order(1)
    @Tag("convert_method")
    @DisplayName("Convert AddressModel to AddressDTO")
	void addressToAddressDTO() {
		try {
            AddressModel address = new AddressModel();
            address.setCep("55555-555");
            address.setCity("Coxixola");
            address.setStreet("Rua legal");
            address.setUf("PB");
            address.setNumber(2);

			assertInstanceOf(AddressDTO.class, new AddressDTO(address));
			
		} catch(Error e) {
            System.out.println(e.getMessage());
		}
	}

    @Test
	@Order(2)
    @Tag("convert_method")
    @DisplayName("Convert AddressModel to AddressDTO less attribute")
	void addressToAddressDTOLessAttribute() {
        AddressModel address = new AddressModel();
        address.setCep("55555-555");

        assertInstanceOf(AddressDTO.class, new AddressDTO(address));
	}

    @Test
	@Order(3)
    @Tag("convert_method")
    @DisplayName("Convert AddressDTO to AddressModel")
	void AddressDTOToAddressModel() {
		try {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setCep("55555-555");
            addressDTO.setCity("Coxixola");
            addressDTO.setStreet("Rua legal");
            addressDTO.setUf("PB");
            addressDTO.setNumber(2);;

			assertInstanceOf(AddressModel.class, AddressDTO.convertDTO(addressDTO));	
		} catch(Error e) {
            System.out.println(e.getMessage());
		}
	}

    @Test
	@Order(4)
    @Tag("convert_method")
    @DisplayName("Convert AddressDTO to AddressModel less attribute")
	void AddressDTOToAddressModelLessAttribute() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCep("55555-555");

        assertInstanceOf(AddressModel.class, AddressDTO.convertDTO(addressDTO));	
	}

}
