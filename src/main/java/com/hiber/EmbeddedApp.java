package com.hiber;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Certificate;
import com.model.Student;
import com.util.HibernateUtils;

public class EmbeddedApp {
	public static void main(String[] args) {

		SessionFactory sessionfactory = HibernateUtils.getSessionfactory();
		if (sessionfactory == null) {
			System.out.println("Sessionfactory is not set properly");
			return;
		}
		// creating certificate object
		Certificate certi = new Certificate();
		certi.setCourse("C ++");
		certi.setDuration("3 months");

		// creating student object
		Student st = new Student();
		st.setCity("Delhi");
		st.setName("ravi");
		st.setCerti(certi);

		try (Session s = sessionfactory.openSession();) {

			s.beginTransaction();
			s.save(st);
			s.evict(st);
			s.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
