package org.example.services;

import org.example.db.dao.PatientDaoImp;
import org.example.db.dao.interfaces.PatientDao;
import org.example.db.entities.PatientEntity;
import org.example.services.interfaces.PatientDbService;

import java.util.List;
import java.util.Optional;

public class PatientDbServiceImp implements PatientDbService {
    private final PatientDao dao = new PatientDaoImp();

    @Override
    public boolean save(PatientEntity patient) {
        boolean result = true;
        PatientEntity patientEntity = dao.findBySureNameAndName(patient.getSureName(), patient.getName())
                .orElse(null);
        if (patientEntity != null) {
            System.out.println("Такой пациент уже сохранен в бд");
            return false;
        } else {
            if (patient.getAge() < 0) {
                System.out.println("Возраст не может быть меньше 0");
                result = false;
            } else {
                dao.save(patient);
            }
        }

        return result;
    }

    @Override
    public boolean update(PatientEntity patient) {
        boolean result = true;
        Integer age = patient.getAge();
        PatientEntity patientEntity = dao.findBySureNameAndName(patient.getSureName(), patient.getName())
                .orElse(null);
        if (patientEntity != null) {
            if (age < 18) {
                System.out.println("Возраст не может быть меньше 0");
                return false;
            } else if (age < patientEntity.getAge()) {
                System.out.println("Новый возраст не может быть меньше старого");
                return false;
            } else {
                patientEntity.setAge(age);
            }
            patientEntity.setId(patientEntity.getId());
            dao.update(patient);
        } else {
            System.out.println("пациент не найден");
            result = false;
        }

        return result;
    }

    @Override
    public boolean delete(String sureName, String name) {
        boolean result = true;
        PatientEntity patient = dao.findBySureNameAndName(sureName, name).orElse(null);
        if (patient != null) {
            dao.delete(patient);
        } else {
            System.out.println("Пациент не найден");
            result = false;
        }

        return result;
    }

    @Override
    public Optional<PatientEntity> get(String sureName, String name) {
        return dao.findBySureNameAndName(sureName, name);
    }

    @Override
    public List<PatientEntity> getAll() {
        return dao.findAll();
    }
}
