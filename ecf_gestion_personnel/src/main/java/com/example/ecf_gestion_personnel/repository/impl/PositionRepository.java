package com.example.ecf_gestion_personnel.repository.impl;

import com.example.ecf_gestion_personnel.model.Position;
import com.example.ecf_gestion_personnel.repository.AbstractRepository;
import org.hibernate.SessionFactory;

import java.util.List;

public class PositionRepository extends AbstractRepository<Position, Integer> {

    public PositionRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Position find(Integer id) {
        session = sessionFactory.openSession();
        Position position = session.get(Position.class, id);
        session.close();
        return position;
    }

    @Override
    public List<Position> findAll() {
        session = sessionFactory.openSession();
        List<Position> positions = session.createQuery("from Position", Position.class).list();
        session.close();
        return positions;
    }

}
