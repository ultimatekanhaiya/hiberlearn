/*
 * Update Vs Merge:
 * REFERENCE : https://www.baeldung.com/hibernate-save-persist-update-merge-saveorupdate
 * What exactly we are doing:
 * 1. We open a session and get an address object with id:102 and close that session
 * 2. After closing session, address object get detach from session
 * 3. Make changes to address object properties.
 * 4. Again Open a new Session and again get an address object with id:102
 * 5. So now we have 1 address object present in session object.
 * 6. When we write s2.update(address) it puts this address into session object
 * 7. Now we have two address references with same ID: 102 but different field values 
 * 	like: 1.address1(with city:delhi) 2. address(with city:vridavan)
 * 8. Now using second/new session we are trying to update address record with id:102 in DB but the problem
 * here is that we have two address references 'address' and 'address2' with different field values, which
 * results in ambiguity hence Hibernate through : NonUniqueObjectException: 
 * A different object with the same identifier value was already associated with the session
 * 
 * SOLUTION: 
 * We can use merge to guide hibernate to override already present address object with our provided object.
 */
package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Address;
import com.util.HibernateUtils;

public class UpdateVsMergeApp {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("Sessionfcatory is not initialized correctly");
			return;
		}

		try {

			Session s = sf.openSession();
			s.beginTransaction();
			
			// first address object
			Address address = s.get(Address.class, 102);
			
			s.getTransaction().commit();
			s.close();

			address.setCity("Vridavan");

			// new Session Object
			Session s2 = sf.openSession();
			s2.beginTransaction();
			
			// second address object
			Address address2 = s2.get(Address.class, 102);
			
			//s2.update(address);//will not work, throw exception
			s2.merge(address);
			s2.getTransaction().commit();
			s2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
