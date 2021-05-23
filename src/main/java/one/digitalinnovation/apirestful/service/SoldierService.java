package one.digitalinnovation.apirestful.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import one.digitalinnovation.apirestful.controller.response.SoldierListResponse;
import one.digitalinnovation.apirestful.controller.response.SoldierResponse;
import one.digitalinnovation.apirestful.dto.SoldierDTO;
import one.digitalinnovation.apirestful.entity.SoldierEntity;
import one.digitalinnovation.apirestful.repository.SoldierRepository;
import one.digitalinnovation.apirestful.resource.SoldierResource;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SoldierService {

    private final SoldierRepository soldierRepository;
    private final ObjectMapper objectMapper;
    private final SoldierResource soldierResource;

    public SoldierService(SoldierRepository soldierRepository, ObjectMapper objectMapper, SoldierResource soldierResource) {
        this.soldierRepository = soldierRepository;
        this.objectMapper = objectMapper;
        this.soldierResource = soldierResource;
    }

    public CollectionModel<SoldierListResponse> getSoldiers() {
        return CollectionModel.of(soldierRepository.findAll()
                .stream().map(soldierResource::createLink)
                .collect(Collectors.toList()));
    }

    public SoldierResponse getSoldier(Long id) {
        SoldierEntity soldier = soldierRepository.findById(id).orElseThrow();
        return soldierResource.createLinkDetail(soldier);
    }

    public void createSoldier(SoldierDTO soldierDTO) {
        SoldierEntity soldierEntity = objectMapper.convertValue(soldierDTO, SoldierEntity.class);
        soldierRepository.save(soldierEntity);
    }

    public void editSoldier(Long id, SoldierDTO soldierDTO) {
        SoldierEntity soldierEntity = objectMapper.convertValue(soldierDTO, SoldierEntity.class);
        soldierRepository.save(soldierEntity);
    }

    public void deleteSoldier(Long id) {
        SoldierEntity soldierEntity = soldierRepository.findById(id).orElseThrow();
        soldierRepository.delete(soldierEntity);
    }
}
