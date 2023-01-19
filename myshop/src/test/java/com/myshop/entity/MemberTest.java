package com.myshop.entity;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.repository.MemberRepository;

@SpringBootTest
//@AutoConfigureMockMvc //실제 객체와 비슷하지만 테스트에 필요한 기능만 제공하는 가짜 객체를 만든다. -> 웹브라우저에서 요청흘 하는것 처럼 작성 가능
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
class MemberTest {

	@Autowired
	MemberRepository memberRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	@DisplayName("auditing 테스트")
	@WithMockUser(username = "gildong", roles = "USER")
	public void auditingTest() {
		Member newMember = new Member();
		memberRepository.save(newMember);
		
		em.flush();
		em.clear();
		
		Member member = memberRepository.findById(newMember.getId())
				.orElseThrow(EntityNotFoundException::new);
		
		System.out.println( "등록시간:" + member.getRegTime());
		System.out.println( "수정시간:" + member.getUpDateTime());
		System.out.println( "등록한 사람:" + member.getCreateBy());
		System.out.println( "수정한 사람:" + member.getModifiedBy());
	}
	
}
