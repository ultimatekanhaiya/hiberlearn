package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.util.HibernateUtils;

public class DeleteApp {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtils.getSessionfactory();

		if (sf != null) {

			// delete student record from DB
			Session s = sf.openSession();
			Student st = s.get(Student.class, 302);
			s.beginTransaction();
			s.delete(st);
			s.getTransaction().commit();
			s.close();
		}

	}

}
