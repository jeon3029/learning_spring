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


			List<Member> result = em.createQuery("select m from Member as m", Member.class).setFirstResult(5).setMaxResults(8)
					.getResultList();
			for (Member m : result) {
				System.out.println("m.getName() = " + m.getName());
			}
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
