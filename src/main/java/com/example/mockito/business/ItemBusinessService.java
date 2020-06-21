package com.example.mockito.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mockito.data.ItemRepository;
import com.example.mockito.model.Item;
@Component
public class ItemBusinessService {
	@Autowired
	private ItemRepository repository;
	
	public Item getHardCodeItem() {
		return new Item(1,"Ball", 10.0,100);
	}
	
	public List<Item> retrieveAllItems(){

		return repository.findAll().stream()
				.map(item -> {
					item.setValue(item.geValueItem());
					return item;
				})
				.collect(Collectors.toList());
	}

}
