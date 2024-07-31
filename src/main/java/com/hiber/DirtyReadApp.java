/*
 * DirtyRead means hibernate automatically firing update query whenever it see a change in
 * proxy object even we are not calling save or update.
 * */
package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Address;
import com.util.HibernateUtils;

public class DirtyReadApp {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("Sessionfcatory is not initialized correctly");
			return;
		}

		try (Session s = sf.openSession()) {

			// create Address Object
			Address ad = new Address();
			ad.setStreet("9/228");
			ad.setOpen(true);
			ad.setCity("mathura");

			Transaction tx = s.beginTransaction();
			
			Address address = s.get(Address.class, 102);
			System.out.println(address);
			
			/* 1. After getting address data from DB it got saved in session Object
			 * 2. Hibernate will create a proxy/snapshot object for us of the same session object data.
			 * 3. So whatever changes we make to that proxy object, hibernate will automatically check into
			 * 	session object and if any change found it will be automatically updated into session object
			 * 	as well as in DB even without calling save or update.
			 * 4. No matter how many times we set the properties of proxy object, hibernate will fire update
			 * 	query only when it found a change in proxy and session object.
			 * */
			address.setCity("delhi");
			address.setCity("delhi");
			address.setCity("delhi");
			address.setCity("delhi");
			
			
			// there is no effect of flush after evict as object already detach from session.
//			Address address1 = s.get(Address.class, 103);
//			s.evict(address1);
//			address1.setCity("new city");
//			s.flush();
			
			

			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
