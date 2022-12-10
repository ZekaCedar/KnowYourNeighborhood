package com.kyn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kyn.payload.Login;

@AutoConfigureMockMvc
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserLoginTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders
								.webAppContextSetup(context)
								.apply(springSecurity())
								.build();
	}
	
	
	@Test
	//@WithMockUser
	public void testUserLogin() throws Exception{
		
		//Create Mock User Info
		Login login_user = new Login("jane@gmail.com", "jane123");
		String jsonRequest = mapper.writeValueAsString(login_user);
		System.out.println(jsonRequest);
		
		//Expected Return
		
		//test GET mapping
		MvcResult result =
		mockMvc
		.perform(post("/kyn/login")
		.content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
		
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		
		assertNotNull(content);
		
	}
	
	
	

}
