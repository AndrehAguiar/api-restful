package one.digitalinnovation.apirestful.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import one.digitalinnovation.apirestful.dto.SoldierDTO;
import org.springframework.hateoas.RepresentationModel;

public class SoldierListResponse extends RepresentationModel<SoldierDTO> {

    private Long id;
    private String name;
    private String breed;

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
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
}
