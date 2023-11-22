package org.example.services.interfaces;

import org.example.db.entities.EmployeeEntity;
import org.example.models.enums.EmployeeType;

import java.util.List;
import java.util.Optional;

public interface EmployeeDbService {
    boolean save(EmployeeEntity employee);
    boolean delete(String sureName, String name);
    boolean update(EmployeeEntity employee);
    Optional<EmployeeEntity> get(String sureName, String name);
    List<EmployeeEntity> getAll();
}
