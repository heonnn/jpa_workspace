package jpaporj.keygen.identity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class IdentityMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();

			Identity member = new Identity();
			member.setName("test");
			
			// query 실행
			// Statement.getGeneratedKeys()로 데이터 저장과 동시에 생성된 기본 키 값 가져옴
			em.persist(member);
			
			// persistence context(1차 캐시)에서 조회
			Identity member2 = em.find(Identity.class, 1);
			
			// 동일성 보장
			System.out.println(member == member2);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
