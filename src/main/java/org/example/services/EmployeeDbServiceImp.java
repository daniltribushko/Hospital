package org.example.services;

import org.example.db.dao.EmployeeDaoImp;
import org.example.db.dao.interfaces.EmployeeDao;
import org.example.db.entities.EmployeeEntity;
import org.example.services.interfaces.EmployeeDbService;

import java.util.List;
import java.util.Optional;

public class EmployeeDbServiceImp implements EmployeeDbService {
    private final EmployeeDao employeeDao;

    public EmployeeDbServiceImp() {
        employeeDao = new EmployeeDaoImp();
    }

    @Override
    public boolean save(EmployeeEntity employee) {
        boolean result = true;
        try {
            EmployeeEntity employeeEntity = employeeDao.findBySureNameAndName(
                            employee.getSureName(),
                            employee.getName()
                    )
                    .orElse(null);
            if (employeeEntity == null) {
                employeeDao.save(employee);
                System.out.println(employee);
            } else {
                result = false;
                System.out.println("!ОШИБКА! - Такой работник уже сохранён");
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(String sureName, String name) {
        boolean result = true;
        try {
            EmployeeEntity employee = employeeDao.findBySureNameAndName(sureName, name)
                    .orElse(null);
            if (employee != null) {
                employeeDao.delete(employee);
            } else {
                System.out.println("Работник не найден");
                result = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }

    @Override
    public boolean update(EmployeeEntity employee) {
        boolean result = true;
        EmployeeEntity employeeEntity = employeeDao.findBySureNameAndName(
                employee.getSureName(),
                employee.getName()
        ).orElse(null);
        if (employeeEntity != null) {
            employee.setId(employeeEntity.getId());
            employeeDao.update(employee);
        } else {
            System.out.println("Работник не найден");
            result = false;
        }


        return result;
    }

    @Override
    public Optional<EmployeeEntity> get(String sureName, String name) {
        return employeeDao.findBySureNameAndName(sureName, name);
    }

    @Override
    public List<EmployeeEntity> getAll() {
        return employeeDao.findAll();
    }
}
