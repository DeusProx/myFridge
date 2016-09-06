package de.rwth.i9.examples.myFridge.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

import de.rwth.i9.examples.myFridge.util.MyRandom;
import de.rwth.i9.examples.myFridge.models.Item;
import de.rwth.i9.examples.myFridge.services.interfaces.ItemDAO;

public class ItemMemoryDAO implements ItemDAO {
	Map<Integer,Item> items = new HashMap<Integer,Item>();
	MyRandom random = new MyRandom();

	public Item getItemById(int id) {
		return this.items.get(id);
		//throw new RuntimeException("Item isn't in the Fridge yet: " + name);
	}

	public Collection<Item> getAllItems() {
	    //for (Item item : this.items.values()) {
    	//	System.out.println(item.name);
	    //}
		return this.items.values();
	}

	public void insertItem(Item item) {

		int newId = this.random.nextNonNegative();
		while(this.items.containsKey(newId)){
			newId = this.random.nextNonNegative();
		}
		item.setId(newId);
		this.items.put(item.getId(), item);
	    //System.out.println(this.getItemByName(item.name).name);
	}

	//TODO
	/*public void updateItem(Item item)	{
		Item editItem = this.getItemById(item.id);
		editItem.name = item.name;
	}*/

	public void deleteItemById(int id)	{
		this.items.remove(id);
	}
}
