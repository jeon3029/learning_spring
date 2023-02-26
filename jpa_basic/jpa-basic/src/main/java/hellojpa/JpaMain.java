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
      member.setName("member1");
      em.persist(member);

      Team team = new Team();
      team.setName("teamA");
      team.getMembers().add(member);
      em.persist(team);

      
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
