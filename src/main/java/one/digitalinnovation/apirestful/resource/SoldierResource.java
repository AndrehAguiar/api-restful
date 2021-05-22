package one.digitalinnovation.apirestful.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import one.digitalinnovation.apirestful.controller.SoldierController;
import one.digitalinnovation.apirestful.controller.response.SoldierListResponse;
import one.digitalinnovation.apirestful.controller.response.SoldierResponse;
import one.digitalinnovation.apirestful.entity.SoldierEntity;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SoldierResource {

    private final ObjectMapper objectMapper;

    public SoldierResource(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SoldierListResponse createLink(SoldierEntity soldierEntity) {
        SoldierListResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierListResponse.class);
        Link link = linkTo(methodOn(SoldierController.class).getSoldier(soldierEntity.getId())).withSelfRel();
        soldierListResponse.add(link);
        return soldierListResponse;
    }

    public SoldierResponse createLinkDetail(SoldierEntity soldierEntity) {
        SoldierResponse soldierResponse = objectMapper.convertValue(soldierEntity, SoldierResponse.class);
        if (soldierEntity.getStatus().equals("morto")) {
            Link link = linkTo(methodOn(SoldierController.class).deleteSoldier(soldierEntity.getId()))
                    .withRel("remove")
                    .withTitle("Delete Soldier")
                    .withType("delete");
            soldierResponse.add(link);
        } else if (soldierEntity.getStatus().equals("vivo")) {
            Link link = linkTo(methodOn(SoldierController.class).frontCastle(soldierEntity.getId()))
                    .withRel("battle")
                    .withTitle("Go to the castle front")
                    .withType("put");
            soldierResponse.add(link);
        }
        return soldierResponse;
    }
}
