package com.example.controller;

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

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { com.example.config.RootConfig.class, com.example.config.ServletConfig.class })
@Log4j

public class ReviewControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

//    @Test
    public void testInsertReview() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders
                                            .post("/review/insert")
                                            .param("rev_Num", "5")
                                            .param("bo_Num", "1234")
                                            .param("ac_Title", "Sample Accommodation")
                                            .param("room_Num", "1")
                                            .param("content", "This is a sample review.")
                                        )
                                    .andReturn()
                                    .getModelAndView()
                                    .getViewName();
        log.info(resultPage);
    }

//    @Test
    public void testSelectReview() throws Exception {
        log.info(mockMvc.perform(MockMvcRequestBuilders
        						.get("/review/select")
        						.param("rev_Num", "2"))
                        .andReturn()
                        .getModelAndView()
                        .getModelMap());
    }
    

//    @Test
    public void testUpdateReview() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders
                                            .post("/review/update")
                                            .param("rev_Num", "2")
                                            .param("bo_Num", "1")
                                            .param("ac_Title", "Sample Accommodation")
                                            .param("room_Num", "101")
                                            .param("content", "Updated review content.")
                                        )
                                    .andReturn()
                                    .getModelAndView()
                                    .getViewName();
        log.info(resultPage);
    }

//    @Test
    public void testDeleteReview() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders
						        		 .post("/review/delete")
						                 .param("rev_Num", "4"))
                                    .andReturn()
                                    .getModelAndView()
                                    .getViewName();
        log.info(resultPage);
    }
}








