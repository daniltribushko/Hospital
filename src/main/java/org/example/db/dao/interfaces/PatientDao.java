package org.example.db.dao.interfaces;

import org.example.db.entities.PatientEntity;

import java.util.Optional;

public interface PatientDao extends Dao<PatientEntity> {
    Optional<PatientEntity> findBySureNameAndName(String sureName, String name);
}
