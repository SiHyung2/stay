//¿package com.example.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//
//import com.example.domain.ReplyDTO;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class ReplyControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@Test
//	public void addReplyTest() throws Exception {
//		// 준비: 테스트할 데이터 생성
//		ReplyDTO replyDTO = new ReplyDTO("This is a reply content", 1);
//
//		// 실행: POST 요청 보내기
//		MockHttpServletRequestBuilder requestBuilder = post("/addReply").contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsString(replyDTO));
//
//		ResultActions result = mockMvc.perform(requestBuilder);
//
//		// 검증: HTTP 응답 상태 확인
//		result.andExpect(status().isOk());
//	}
//	
//	
//	
//	   @Test
//	    public void testInsertMember() throws Exception {
//	        String resultPage = mockMvc.perform(MockMvcRequestBuilders
//	                                            .post("/member/insert")
//	                                            .param("email_id", "11test497@example.com")
//	                                            .param("password", "testPassword")
//	                                            .param("name", "Test User")
//	                                            .param("tel", "010-1234-5678")
//	                                            .param("type_code", "1"))
//	                                    .andReturn()
//	                                    .getResponse()
//	                                    .getRedirectedUrl(); // 등록 후 리다이렉트된 URL을 가져옴
//	        log.info("Redirected URL: " + resultPage);
//	    }
//	
//
//
//}
