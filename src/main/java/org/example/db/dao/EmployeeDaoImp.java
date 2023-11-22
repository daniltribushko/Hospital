package org.example.db.dao;

import org.example.db.HibernateUtil;
import org.example.db.dao.interfaces.EmployeeDao;
import org.example.db.entities.EmployeeEntity;
import org.example.models.enums.EmployeeType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class EmployeeDaoImp implements EmployeeDao {
    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return Optional.ofNullable(HibernateUtil
                .getSessionFactory()
                .openSession()
                .get(EmployeeEntity.class, id)
        );
    }
    @Override
    public Optional<EmployeeEntity> findBySureNameAndName(String sureName, String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Optional<EmployeeEntity> employee = session
                .createQuery(
                        String.format("from EmployeeEntity e where e.sureName='%s' and e.name='%s'", sureName, name),
                        EmployeeEntity.class).uniqueResultOptional();

        session.close();
        return employee;
    }

    @Override
    public List<EmployeeEntity> findAllByEmployeeType(EmployeeType type) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<EmployeeEntity> result = session
                .createQuery(String.format("from EmployeeEntity e where e.type='%s'", type), EmployeeEntity.class)
                .getResultList();
       session.close();

       return result;
    }

    @Override
    public void save(EmployeeEntity object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.save(object);
        session.close();
    }
    @Override
    public void update(EmployeeEntity object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(object);
        tx1.commit();
        session.close();
    }
    @Override
    public void delete(EmployeeEntity object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(object);
        tx1.commit();
        session.close();
    }
    @Override
    public List<EmployeeEntity> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<EmployeeEntity> result = session.createQuery(
                        "from EmployeeEntity",
                        EmployeeEntity.class)
                .getResultList();
        session.close();
        return result;
    }
}
