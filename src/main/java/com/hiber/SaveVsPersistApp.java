/*
 * REFERENCE : https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
 * */
package com.hiber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Address;
import com.util.HibernateUtils;

public class SaveVsPersistApp {
	
	private static Logger logger = LogManager.getLogger(SaveVsPersistApp.class);
	
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("Sessionfcatory is not initialized correctly");
			return;
		}

		try (Session s = sf.openSession()) {

			// create Address Object
			Address ad = new Address();
			ad.setStreet("9/750");
			ad.setOpen(true);
			ad.setCity("city47");
			
			Address ad2 = new Address();
			ad2.setStreet("9/800");
			ad2.setOpen(true);
			ad2.setCity("city5");

			Transaction tx = s.beginTransaction();
			
			
//			s.persist(ad);
			logger.info(ad);
			ad.setCity("city87");
			logger.info(ad);
//			s.evict(ad);
			
			/* 1. using save
			 * save() will work outside of transaction also.
			 * evict() detach the object from session but even after that we can call save().
			 * But it result in duplicate records saved into DB. Means if we call save -> evict again and again
			 * each save will create a new object and hence result in multiple duplicate records.
			 * The save call on a detached instance creates a new persistent instance and assigns it a new identifier, 
			 * which results in a duplicate record in the database upon committing or flushing.
			 * Note: save() return object, means doesn't work on same object.
			 * */
			
			s.save(ad);
			System.out.println("1 : " + s.contains(ad));//true
			s.evict(ad);
			System.out.println("2 : " + s.contains(ad));//false
			Integer save = (Integer)s.save(ad);
			System.out.println("3 : " + s.contains(ad));//true
//			s.evict(ad);
//			System.out.println("4 : " + s.contains(ad));//false
//			s.save(ad);
//			System.out.println("5 : " + s.contains(ad));//true
			//will result in three duplicate record insertion
			
			
			/* 2. using persist
			 * After using evict(), object get detach from session and will get attach by using
			 * update, merge, saveOrUpdate, lock.
			 * but if we use persist again directly we will get compile time error.
			 * Note : persist() return void and work in place, means no extra copy.
			 * */
			
//			s.persist(ad);
//			System.out.println("1 : " + s.contains(ad));
//			s.evict(ad);
//			System.out.println("2 : " +s.contains(ad));
//			Address merge = s.merge(ad);
//			System.out.println("3 : " +s.contains(merge));
//			s.evict(ad);
//			System.out.println("4 : " +s.contains(merge));
//			Address merge2 = s.merge(ad2);
//			System.out.println("5 : " +s.contains(merge2));
			
			//multi merge -> evict will result in org.hibernate.AssertionFailure: possible non-threadsafe access to session
			//Reference : https://lists.jboss.org/pipermail/hibernate-issues/2010-April/022142.html
			
			/* What mistake we were making while using multiple evict and merge: 
			 * 1. we are evicting the same address reference 'ad' which is already detached from session in first evict() call only.
			 * 2. merge() always creates a new copy of provided entity and save it to session and return it;
			 * 3. So if we want to evict new object created by merge from session, we have to store it first in some reference 
			 * 	variable and provide it to evict(merge).
			 * 4. But if we failed to do so and keep calling merge(ad) again and again for the same object reference 'ad', it
			 * 	will result in creation of multiple address objects with different name but same id/primary key in session.
			 * 5. So when we finally call commit, there will be a race condition because we are trying to insert data into DB
			 * 	concurrently.
			 * */
			
			//Note : We can use merge in place of save also. It will work fine but not 'update'.
			//s.merge(ad);
			
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
