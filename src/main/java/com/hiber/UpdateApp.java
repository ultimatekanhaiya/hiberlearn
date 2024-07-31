package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.util.HibernateUtils;

public class UpdateApp {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtils.getSessionfactory();

		if (sf != null) {

			// updating student record in DB
			Session s = sf.openSession();

			// getting student from DB first, so we just change only those fields
			// in which we are interested rest all are set to old values
			Student st = s.get(Student.class, 2);
			st.setName("Rahul K");

			s.beginTransaction();
			s.update(st);
			s.getTransaction().commit();
			s.close();

			System.out.println(st);
		}

	}

}
