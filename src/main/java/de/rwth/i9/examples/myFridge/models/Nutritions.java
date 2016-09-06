package de.rwth.i9.examples.myFridge.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by deusprox on 03.09.16.
 */
@Entity
@TableGenerator(name="nutritions", allocationSize=1)
public class Nutritions implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="nutritions")
    private int id;
    private int kcal;
    private int protein;
    private int fat;
    private int carbohydrates;

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public String toString() {
        return this.id + "|"
                + this.kcal + "|"
                + this.protein + "|"
                + this.fat + "|"
                + this.carbohydrates;
    }

}