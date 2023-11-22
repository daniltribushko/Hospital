package org.example.services;

import org.example.db.dao.WardDaoImp;
import org.example.db.dao.interfaces.WardDao;
import org.example.db.entities.WardEntity;
import org.example.services.interfaces.WardDbService;

import java.util.List;
import java.util.Optional;

public class WardDbServiceImp implements WardDbService {
    private final WardDao dao = new WardDaoImp();

    @Override
    public boolean save(WardEntity ward) {
        boolean result = true;
        WardEntity wardEntity = dao
                .findById(ward.getId())
                .orElse(null);
        if (wardEntity == null){
            if (ward.getCountHospitalBed() < 1){
                System.out.println("Количество палат не может быть меньше 1");
                result = false;
            } else {
                dao.save(ward);
            }
        }else {
            System.out.println("Палата уже сохранена");
            result = false;
        }

        return result;
    }

    @Override
    public boolean update(WardEntity ward) {
        boolean result = true;
        WardEntity wardEntity = dao.findById(ward.getId()).orElse(null);
        if (wardEntity != null){
            if (ward.getCountHospitalBed() < 0){
                System.out.println("Количество коек не может быть меньше 0");
                result = false;
            } else {
                dao.update(ward);
            }
        }

        return result;
    }

    @Override
    public Optional<WardEntity> get(Long id) {
        return dao.findById(id);
    }

    @Override
    public boolean delete(Long id) {
        boolean result = true;
        WardEntity ward = dao.findById(id).orElse(null);
        if (ward != null){
            dao.delete(ward);
        } else {
            System.out.println("Палата не найдена");
            result = false;
        }

        return result;
    }

    @Override
    public List<WardEntity> findAll() {
        return dao.findAll();
    }
}
