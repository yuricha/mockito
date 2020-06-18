package com.example.mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.mockito.business.ItemBusinessService;
import com.example.mockito.model.Item;



@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class MockitoApplicationTests {

	 @Autowired
	  private MockMvc mockMvc;
	 
	 @MockBean
	 private ItemBusinessService itemBusinessService;
	
	@Test
	void contextLoads() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-mockito")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request).andReturn();
		
		assertEquals("Hello mockito", result.getResponse().getContentAsString());
	}

	/*
	 * second way whitour assert
	 */
	
	@Test
	void helloWorld2() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-mockito")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello mockito"))
				.andReturn();
		
		
		//assertEquals("Hello mockito", result.getResponse().getContentAsString());
	}
	
	/*
	 * test with json and get controller
	 */
	@Test
	void dummytest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{ \"id\":1,name:\"Ball\",\"price\":10.0, \"quantity\":100}"))
				.andReturn();
	}
	
	
	/*
	 * test with json and get controller
	 */
	@Test
	void dummytest_business() throws Exception{
		
		when(itemBusinessService.getHardCodeItem()).thenReturn(
					new Item(2,"Item 2",10.0,200));
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item-business")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{ \"id\":2,name:\"Item 2\",\"price\":10.0, \"quantity\":200}"))
				.andReturn();
	}
}
