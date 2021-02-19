package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	@Test
	public void DemoInstructor_stud() {

		// using persistance.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Instructor_Student2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		em.persist(tempInstructor);
		em.persist(tempInstructorDetail);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
