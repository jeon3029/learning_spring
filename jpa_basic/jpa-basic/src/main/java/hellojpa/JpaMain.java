package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		try {
			Team team = new Team();
			team.setName("myteam");
			em.persist(team);

			Team team2 = new Team();
			team2.setName("myteam2");
			em.persist(team2);

			Member member = new Member();
			member.setUsername("test");
			member.setTeam(team);
			em.persist(member);

			Member member2 = new Member();
			member2.setUsername("test2");
			member2.setTeam(team2);
			em.persist(member2);

			em.flush();
			em.clear();
//			Member m = em.find(Member.class,member.getId());
//			System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());
//			System.out.println("m.getTeam().getName() = " + m.getTeam().getName());
			List<Member> memberList = em.createQuery("select m from Member m join fetch m.team",Member.class)
					.getResultList();




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
