package one.digitalinnovation.apirestful.dto;

import one.digitalinnovation.apirestful.enums.Breed;
import org.springframework.hateoas.RepresentationModel;

public class SoldierDTO extends RepresentationModel<SoldierDTO> {
    private Long id;
    private String cpf;
    private String name;
    private Breed breed;
    private String weapon;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
