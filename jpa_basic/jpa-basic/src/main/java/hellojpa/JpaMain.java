package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
      Member member = new Member();
      member.setUsername("test");
      em.persist(member);
      
      tr.commit();
		} catch (Exception e) {
			tr.rollback();
			System.out.println("transaction error : " + e);
		} finally {
			em.close();
		}

		emf.close();

	}
}
