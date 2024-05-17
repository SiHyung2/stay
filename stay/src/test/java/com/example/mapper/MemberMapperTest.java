package com.example.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.config.RootConfig;
import com.example.domain.LoginVO;
import com.example.domain.MemberDTO;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RootConfig.class })
@Log4j2 
public class MemberMapperTest {
    
    @Autowired 
    private MemberMapper mapper;
 
//    @Test
    public void testInsert() {
        MemberDTO member = new MemberDTO();
        member.setEmail_id("test@example.com");
        member.setPassword("password");
        member.setName("Test User");
        member.setTel("123-456-7890");
        member.setType_code("1");
        
        mapper.insert(member); 
         
        // 단언 구문 추가
        assert member.getEmail_id() != null;
    } 
    
//    @Test 
    public void testSelect() {
        MemberDTO insertedMember = new MemberDTO();
        insertedMember.setEmail_id("1test1@example.com");
        insertedMember.setPassword("3password");
        insertedMember.setName("11Test User");
        insertedMember.setTel("123-4536-7890");
        insertedMember.setType_code("2");
        
        mapper.insert(insertedMember);
        
        MemberDTO selectedMember = mapper.select("1test1@example.com");
        
        // 단언 구문 추가
        assert selectedMember.equals(insertedMember);
    }
    
//    @Test
    public void testUpdate() {
        // Create a MemberDTO object with initial values
        MemberDTO member = new MemberDTO();
        member.setEmail_id("test@example.com");
        member.setPassword("password");
        member.setName("Test User");
        member.setTel("123-456-7890");
        member.setType_code("1");

        // Update the member
        member.setName("Updated Name");
        member.setTel("987-654-3210"); 
        mapper.update(member); // 매퍼의 update 메서드 호출
      
        // Retrieve the updated member
        MemberDTO updatedMember = mapper.select(member.getEmail_id());
 
        // Verify updates
        assertEquals("Updated Name", updatedMember.getName());
        assertEquals("987-654-3210", updatedMember.getTel());
    }



    
//    @Test
    public void testDelete() {
        String emailToDelete = "test3@example.com";

        mapper.delete(emailToDelete);
        
        MemberDTO deletedMember = mapper.select(emailToDelete);
        
        assert deletedMember == null;
    }

    
    @Test
    public void testValidateMember() {
    	
    	LoginVO vo1 = new LoginVO();
    	vo1.setEmail_id("12");
    	vo1.setPassword("1");
    	vo1.setType_code("1");

        LoginVO vo2 = mapper.validateMember(vo1);
        
        log.info("리턴111111111111111111111111111111111111111 "+ vo2);


    } 
    
    
    
}
