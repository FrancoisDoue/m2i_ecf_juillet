package com.example.ecf_gestion_personnel.model.map;

import com.example.ecf_gestion_personnel.model.Position;

public class PositionMapper {
    public static Position toDTO(Position position) {
        return Position.builder()
                .id(position.getId())
                .jobTitle(position.getJobTitle())
                .build();
    }
}
