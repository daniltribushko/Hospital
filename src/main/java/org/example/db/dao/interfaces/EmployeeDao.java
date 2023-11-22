package org.example.db.dao.interfaces;

import org.example.db.entities.EmployeeEntity;
import org.example.models.enums.EmployeeType;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao extends Dao<EmployeeEntity> {
    /**
     * Получение работника по фамилии и имени
     *
     * @param sureName фамилия
     * @param name имя
     * @return работника в виде Optional
     */
    Optional<EmployeeEntity> findBySureNameAndName(String sureName, String name);

    /**
     * Получение работников по их типу
     *
     * @param type тип работника
     * @return список работников
     */
    List<EmployeeEntity> findAllByEmployeeType(EmployeeType type);
}
