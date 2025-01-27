package csc.truong.assignment2.dao;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import csc.truong.assignment2.model.Student;

public class StudentDaoImpl implements StudentDAO {
	
	private SessionFactory sessionFactory;
	
	public void create(Student student) {
		Session session = getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
	}

	public Student getStudent(Integer id) {
		Session session = getSessionFactory().openSession();
		Student student = (Student) session.get(Student.class, id);
		session.close();
		return student;
	}
	
	public List<Student> listStudents() {
		Session session = getSessionFactory().openSession();
        List<Student> list = session.createQuery("from Student").list();
        Hibernate.initialize(list);
        session.close();
        return list;
	}

	public void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Student student = (Student) session.get(Student.class, id);
		session.delete(student);
		tx.commit();
		session.close();
	}

	public void update(Student student) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);;
		tx.commit();
		session.close();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
