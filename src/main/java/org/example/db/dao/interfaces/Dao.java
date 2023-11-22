package org.example.db.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    /**
     * Получение сущности по id
     *
     * @param id id сущности
     * @return сущность в виде Optional
     */
    Optional<T> findById(Long id);

    /**
     * Сохранение сущности в бд
     *
     * @param object сущность
     */
    void save(T object);

    /**
     * Обновление сущности в бд
     *
     * @param object сущность
     */
    void update(T object);

    /**
     * Удаление сещности из бд
     *
     * @param object сущность дб
     */
    void delete(T object);

    /**
     * Получение всех сущностей из бд
     *
     * @return список сущностей
     */
    List<T> findAll();
}
