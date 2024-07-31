package com.hiber;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Address;
import com.model.Certificate;
import com.model.Student;
import com.util.HibernateUtils;

public class CreateApp {

	public static void main(String[] args) throws IOException{

		SessionFactory sf = HibernateUtils.getSessionfactory();

		if (sf != null) {
			
			//Creating Address object
			Address ad = new Address();
			ad.setAddedDate(new Date());
			ad.setStreet("18/908");
			ad.setX(12.2);
			ad.setCity("Delhi");
			ad.setOpen(true);
			
			// creating certificate object
			Certificate certi = new Certificate();
			certi.setCourse("C ++");
			certi.setDuration("3 months");

			// creating student object
			Student st = new Student();
			st.setCity("Delhi");
			st.setName("ravi");
			st.setCerti(certi);
			

			FileInputStream fis = new FileInputStream("src/main/resources/ticket.png");
			byte[] data = new byte[fis.available()];
			fis.read(data);			
			ad.setImage(data);
			

			// creating/saving address record in DB
			Session s = sf.openSession();
			s.save(ad);
			s.beginTransaction();
			//s.save(st);
			s.getTransaction().commit();
			s.close();
		}

	}

}
