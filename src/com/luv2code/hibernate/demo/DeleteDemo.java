package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luv2code.hibernate.demo.entity.Instructor;

public class DeleteDemo {

	public static void main(String[] args) {

//		// create session factory
//		SessionFactory factory = new Configuration()
//								.configure("hibernate.cfg.xml")
//								.addAnnotatedClass(Instructor.class)
//								.addAnnotatedClass(InstructorDetail.class)
//								.buildSessionFactory();
//		
//		// create session
//		Session session = factory.getCurrentSession();
//		
//		try {			
//			
//			// start a transaction
//			session.beginTransaction();
//
//			// get instructor by primary key / id
//			int theId = 1;
//			Instructor tempInstructor = 
//					session.get(Instructor.class, theId);
//			
//			System.out.println("Found instructor: " + tempInstructor);
//			
//			// delete the instructors
//			if (tempInstructor != null) {
//			
//				System.out.println("Deleting: " + tempInstructor);
//				
//				// Note: will ALSO delete associated "details" object
//				// because of CascadeType.ALL
//				//
//				session.delete(tempInstructor);				
//			}
//			
//			// commit transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Done!");
//		}
//		finally {
//			factory.close();
//		}

		// using persistance.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Instructor_Student2");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		// get instructor by primary key / id
		int theId = 1;
		Instructor tempInstructor = em.find(Instructor.class, theId);

		System.out.println("Found instructor: " + tempInstructor);

		// delete the instructors
		if (tempInstructor != null) {

			System.out.println("Deleting: " + tempInstructor);

			// Note: will ALSO delete associated "details" object
			// because of CascadeType.ALL
			//
			em.remove(tempInstructor);
		}

		em.getTransaction().commit();

		System.out.println("Done!");

		em.close();
		emf.close();
	}

}
