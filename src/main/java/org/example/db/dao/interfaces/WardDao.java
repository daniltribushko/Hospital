package org.example.db.dao.interfaces;

import org.example.db.entities.WardEntity;

import java.util.List;
import java.util.Optional;

public interface WardDao extends Dao<WardEntity> {
    List<WardEntity> findAllByFull(boolean full);
}
