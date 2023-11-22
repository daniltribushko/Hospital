package org.example.db.dao;

import org.example.db.HibernateUtil;
import org.example.db.dao.interfaces.Dao;
import org.example.db.dao.interfaces.PatientDao;
import org.example.db.entities.PatientEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PatientDaoImp implements PatientDao {
    @Override
    public Optional<PatientEntity> findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Optional<PatientEntity> result = Optional.ofNullable(
                session.get(PatientEntity.class, id)
        );
        session.close();

        return result;
    }

    @Override
    public void save(PatientEntity object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.persist(object);
        session.close();
    }

    @Override
    public void update(PatientEntity object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.merge(object);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(PatientEntity object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.remove(object);
        transaction.commit();
        session.close();
    }

    @Override
    public List<PatientEntity> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PatientEntity> result = session.createQuery("from PatientEntity", PatientEntity.class)
                .getResultList();
        session.close();

        return result;
    }

    @Override
    public Optional<PatientEntity> findBySureNameAndName(String sureName, String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Optional<PatientEntity> patient = session.createQuery(
                String.format("from PatientEntity p where p.sureName='%s' and p.name='%s'",
                        sureName,
                        name), PatientEntity.class)
                .uniqueResultOptional();
        session.close();

        return patient;
    }
}
