package one.digitalinnovation.apirestful.service;

import one.digitalinnovation.apirestful.dto.Soldier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SoldierService {

    public List<Soldier> getSoldiers() {
        Soldier soldier1 = new Soldier("123456789-10", "Andre", "Human", "Pistol");
        Soldier soldier2 = new Soldier("987654321-00", "Aguiar", "Paladin", "Sword");
        return Arrays.asList(soldier1, soldier2);
    }

    public Soldier getSoldier(String cpf) {
        return new Soldier(cpf, "Andre", "Human", "Pistol");
    }

    public void createSoldier(Soldier soldier) {
    }

    public void editSoldier(String cpf, Soldier soldier) {
    }

    public void deleteSoldier(String cpf) {
    }
}
