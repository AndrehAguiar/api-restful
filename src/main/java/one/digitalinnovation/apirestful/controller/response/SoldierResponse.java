package one.digitalinnovation.apirestful.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import one.digitalinnovation.apirestful.dto.SoldierDTO;
import org.springframework.hateoas.RepresentationModel;

public class SoldierResponse extends RepresentationModel<SoldierDTO> {

    private Long id;
    private String cpf;
    private String name;
    private String breed;
    private String weapon;
    private String status;

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    @JsonProperty("id")
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
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
