package org.example.services.interfaces;

import org.example.db.entities.PatientEntity;

import java.util.List;
import java.util.Optional;

/**
 * Класс для работы с сущностями пациентов
 */
public interface PatientDbService {
    /**
     * Сохранение пациента в бд
     *
     * @param patient сущность пациента
     * @return true при успешном результате false при ошибке
     */
    boolean save(PatientEntity patient);

    /**
     * Обновление пациента в бд
     *
     * @param patient сущность пациента
     * @return true при успешном результате false при ошибке
     */
    boolean update(PatientEntity patient);

    /**
     * Удаление пациента в бд
     *
     * @param sureName фамилия пациента
     * @param name имя пациента
     * @return true при успешном результате false при ошибке
     */
    boolean delete(String sureName, String name);

    /**
     * Получение пациента по фамилии и имени из бд
     *
     * @param sureName фамилия
     * @param name имя
     * @return п\сущность пациента
     */
    Optional<PatientEntity> get(String sureName, String name);

    /**
     * Получение всех пациентов
     *
     * @return список пациентов
     */
    List<PatientEntity> getAll();
}
