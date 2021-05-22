package one.digitalinnovation.apirestful.controller;

import one.digitalinnovation.apirestful.controller.response.SoldierListResponse;
import one.digitalinnovation.apirestful.controller.response.SoldierResponse;
import one.digitalinnovation.apirestful.dto.SoldierDTO;
import one.digitalinnovation.apirestful.service.SoldierService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/soldier")
public class SoldierController {

    private final SoldierService soldierService;

    public SoldierController(SoldierService soldierService) {
        this.soldierService = soldierService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<SoldierListResponse>> getSoldiers() {
        CollectionModel<SoldierListResponse> soldierListResponse = soldierService.getSoldiers();
        return ResponseEntity.status(HttpStatus.OK).body(soldierListResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldierResponse> getSoldier(@PathVariable Long id) {
        SoldierResponse soldierResponse = soldierService.getSoldier(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldierResponse);
    }

    @PostMapping
    public ResponseEntity<SoldierDTO> createSoldier(@RequestBody SoldierDTO soldierDTO) {
        soldierService.createSoldier(soldierDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(soldierDTO);
    }

    @PutMapping("/{cpf")
    public ResponseEntity<SoldierDTO> editSoldier(@PathVariable String cpf,
                                                  @RequestBody SoldierDTO soldierDTO) {
        soldierService.editSoldier(cpf, soldierDTO);
        return ResponseEntity.status(HttpStatus.OK).body(soldierDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SoldierResponse> deleteSoldier(@PathVariable Long id) {
        SoldierResponse soldierResponse = soldierService.getSoldier(id);
        soldierService.deleteSoldier(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(soldierResponse);
    }

    @PutMapping("/front-castle/{id}")
    public ResponseEntity<SoldierResponse> frontCastle(@PathVariable Long id) {
        SoldierResponse soldierResponse = soldierService.getSoldier(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldierResponse);
    }
}
