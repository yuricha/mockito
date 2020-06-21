package com.example.mockito.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.mockito.data.ItemRepository;
import com.example.mockito.model.Item;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ItemBusinessServicetest {
	
	@InjectMocks
	ItemBusinessService itemService;
	
	@Mock
	ItemRepository itemRepository;
	
	@Test
	public void calculateValueItemTest() {
		when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item 2",10.0,200)));
		List<Item>list= itemService.retrieveAllItems();
		assertEquals(2000.0,list.get(0).getValue()); //assetThat and jsonpath another tools por assert  book-->Xunitpatterns
	}

}
