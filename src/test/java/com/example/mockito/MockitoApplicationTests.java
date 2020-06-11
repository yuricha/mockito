package com.example.mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class MockitoApplicationTests {

	 @Autowired
	  private MockMvc mockMvc;
	
	@Test
	void contextLoads() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-mockito")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request).andReturn();
		
		assertEquals("Hello mockito", result.getResponse().getContentAsString());
	}

}
