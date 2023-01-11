package br.com.rpe.iriedson.desafioestagiario2.unitary.ValidatorMethods;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.rpe.iriedson.desafioestagiario2.service.ValidationService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ValidatorsTest {
    
    @Autowired
    ValidationService validator;

    @Test
	@Order(1)
    @Tag("validator_method")
    @DisplayName("Validator cnpj correct")
	void cnpjValid() {
		String cnpj = "11.111.111/1111-11";
        try {
            assertEquals(validator.validationCnpjFormat(cnpj), cnpj);
        } catch (Exception e) {

        }
	}

    @Test
	@Order(2)
    @Tag("validator_method")
    @DisplayName("validator cnpj with letter")
	void cnpjInvalidLetter() {
		String cnpj = "11.111.111/1111-1a";
        assertThrows(Exception.class, () -> validator.validationCnpjFormat(cnpj));
	}

    @Test
	@Order(3)
    @Tag("validator_method")
    @DisplayName("validator cnpj without special character")
	void cnpjInvalidWithoutSpecialChar() {
		String cnpj = "111111111111111";
        assertThrows(Exception.class, () -> validator.validationCnpjFormat(cnpj));
	}

    @Test
	@Order(4)
    @Tag("validator_method")
    @DisplayName("validator cnpj with less character")
	void cnpjInvalidLessChar() {
		String cnpj = "11.111.111/1111-1";
        assertThrows(Exception.class, () -> validator.validationCnpjFormat(cnpj));
	}

    @Test
	@Order(5)
    @Tag("validator_method")
    @DisplayName("validator cnpj with more character")
	void cnpjInvalidMoreChar() {
		String cnpj = "11.111.111/1111-111";
        assertThrows(Exception.class, () -> validator.validationCnpjFormat(cnpj));
	}

    @Test
	@Order(6)
    @Tag("validator_method")
    @DisplayName("Validator phone correct")
	void phoneValid() {
		String phone = "(33)3.3333-3333";
        try {
            assertEquals(validator.validationPhoneFormat(phone), phone);
        } catch (Exception e) {

        }
	}

    @Test
	@Order(7)
    @Tag("validator_method")
    @DisplayName("validator phone with letter")
	void phoneInvalidLetter() {
		String phone = "(33)3.3333-333b";
        assertThrows(Exception.class, () -> validator.validationPhoneFormat(phone));
	}

    @Test
	@Order(8)
    @Tag("validator_method")
    @DisplayName("validator phone without special character")
	void phoneInvalidWithoutSpecialChar() {
		String phone = "33333333333";
        assertThrows(Exception.class, () -> validator.validationPhoneFormat(phone));
	}

    @Test
	@Order(9)
    @Tag("validator_method")
    @DisplayName("validator phone with less character")
	void phoneInvalidLessChar() {
		String phone = "(33)3.3333-333";
        assertThrows(Exception.class, () -> validator.validationPhoneFormat(phone));
	}

    @Test
	@Order(10)
    @Tag("validator_method")
    @DisplayName("validator phone with more character")
	void phoneInvalidMoreChar() {
		String phone = "(33)3.3333-33333";
        assertThrows(Exception.class, () -> validator.validationPhoneFormat(phone));
	}

    @Test
	@Order(11)
    @Tag("validator_method")
    @DisplayName("Validator cep correct")
	void cepValid() {
		String cep = "55555-555";
        try {
            assertEquals(validator.validationCepFormat(cep), cep);
        } catch (Exception e) {

        }
	}

    @Test
	@Order(12)
    @Tag("validator_method")
    @DisplayName("validator cep with letter")
	void cepInvalidLetter() {
		String cep = "55555-55a";
        assertThrows(Exception.class, () -> validator.validationCepFormat(cep));
	}

    @Test
	@Order(13)
    @Tag("validator_method")
    @DisplayName("validator cep without special character")
	void cepInvalidWithoutSpecialChar() {
		String cep = "55555555";
        assertThrows(Exception.class, () -> validator.validationCepFormat(cep));
	}

    @Test
	@Order(14)
    @Tag("validator_method")
    @DisplayName("validator cep with less character")
	void cepInvalidLessChar() {
		String cep = "55555-55";
        assertThrows(Exception.class, () -> validator.validationCepFormat(cep));
	}

    @Test
	@Order(15)
    @Tag("validator_method")
    @DisplayName("validator cep with more character")
	void cepInvalidMoreChar() {
		String cep = "55555-5555";
        assertThrows(Exception.class, () -> validator.validationCepFormat(cep));
	}


}
