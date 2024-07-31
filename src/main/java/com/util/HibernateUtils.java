package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* using singleton design pattern to prevent creation of sessionFactory Object again and again
 * */
public class HibernateUtils {

	private static SessionFactory sessionFactory = null;

	private HibernateUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static SessionFactory getSessionfactory() {
		try {
			if (sessionFactory == null) {
				Configuration configuration = new Configuration();
				configuration.configure("hibernate.cfg.xml");
				sessionFactory = configuration.buildSessionFactory();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
}
