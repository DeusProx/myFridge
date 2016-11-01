package de.rwth.i9.examples.myFridge.services.interfaces;

import java.util.Collection;

import de.rwth.i9.examples.myFridge.models.Item;

public interface ItemDAO {
	Item getItemById(int id);
	Collection<Item> getAllItems();
	Item insertItem(Item item);
	void deleteItemById(int id);
}
