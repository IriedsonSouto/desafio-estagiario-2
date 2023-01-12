package br.com.rpe.iriedson.desafioestagiario2.entity.Store.PhysicalStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/physical-store")
public class PhysicalStoreController {

    @Autowired
    private PhysicalStoreService physicalStoreService;

    @PostMapping
    public ResponseEntity create(@RequestBody PhysicalStoreDTO physicalStoreDTO) {
        try{
            PhysicalStoreModel result = this.physicalStoreService.create(physicalStoreDTO);
            return ResponseEntity.status(201).body(new PhysicalStoreDTO(result));
        }catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
    }

    @GetMapping
    public ResponseEntity<List<PhysicalStoreDTO>> findAll(){
        List<PhysicalStoreModel> result = this.physicalStoreService.readAll();
        return ResponseEntity.status(200).body(PhysicalStoreDTO.convert(result));
    }

    @GetMapping("/get-by-uuid/{uuid}")
    public ResponseEntity<PhysicalStoreDTO> find(@PathVariable("uuid") String uuid) {
        try{
            PhysicalStoreModel result = this.physicalStoreService.readByUuid(uuid);
            return ResponseEntity.status(200).body(new PhysicalStoreDTO(result));
        }catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/get-by-cnpj/{cnpj}")
    public ResponseEntity<PhysicalStoreDTO> findByCnpj(@RequestParam("cnpj") String cnpj) {
        try{
            PhysicalStoreModel result = this.physicalStoreService.readByCnpj(cnpj);
            return ResponseEntity.status(200).body(new PhysicalStoreDTO(result));
        }catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/get-by-phone/{phone}")
    public ResponseEntity<PhysicalStoreDTO> findByPhone(@RequestParam("phone") String phone) {
        try{
            PhysicalStoreModel result = this.physicalStoreService.readByPhone(phone);
            return ResponseEntity.status(200).body(new PhysicalStoreDTO(result));
        }catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @GetMapping("/get-by-address/{cep}-{numer}")
    public ResponseEntity<PhysicalStoreDTO> findByCepAndNumer(@RequestParam("cep") String cep,
                                                            @RequestParam("numer") Integer numer) {
        try{
            PhysicalStoreModel result = this.physicalStoreService.readByCepAndNumer(cep, numer);
            return ResponseEntity.status(200).body(new PhysicalStoreDTO(result));
        }catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/{uuid}")
    public ResponseEntity update(@RequestBody PhysicalStoreDTO physicalStoreDTO, @PathVariable("uuid") String uuid) {
        try{
            PhysicalStoreModel result = this.physicalStoreService.update(physicalStoreDTO, uuid);
            return ResponseEntity.status(200).body(new PhysicalStoreDTO(result));
        }catch (Exception e) {
			return ResponseEntity.status(404).body(physicalStoreDTO);
		}
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> delete(@PathVariable("uuid") String uuid){
        boolean result = this.physicalStoreService.delete(uuid);
        if(result){
            return  ResponseEntity.status(200).body("OK");
        }
        return ResponseEntity.status(404).body("NOT OK");
    }

}
