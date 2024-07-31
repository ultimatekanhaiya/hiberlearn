package com.collection;

import java.time.LocalDate;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtils;

public class CollectionAp {
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if(sf == null) {
			System.out.println("sessionFactory is not initialized properly");
			return;
		}
		
		Ticket t1 = new Ticket();
		t1.setActive(true);
		t1.setBookingDate(LocalDate.now());
		HashMap<String,Double> map = new HashMap<>();
		map.put("Silver", 120.0);
		map.put("Gold", 150.0);
		map.put("Diamond", 220.0);
		
		t1.setSeatPriceMap(map);
		
		try (Session s = sf.openSession()) {
			s.beginTransaction();
			s.persist(t1);
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch block running");
		}
	}

}
