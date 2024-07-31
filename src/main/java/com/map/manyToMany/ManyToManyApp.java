package com.map.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.util.HibernateUtils;

public class ManyToManyApp {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtils.getSessionfactory();
		if (sf == null) {
			System.out.println("Sessionfactory not initialized properly");
			return;
		}
		try (Session s = sf.openSession()) {

			// creating Employee
			Employee emp1 = new Employee();
			emp1.setEid(101);
			emp1.setName("Kamal");

			Employee emp2 = new Employee();
			emp2.setEid(102);
			emp2.setName("pawan");

			// creating project
			Project p1 = new Project();
			p1.setPid(201);
			p1.setProjcetName("BankFin");

			Project p2 = new Project();
			p2.setPid(202);
			p2.setProjcetName("Networks");

			List<Employee> emplist = new ArrayList<>();
			emplist.add(emp1);
			emplist.add(emp2);

			List<Project> plist = new ArrayList<>();
			plist.add(p1);
			plist.add(p2);

			emp1.setProjects(plist);
			p2.setEmployees(emplist);

			Transaction tran = s.beginTransaction();
			s.save(emp1);
			s.save(emp2);
			s.save(p1);
			s.save(p2);
			s.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
