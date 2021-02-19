package com.luv2code.hibernate.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
//			// get the instructor detail object
//			int theId = 2;
//			InstructorDetail tempInstructorDetail = 
//					session.get(InstructorDetail.class, theId);
//			
//			// print the instructor detail
//			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
//						
//			// print  the associated instructor
//			System.out.println("the associated instructor: " + 
//								tempInstructorDetail.getInstructor());
//			
//			// now let's delete the instructor detail
//			System.out.println("Deleting tempInstructorDetail: " 
//											+ tempInstructorDetail);
//
//			session.delete(tempInstructorDetail);
//			
//			// commit transaction
//			session.getTransaction().commit();
//			
//			System.out.println("Done!");
//		}
//		catch (Exception exc) {
//			exc.printStackTrace();
//		}
//		finally {
//			// handle connection leak issue
//			session.close();
//			
//			factory.close();
//		}

		// using persistance.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Instructor_Student2");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			// get the instructor detail object
			int theId = 2;
			InstructorDetail tempInstructorDetail = em.find(InstructorDetail.class, theId);

			// print the instructor detail
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			// print the associated instructor
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

			// now let's delete the instructor detail
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);

			em.remove(tempInstructorDetail);

			// commit transaction
			em.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}

}
