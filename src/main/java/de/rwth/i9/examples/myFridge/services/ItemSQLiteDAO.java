package de.rwth.i9.examples.myFridge.services;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import de.rwth.i9.examples.myFridge.models.Item;
import de.rwth.i9.examples.myFridge.services.interfaces.ItemDAO;
import de.rwth.i9.examples.myFridge.util.JPAHelper;

public class ItemSQLiteDAO implements ItemDAO {
	private EntityManager entityManager;

	public ItemSQLiteDAO() {
		entityManager = JPAHelper.getInstance().createEntityManager();
	}

	public Item getItemById(int id) {
		return this.entityManager.find(Item.class, id);
	}

	public Collection<Item> getAllItems() {
		Query queryFindAllItems = entityManager.createNamedQuery("Item.findAllItems");
		List<Item> results = queryFindAllItems.getResultList();
		return results;
	}

	public void insertItem(Item item) {
		EntityTransaction entityTransaction = this.entityManager.getTransaction();
		entityTransaction.begin();
		this.entityManager.persist(item);
		entityTransaction.commit();
		//this.entityManager.flush();
		return;
	}

	//TODO
	/*public void updateItem(Item item)	{
		Item editItem = this.getItemById(item.getId());
		editItem.setId();name = item.name;
	}*/

	public void deleteItemById(int id)	{
		EntityTransaction entityTransaction = this.entityManager.getTransaction();
		entityTransaction.begin();

		Item item = this.entityManager.getReference(Item.class, id);
		if(item == null) {
			throw new Error();
		}
		this.entityManager.remove(item);
		entityTransaction.commit();
		//this.entityManager.flush();
		return;
	}
}
