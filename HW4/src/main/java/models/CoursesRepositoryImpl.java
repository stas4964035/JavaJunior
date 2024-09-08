package models;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;

public class CoursesRepositoryImpl implements CoursesRepository {
    private Session session;
    private final SessionFactory sessionFactory;



    public CoursesRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Course item) {
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(item);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Course item) {
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(item);
        tx.commit();
        session.close();
    }



    @Override
    public void delete(Course item) {
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.remove(item);
        tx.commit();
        session.close();
    }

    @Override
    public Course getById(Integer id) {
        session = sessionFactory.openSession();
        Course course = (Course) session.get(Course.class, id);
        session.close();
        return course;
    }

    @Override
    public Collection<Course> getAll() {
        session = sessionFactory.openSession();
        List<Course> courses = session.createQuery("from Course").list();
        session.close();
        return courses;
    }



}
