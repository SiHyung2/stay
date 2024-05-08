//package com.example.service;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.example.config.RootConfig;
//import com.example.domain.LoginVO;
//import com.example.domain.MemberDTO;
//import com.example.domain.ReviewDTO;
//
//import lombok.extern.log4j.Log4j;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { RootConfig.class })
//@Log4j
//public class MemberServiceTest { 
// 
//	@Autowired
//	private MemberService service;
//	   
////  @Test
//  public void testInsert() {
//      MemberDTO member = new MemberDTO();
//      member.setEmail_id("test333@example.com");
//      member.setPassword("password");
//      member.setName("Test User");
//      member.setTel("123-456-7890");
//      member.setType_code("2");
//      
//      service.insert(member);
//       
//      // 단언 구문 추가
//      assert member.getEmail_id() != null;
//  }
//  
////  @Test
//  public void testSelect() {
//      MemberDTO insertedMember = new MemberDTO();
//      insertedMember.setEmail_id("test3333@example.com");
//      insertedMember.setPassword("3password");
//      insertedMember.setName("Test User");
//      insertedMember.setTel("123-4536-7890");
//      insertedMember.setType_code("2");
//      
//      service.insert(insertedMember);
//      
//      MemberDTO selectedMember = service.select("1test1@example.com");
//      
//      // 단언 구문 추가
//      assert selectedMember.equals(insertedMember);
//  }
//  
////  @Test
//  public void testUpdate() {
//      // Create a MemberDTO object with initial values
//      MemberDTO member = new MemberDTO();
//      member.setEmail_id("test3333@example.com");
//      member.setPassword("password");
//      member.setName("Test User");
//      member.setTel("123-456-7890");
//      member.setType_code("1");
//
//      // Update the member
//      member.setName("Updated Name");
//      member.setTel("987-654-3210"); 
//      service.update(member); // 매퍼의 update 메서드 호출
//    
//      // Retrieve the updated member
//      MemberDTO updatedMember = service.select(member.getEmail_id());
//
//      // Verify updates
//      assertEquals("Updated Name", updatedMember.getName());
//      assertEquals("987-654-3210", updatedMember.getTel());
//  }
//
//
//
//  
////  @Test
//  public void testDelete() {
//      // 삭제할 이메일 주소
//      String emailToDelete = "test333@example.com";
//
//      // 해당 이메일 주소를 가진 회원을 삭제
//      service.delete(emailToDelete);
//      
//      // 삭제된 회원을 다시 조회
//      MemberDTO deletedMember = service.select(emailToDelete);
//      
//      // 삭제된 회원이 null 확인 
//      assert deletedMember == null;
//  }
//
// 
//  @Test
//  public void testValidateMember() {
//  	
//  	LoginVO vo1 = new LoginVO();
//  	vo1.setEmail_id("11test497@example.com");
//  	vo1.setPassword("34352");
//
//      LoginVO vo2 = service.validateMember(vo1);
//      
//      log.info("리턴111111111111111111111111111111111111111 "+ vo2);
//
//
//  } 
//  
//  
//  
//}