package org.example.db.dao;

import org.example.db.HibernateUtil;
import org.example.db.dao.interfaces.WardDao;
import org.example.db.entities.WardEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class WardDaoImp implements WardDao {
    @Override
    public Optional<WardEntity> findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Optional<WardEntity> ward = Optional.ofNullable(session.get(WardEntity.class, id));
        session.close();

        return ward;
    }

    @Override
    public void save(WardEntity object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.persist(object);
        session.close();
    }

    @Override
    public void update(WardEntity object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.merge(object);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(WardEntity object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        session.remove(object);
        transaction.commit();
        session.close();
    }

    @Override
    public List<WardEntity> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<WardEntity> result = session.createQuery("from WardEntity", WardEntity.class).getResultList();
        session.close();

        return result;
    }

    @Override
    public List<WardEntity> findAllByFull(boolean full) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<WardEntity> result = session.createQuery(
                String.format("FROM WardEntity e where e.full=%s", full),
                WardEntity.class)
                .getResultList();
        session.close();

        return result;
    }
}
