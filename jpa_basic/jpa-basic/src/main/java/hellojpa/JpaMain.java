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

      Team team = new Team();
      team.setName("teamA");
      em.persist(team);

      Member member = new Member();
      member.setName("member1");
      member.setTeam(team);
      
      em.persist(member);

      Team team2 = new Team();
      team2.setName("team2");
      member.setTeam(team2);
      em.persist(team2);


      Member findMember = em.find(Member.class, member.getId());
      Team findTeam = findMember.getTeam();
      System.out.println(findTeam.getName());

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
