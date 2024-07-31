package com.hiber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Student;

/**
 * Hello world!
 *
 */
public class App {
	
	private static Logger logger = LogManager.getLogger();
	public static void main(String[] args) {
		System.out.println("Hello World!");

		/*
		 * Configuration is a class It activate/bootstrap Hibernate Framework
		 */
		Configuration configuration = new Configuration();
		//configuration.addAnnotatedClass(Student.class); // java based config but we already using xml based.

		// It read both cfg file and mapping files
		//it will load file automatically we follow the convention else we have to explicitly pass the name
		configuration.configure("hibernate.cfg.xml");

		/*
		 * buildSessionFactory() method gathers the meta-data which is in the
		 * configuration Object. From configuration object it takes the JDBC information
		 * and create a JDBC Connection. SessionFactory is an Interface It is immutable
		 * and thread-safe in nature.
		 */
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		/*
		 * Session is an interface It is a light-weight object and it is not
		 * thread-safe.
		 */
		Session session = sessionFactory.openSession();

		Student student1 = new Student();
		student1.setCity("Goa");
		student1.setName("ram");
		logger.info(student1);

		/*
		 * Transaction object is used whenever we perform any operation and based upon
		 * that operation there is some change in database.
		 * 
		 */
//		Transaction transaction = session.beginTransaction();
//		transaction.commit();
		session.beginTransaction();
		session.persist(student1);
//		session.save(student1);
		session.evict(student1);
//		Integer save = (Integer)session.save(student1);
		session.getTransaction().commit();
		session.close();
		
//		Conclusion : 
//			1. For persist transaction begin is necessary but for save it is not
//			2. Commit is not necessary for saving data to DB  in any persist or save  but session.close() is.
//

	}
}
