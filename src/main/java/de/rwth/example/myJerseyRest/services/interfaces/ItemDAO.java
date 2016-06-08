package de.rwth.example.myJerseyRest.services.interfaces;

import java.util.Collection;

import de.rwth.example.myJerseyRest.models.Item;

public interface ItemDAO {
	public Item getItemByName(String name);
	public Collection<Item> getAllItems();
	public void insertItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(Item item);
}
