package jpaporj.mapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MappingMain {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			
			// create
			TeamEntity team1 = new TeamEntity();
			team1.setId("team_01");
			team1.setName("korea_team");
			em.persist(team1);
			
			MemberEntity member1 = new MemberEntity();
			member1.setId("member_01");
			member1.setUsername("honggd");
			member1.setTeam(team1);
			em.persist(member1);
			
			MemberEntity member2 = new MemberEntity();
			member2.setId("member_02");
			member2.setUsername("sinsa");
			member2.setTeam(team1);
			em.persist(member2);
			
			System.out.println(team1.getMembers().size());
			
			// 1. 단방향 member.getTeam()
//			MemberEntity searchMember = em.find(MemberEntity.class, "member_01");
//			System.out.println("team of " + searchMember.getUsername() + " = " + searchMember.getTeam().getName());
//			
//			// 2. 양방향
//			TeamEntity searchTeam = em.find(TeamEntity.class, "team_01");
//			List<MemberEntity> memberList = searchTeam.getMembers();
//			
//			for(MemberEntity member : memberList) {
//				System.out.println("member of " + searchTeam.getName() + " = " + member.getUsername());
//			}
			
			tx.commit();
			System.out.println("complete");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
	
}
