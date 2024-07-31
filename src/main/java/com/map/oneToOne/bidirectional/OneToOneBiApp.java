/* Here we are using OneToOne Bidirectional mapping 
 * Both Answer and Question Object contain reference of one-another but in DB only Question table is maintaining
 * the foreign key.
 * Therefore on Answer table we used mappedby="answer"(which is the variable name in Question Entity) in OneToOne annotation.
 * Note : 
 * 1. It is not mandatory to set Question reference in Answer Object to get Question related data in bidirectional OneToOne mapping.
 * 	Answer ans = new Answer(); -> ans.setQuestion(q); => not mandatory
 * 2. When we save Question data using session.persist() method it automatically saves Answer data as well using cascade.
 * 3. But when we use session.get() method to get the data after session.persist() method, Hibernate instead of hitting
 * select query, it shows the data from session object.
 * 4. In starting we already mention that we didn't set answer.setQuestion() therefore answer object in session object
 * 	doesn't contain any info about Question and hence result in null therefore any operation on null will result in
 * 	NullPointerException. ans.getQuestion().getQuestion() => result NPE
 * 5. To resolve this issue either we can set question reference in Answer Object like : ans.setQuestion(q);
 * 	or we can detach answer object from session, so that when we can call session.get(Answer.class, 208); hibernate
 *  will not be able to locate answer object in session object and will hit a sql query to get answer data.
 *  Hibernate: 
    select
        a1_0.answer_id,
        a1_0.answer,
        q1_0.question_id,
        q1_0.question 
    from
        Answer3 a1_0 
    left join
        Question3 q1_0 
            on a1_0.answer_id=q1_0.asn_id 
    where
        a1_0.answer_id=?   
 * 	
 * 
 * */
package com.map.oneToOne.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.util.HibernateUtils;

public class OneToOneBiApp {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("Sessionfcatory is not initialized correctly");
			return;
		}

		try (Session s = sf.openSession()) {

			// create Question Object
			Question3 q = new Question3();
			q.setId(108);
			q.setQuestion("What is Internet");

			// create Answer Object
			Answer3 ans = new Answer3();
			ans.setId(208);
			ans.setAnswer("network of networks");
			// ans.setQuestion(q);

			q.setAnswer(ans);

			Transaction tx = s.beginTransaction();
			s.persist(q);
			s.getTransaction().commit();
			s.evict(ans);

			System.out.println("Quetsion3 : " + s.contains(q));
			System.out.println("Answer3 : " + s.contains(ans));
			System.out.println("before get -----------------------");

			Question3 question = s.get(Question3.class, 108);
			Answer3 answer = s.get(Answer3.class, 208);

			System.out.println("After get ------------------------");
			System.out.println("Quetsion3 : " + s.contains(question));
			System.out.println("Answer3 : " + s.contains(answer));

			System.out.println(question.getQuestion() + " : " + question.getAnswer().getAnswer());
			System.out.println(answer.getAnswer() + " : " + answer.getQuestion().getQuestion());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
