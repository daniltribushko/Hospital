package org.example.services.interfaces;

import org.example.db.entities.WardEntity;

import java.util.List;
import java.util.Optional;

public interface WardDbService {
    boolean save(WardEntity ward);
    boolean update(WardEntity ward);
    Optional<WardEntity> get(Long id);
    boolean delete(Long id);
    List<WardEntity> findAll();
}
