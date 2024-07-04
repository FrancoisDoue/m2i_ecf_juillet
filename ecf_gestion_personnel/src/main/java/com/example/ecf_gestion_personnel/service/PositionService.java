package com.example.ecf_gestion_personnel.service;

import com.example.ecf_gestion_personnel.model.Position;
import com.example.ecf_gestion_personnel.repository.impl.PositionRepository;
import com.example.ecf_gestion_personnel.util.HibernateManager;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService() {
        this.positionRepository = new PositionRepository(HibernateManager.getFactory());
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Position getPositionById(int id) {
        return positionRepository.find(id);
    }

    public Position createPosition(Position position) {
        return positionRepository.create(position);
    }

    public Position updatePosition(int id, Position position) {
        position.setId(id);
        return positionRepository.update(position);
    }

    public void deletePosition(int id) {
        positionRepository.delete(
                positionRepository.find(id)
        );
    }
}
