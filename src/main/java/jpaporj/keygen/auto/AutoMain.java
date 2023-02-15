package jpaporj.keygen.auto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class AutoMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();

			Auto member = new Auto();
			member.setName("test");
			
			// hibernate_sequence라는 시퀀스용 테이블 생성하여 조회
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
