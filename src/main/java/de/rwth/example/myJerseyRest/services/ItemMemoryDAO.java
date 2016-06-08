package de.rwth.example.myJerseyRest.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import de.rwth.example.myJerseyRest.models.Item;
import de.rwth.example.myJerseyRest.services.interfaces.ItemDAO;

public class ItemMemoryDAO implements ItemDAO {
	Map<String,Item> items = new HashMap<String,Item>();

	public Item getItemByName(String name) {
		return this.items.get(name);
		//throw new RuntimeException("Item isn't in the Fridge yet: " + name);
	}

	public Collection<Item> getAllItems() {
    for (Item item : this.items.values()) {
      System.out.println(item.getName());
    }
		return this.items.values();
	}

	public void insertItem(Item item) {
		this.items.put(item.getName(), item);
    System.out.println(this.getItemByName(item.getName()).getName());
	}

	public void updateItem(Item item)	{
		Item editItem = this.getItemByName(item.getName());
		editItem.setName(item.getName());
	}

	public void deleteItem(Item item)	{
		this.items.remove(item.getName());
	}
}
