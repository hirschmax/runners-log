package com.github.hirschmax.model;

import com.github.hirschmax.persistence.ShoesEntity;

import java.util.UUID;

public record Shoes(UUID id, String brand, String label, boolean active) {
    public Shoes(ShoesEntity entity) {
        this(UUID.fromString(entity.getId()), entity.getBrand(), entity.getLabel(), entity.isActive());
    }
}
