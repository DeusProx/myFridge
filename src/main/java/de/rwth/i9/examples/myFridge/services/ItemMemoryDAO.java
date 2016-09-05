package de.rwth.i9.examples.myFridge.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import de.rwth.i9.examples.myFridge.models.Item;
import de.rwth.i9.examples.myFridge.services.interfaces.ItemDAO;

public class ItemMemoryDAO implements ItemDAO {
	Map<String,Item> items = new HashMap<String,Item>();

	public Item getItemByName(String name) {
		return this.items.get(name);
		//throw new RuntimeException("Item isn't in the Fridge yet: " + name);
	}

	public Collection<Item> getAllItems() {
    for (Item item : this.items.values()) {
      System.out.println(item.name);
    }
		return this.items.values();
	}

	public void insertItem(Item item) {
		this.items.put(item.name, item);
    System.out.println(this.getItemByName(item.name).name);
	}

	public void updateItem(Item item)	{
		Item editItem = this.getItemByName(item.name);
		editItem.name = item.name;
	}

	public void deleteItem(Item item)	{
		this.items.remove(item.name);
	}
}
