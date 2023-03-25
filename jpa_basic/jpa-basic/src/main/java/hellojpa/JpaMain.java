package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
			Set<String> favoriteFood = new HashSet<>();
			favoriteFood.add("PIZZA");
			favoriteFood.add("Chicken");

			member.setFavoriteFoods(favoriteFood);

			member2.setFavoriteFoods(favoriteFood);

			List<Address> addressList = new ArrayList<>();
			Address a = new Address("seoul","street","123");
			addressList.add(a);
			member.setAddressHistory(addressList);
			member2.setAddressHistory(addressList);
			member.setHomeAddress(a);
			a.setCity("pusan");

			addressList.get(0).setZipcode("456");



			em.flush();
			em.clear();



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
