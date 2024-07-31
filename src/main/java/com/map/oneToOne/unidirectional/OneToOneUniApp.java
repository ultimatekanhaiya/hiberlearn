/*
 * Using OneToOne Unidirectional mapping
 * Here Answer2 Object is the referencing object and Question2 is the owning(which contain foreign key) Object
 * From Question only we can get answer
 * Note: 
 * 1. for 'get' operation we don't need transaction Operations(like beginTransaction or commit).
 * 2. for session.get() Hibernate always check the requested object in Session Object first and if it didn't get
 * the Object there then only it will fire new select statement.
 * 3. If we want to use persist with any mapping then to save child entity data  we have to use 'Cascade'
 * Otherwise it will throw exception -> Cannot add or update a child row: a foreign key constraint fails
 * */

package com.map.oneToOne.unidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.util.HibernateUtils;

public class OneToOneUniApp {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("Sessionfcatory is not initialized correctly");
			return;
		}

		try (Session s = sf.openSession()) {

			// create Question Object
			Question2 q = new Question2();
			q.setId(101);
			q.setQuestion("What is Python");

			// create Answer Object
			Answer2 ans = new Answer2();
			ans.setId(201);
			ans.setAnswer("It is a programing language");

			q.setAns(ans);

			Transaction tx = s.beginTransaction();
			s.persist(q);
			s.getTransaction().commit();

			Question2 question2 = s.get(Question2.class, 101);
			Question2 question3 = s.get(Question2.class, 101);
			System.out.println(question2.getQuestion() + "  " + question2.getAns().getAnswer());
			System.out.println(question3.getQuestion() + "  " + question3.getAns().getAnswer());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
