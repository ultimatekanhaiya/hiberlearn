package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.util.HibernateUtils;

public class ReadApp {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtils.getSessionfactory();

		if (sf != null) {
			
			// Initializing Student obj
			Student st = new Student();

			// Reading student record from DB
			Session s = sf.openSession();
			// s.beginTransaction();
			st = s.get(Student.class, 2);
			// s.getTransaction().commit();
			s.close();

			System.out.println(st);
		}

	}
}
