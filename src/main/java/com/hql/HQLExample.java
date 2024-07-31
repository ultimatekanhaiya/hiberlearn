package com.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.map.Answer;
import com.map.Question;
import com.util.HibernateUtils;

public class HQLExample {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("Sessionfactory is not created perfectly. Something went wrong !!");
			return;
		}

		try (Session s = sf.openSession()) {

			// create Answer Object
			Answer ans = new Answer();
			ans.setAnwser("A Programming Language");
			ans.setId(101);

			// create Question Object
			Question qes = new Question();
			qes.setId(201);
			qes.setQuestion("What is Java?");
			qes.setAns(ans);

			Transaction tran = s.beginTransaction();
			s.save(qes);
			s.save(ans);
			s.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
