package com.example.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // 웹 애플리케이션 환경 설정
@ContextConfiguration(classes = { com.example.config.RootConfig.class, com.example.config.ServletConfig.class })
@Log4j
public class MemberControllerTest {
    @Setter(onMethod_ = { @Autowired })
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); 
    }

//    @Test
    public void testInsertMember() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders
                                            .post("/member/insert")
                                            .param("email_id", "11test497@example.com")
                                            .param("password", "testPassword")
                                             .param("name", "Test User")
                                            .param("tel", "010-1234-5678")
                                            .param("type_code", "1"))
                                    .andReturn()
                                    .getResponse()
                                    .getRedirectedUrl(); // 등록 후 리다이렉트된 URL을 가져옴
        log.info("Redirected URL: " + resultPage);
    }

//    @Test
    public void testSelectMember() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders
                                 .get("/member/select")
                                 .param("email_id", "1test1@example.com"))
                        .andReturn()
                        .getResponse()
                        .getContentAsString()); // 선택된 회원 정보를 로그로 출력
    }


//    @Test
    public void testUpdateMember() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders
                                            .post("/member/update")
                                            .param("email_Id", "test1@example.com")
                                            .param("password", "updatedPassword")
                                            .param("name", "Updated User")
                                            .param("tel", "010-5678-1234")
                                            .param("type_code", "2")) // 업데이트할 회원의 이메일 ID와 변경될 정보를 전달
                                    .andReturn()
                                    .getResponse()
                                    .getRedirectedUrl(); // 업데이트 후 리다이렉트된 URL을 가져옴
        log.info("Redirected URL: " + resultPage);
    } 


    @Test
    public void testDeleteMember() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/member/delete")
                .param("email_Id", "test1@example.com"))
                .andExpect(status().isOk()); // 상태 코드가 200인지 확인
                //.andReturn()
                //.getModelAndView()
                //.getViewName();
        //log.info(resultPage);
    }



    
  
    
    

}





