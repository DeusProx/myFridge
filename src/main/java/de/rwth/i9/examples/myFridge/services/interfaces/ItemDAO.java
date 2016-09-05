package de.rwth.i9.examples.myFridge.services.interfaces;

import java.util.Collection;

import de.rwth.i9.examples.myFridge.models.Item;

public interface ItemDAO {
	Item getItemByName(String name);
	Collection<Item> getAllItems();
	void insertItem(Item item);
	void updateItem(Item item);
	void deleteItem(Item item);
}
