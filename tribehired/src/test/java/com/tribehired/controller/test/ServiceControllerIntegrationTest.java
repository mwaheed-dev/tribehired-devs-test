package com.tribehired.controller.test;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.context.WebApplicationContext;

import com.tribehired.controller.ServiceController;
import com.tribehired.model.CommentsDocument;
import com.tribehired.services.Comments;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceControllerIntegrationTest {
	
	
    MockMvc mockMvc;
    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    ServiceController serviceController;
    
    @MockBean
    Comments commentsService;
    
    @Before
    public void setup() throws Exception {
        this.mockMvc = standaloneSetup(this.serviceController).build();
       
    }
    @Test
    public void testSearchSync() throws Exception {
        mockMvc.perform(get("/findByPostId/100").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.*.email", hasItem(is("Emma@joanny.ca"))));
    }
    
    @Test
    public void testfindByName() throws Exception {
               
        MvcResult result = mockMvc.perform(get("/findByName/ex eaque eum natus").contentType(MediaType.APPLICATION_JSON))
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
  
    @Test
    public void testfindByPostId() throws Exception {
               
        MvcResult result = mockMvc.perform(get("/findByPostId/1").contentType(MediaType.APPLICATION_JSON))
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }
    
    @Test
    public void filterWithAllFields() throws Exception {
               
        MvcResult result = mockMvc.perform(get("/filterWithAllFields/499/excepturi sunt cum a et rerum quo voluptatibus quia/100/Wilburn_Labadie@araceli.name/et necessitatibus tempora ipsum").contentType(MediaType.APPLICATION_JSON))
            .andDo(MockMvcResultHandlers.print())
            .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);
    }

}
