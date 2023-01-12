package br.com.rpe.iriedson.desafioestagiario2.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    
    public String validationCnpjFormat(String cnpj) throws Exception {
        final String regex = "\\d\\d\\.\\d\\d\\d\\.\\d\\d\\d\\/\\d\\d\\d\\d\\-\\d\\d";
        
        if(cnpj.matches(regex)) {
        	return cnpj;
		}     
        throw new Exception("Formato do CNPJ invalido, formato esperado: XX.XXX.XXX/XXXX-XX");		
	}

    public String validationPhoneFormat(String phone) throws Exception {
		final String regex = "\\(\\d\\d\\)\\d\\.\\d\\d\\d\\d-\\d\\d\\d\\d";

        if(phone.matches(regex)) {
        	return phone;
		}     
        throw new Exception("Formato do telefone invalido, formato esperado: (XX)X.XXXX-XXXX");		
	}

    public String validationCepFormat(String cep) throws Exception {
		final String regex = "\\d\\d\\d\\d\\d-\\d\\d\\d";

        if(cep.matches(regex)) {
        	return cep;
		}     
        throw new Exception("Formato do cep invalido, formato esperado: XXXXX-XXX");		
	}

}
