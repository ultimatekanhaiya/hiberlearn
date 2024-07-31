package com.map.oneToMany.bidirectional;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.util.HibernateUtils;

public class OneToManyBiApp {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("Sessionfcatory is not initialized correctly");
			return;
		}

		try (Session s = sf.openSession()) {
			
			//create Address
			Address ad = new Address();
			ad.setStreet("9/244");
			ad.setCity("Delhi");
			ad.setStreet("Delhi");
			
			// create person Object
			Person person = new Person();
			person.setPersonId(102);
			person.setName("Raj");
			person.setAddress(ad);

			// create Email Object
			Email mail = new Email();
			mail.setId(204);
			mail.setEmail("raj@gmail.com");
			mail.setPerson(person);

			Email mail1 = new Email(205, "raj123@outlook.com", person);
			Email mail2 = new Email(206, "raj2020@outlook.com", person);

			List<Email> list = new ArrayList<>();
			list.add(mail);
			list.add(mail1);
			list.add(mail2);

			person.setEmails(list);

			Transaction tx = s.beginTransaction();

			s.persist(person);
			s.getTransaction().commit();

			Person person1 = s.get(Person.class, 101);
			System.out.println(person1.getName());
			List<Email> email = person1.getEmails();
			for (Email m : email) {
				System.out.println(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
