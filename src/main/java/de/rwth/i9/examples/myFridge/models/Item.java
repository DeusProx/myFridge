package de.rwth.i9.examples.myFridge.models;

public class Item {
  public String name;
  public String bbd;
  public String description;
  public String owner;
  public String ingredients;
  public Nutritions nutritions;

  //For testing purposes & System.out.printeln
  public String toString(){
    return this.name + ""
            + this.bbd + ""
            + this.description + ""
            + this.owner + ""
            + this.ingredients;
  }
}

