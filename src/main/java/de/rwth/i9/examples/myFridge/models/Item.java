package de.rwth.i9.examples.myFridge.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
/*@NamedNativeQueries({
        @NamedNativeQuery(name = "Item.findAllItems", query = "SELECT * FROM Item", resultClass = Item.class)
})*/
@NamedQueries({
        @NamedQuery(name = "Item.findAllItems", query = "SELECT i FROM Item i")
})
@TableGenerator(name="item", allocationSize=1)
public class Item implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="item")
    private int id;
    private String name;
    private String bbd;
    private String description;
    private String owner;
    private String ingredients;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn
    private Nutritions nutritions;

    Item () {} //default constructor, needed for JPA

    public Item(
        String name,
        String bbd,
        String description,
        String owner,
        String ingredients,
        Nutritions nutritions
    ) {
        this.name = name;
        this.bbd = bbd;
        this.description = description;
        this.owner = owner;
        this.ingredients = ingredients;
        this.nutritions = nutritions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBbd() {
        return bbd;
    }

    public void setBbd(String bbd) {
        this.bbd = bbd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Nutritions getNutritions() {
        return nutritions;
    }

    public void setNutritions(Nutritions nutritions) {
        this.nutritions = nutritions;
    }

    @Override
    public String toString() {
        return this.id + "|"
                + this.name + "|"
                + this.bbd + "|"
                + this.description + "|"
                + this.owner + "|"
                + this.ingredients + " & "
                + this.nutritions.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if(getClass()!=obj.getClass()){
            return false;
        }
        final Item item = (Item) obj;
        if (
            this.getId() != item.getId() 
            || !this.getName().equals(item.getName())
            || !this.getBbd().equals(item.getBbd())
            || !this.getDescription().equals(item.getDescription())
            || !this.getOwner().equals(item.getOwner())
            || !this.getIngredients().equals(item.getIngredients())
            || !this.getNutritions().equals(item.getNutritions())
        )  return false;
        
        return true; 
    }
}

