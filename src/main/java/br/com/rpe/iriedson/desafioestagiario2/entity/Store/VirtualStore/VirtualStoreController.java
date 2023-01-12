package br.com.rpe.iriedson.desafioestagiario2.entity.Store.VirtualStore;

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

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/virtual-store")
public class VirtualStoreController {

    @Autowired
    private VirtualStoreService virtualStoreService;

    @Operation(summary = "Create new Virtual Store", description = "CNPJ format: XX.XXX.XXX/XXXX-XX, Phone format: (XX)X.XXXX-XXXX" )
    @PostMapping
    public ResponseEntity create(@RequestBody VirtualStoreDTO virtualStoreDTO) {
        try{
            VirtualStoreModel result = this.virtualStoreService.create(virtualStoreDTO);
            return ResponseEntity.status(201).body(new VirtualStoreDTO(result));
        }catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
    }

    @Operation(summary = "Search all Virtual Store")
    @GetMapping
    public ResponseEntity<List<VirtualStoreDTO>> findAll(){
        List<VirtualStoreModel> result = this.virtualStoreService.readAll();
        return ResponseEntity.status(200).body(VirtualStoreDTO.convert(result));
    }

    @Operation(summary = "Search a Virtual Store by unique identifier")
    @GetMapping("/get-by-uuid/{uuid}")
    public ResponseEntity<VirtualStoreDTO> find(@PathVariable("uuid") String uuid) {
        try{
            VirtualStoreModel result = this.virtualStoreService.readByUuid(uuid);
            return ResponseEntity.status(200).body(new VirtualStoreDTO(result));
        }catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @Operation(summary = "Search a Virtual Store by cnpj", description = "CNPJ format: XX.XXX.XXX/XXXX-XX")
    @GetMapping("/get-by-cnpj/{cnpj}")
    public ResponseEntity<VirtualStoreDTO> findByCnpj(@RequestParam("cnpj") String cnpj) {
        try{
            VirtualStoreModel result = this.virtualStoreService.readByCnpj(cnpj);
            return ResponseEntity.status(200).body(new VirtualStoreDTO(result));
        }catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @Operation(summary = "Search a Virtual Store by phone", description = "Phone format: (XX)X.XXXX-XXXX")
    @GetMapping("/get-by-phone/{phone}")
    public ResponseEntity<VirtualStoreDTO> findByPhone(@RequestParam("phone") String phone) {
        try{
            VirtualStoreModel result = this.virtualStoreService.readByPhone(phone);
            return ResponseEntity.status(200).body(new VirtualStoreDTO(result));
        }catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @Operation(summary = "Search a Virtual Store by url")
    @GetMapping("/get-by-url/{url}")
    public ResponseEntity<VirtualStoreDTO> findByUrl(@RequestParam("url") String url) {
        try{
            VirtualStoreModel result = this.virtualStoreService.readByUrl(url);
            return ResponseEntity.status(200).body(new VirtualStoreDTO(result));
        }catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @Operation(summary = "Update a Virtual Store", description = "CNPJ format: XX.XXX.XXX/XXXX-XX, Phone format: (XX)X.XXXX-XXXX" )
    @PutMapping("/{uuid}")
    public ResponseEntity update(@RequestBody VirtualStoreDTO virtualStoreDTO, @PathVariable("uuid") String uuid) {
        try{
            VirtualStoreModel result = this.virtualStoreService.update(virtualStoreDTO, uuid);
            return ResponseEntity.status(200).body(new VirtualStoreDTO(result));
        }catch (Exception e) {
			return ResponseEntity.status(404).body(virtualStoreDTO);
		}
    }

    @Operation(summary = "Delete a Virtual Store")
    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> delete(@PathVariable("uuid") String uuid){
        boolean result = this.virtualStoreService.delete(uuid);
        if(result){
            return  ResponseEntity.status(200).body("OK");
        }
        return ResponseEntity.status(404).body("NOT OK");
    }

}
