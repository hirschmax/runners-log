package com.github.hirschmax.persistence;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@Entity
@Table(name = "shoes")
@EqualsAndHashCode
public class ShoesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    private RunnerEntity runner;
    @Column(name = "brand")
    private String brand;
    @Column(name = "label")
    private String label;
    @Column(name = "active")
    private boolean active;
}


