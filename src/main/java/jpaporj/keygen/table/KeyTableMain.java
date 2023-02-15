package jpaporj.keygen.table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class KeyTableMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();

			KeyTable member = new KeyTable();
			member.setName("test");
			
			// 식별자를 구하기 위해 시퀀스 조회
			em.persist(member);
			System.out.println("-- check --");
			
			// query 실행
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
