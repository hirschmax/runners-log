package com.github.hirschmax.persistence;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "runner")
@EqualsAndHashCode
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @OneToMany(mappedBy = "runner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShoesEntity> shoes = new ArrayList<>();
}


