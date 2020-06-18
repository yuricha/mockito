package com.example.mockito.business;

import org.springframework.stereotype.Component;

import com.example.mockito.model.Item;
@Component
public class ItemBusinessService {

	public Item getHardCodeItem() {
		// TODO Auto-generated method stub
		return new Item(1,"Ball", 10.0,100);
	}

}
