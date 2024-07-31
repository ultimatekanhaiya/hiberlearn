package com.map.oneToMany.unidirectional;

import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.util.HibernateUtils;

public class OneToManyUniApp {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("Sessionfactory not initialized properly");
			return;
		}
		try (Session s = sf.openSession()) {

//			DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
//			String dateInString = "07/06/2013";			

			// creating cinema Object
			Cinema c = new Cinema();
			c.setCinemaId(101);
			c.setBrandName("PVR");
			c.setAddress("Delhi");

			// Creating Screen Object
			Screen sc = new Screen();
			sc.setCinema(c);
			sc.setScreenId(301);
			sc.setMovieId(201);
			sc.setScreenType("IMAX");
			sc.setShowDate(new Date(2022, 03, 1));
			sc.setShowTiming("12:30");
			sc.setTotalSeats(120);
			sc.setFilledSeats(60);

			Screen sc1 = new Screen(302, "IMAX", 202, "01:30", 120, 70, new Date(2022, 3, 1), c);

			Screen sc2 = new Screen(303, "IMAX", 202, "01:30", 120, 100, new Date(2022, 3, 2), c);

			// list of screens
			List<Screen> list = new ArrayList<>();
			list.add(sc);
			list.add(sc1);
			list.add(sc2);

			c.setScreen(list);

			Transaction tran = s.beginTransaction();
			s.persist(c);
			s.getTransaction().commit();
			
			Cinema cine = s.get(Cinema.class, 101);
			System.out.println(cine.getScreen());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
