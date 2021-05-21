package one.digitalinnovation.apirestful.controller;

import one.digitalinnovation.apirestful.dto.Soldier;
import one.digitalinnovation.apirestful.service.SoldierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldier")
public class SoldierController {

    private final SoldierService service;

    public SoldierController(SoldierService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Soldier>> getSoldiers() {
        List<Soldier> soldiers = service.getSoldiers();
        return ResponseEntity.status(HttpStatus.OK).body(soldiers);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Soldier> getSoldier(@PathVariable String cpf) {
        Soldier soldier = service.getSoldier(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(soldier);
    }

    @PostMapping
    public ResponseEntity<Soldier> createSoldier(@RequestBody Soldier soldier) {
        service.createSoldier(soldier);
        return ResponseEntity.status(HttpStatus.CREATED).body(soldier);
    }

    @PutMapping("/{cpf")
    public ResponseEntity<Soldier> editSoldier(@PathVariable String cpf,
                                               @RequestBody Soldier soldier) {
        service.editSoldier(cpf, soldier);
        return ResponseEntity.status(HttpStatus.OK).body(soldier);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deleteSoldier(@PathVariable String cpf) {
        service.deleteSoldier(cpf);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
