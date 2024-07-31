package com.map.oneToOneEmbeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtils;

public class OneToOneEmbApp {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("sessionfactory not initialized properly");
			return;
		}
		try (Session s = sf.openSession()) {
			s.getCriteriaBuilder().createQuery();
			// creating Worker Object
			Worker w = new Worker();
			w.setWorkerId(101);
			w.setName("kamal");

			// creating Location Object
			LocationDetail location = new LocationDetail();
			location.setOfficeNumber(9211);

			// creating ParkingSpot Object
			ParkingSpot ps = new ParkingSpot();
			ps.setParkingId(201);
			ps.setGarage("Morris garage");
			ps.setAssignedTo(w);

			location.setParkingSpot(ps);

			w.setLocation(location);

			s.beginTransaction();
			s.persist(w);
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Running catch block");

		}
	}

}
