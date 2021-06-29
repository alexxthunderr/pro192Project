/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team2project.pkg1;

/**
 *
 * @author _trananhhh
 */
public class Dog implements Comparable<Dog> {
    //<ID; pet ID; dog name;dog color;dog gender;price; describe>


    private int ID, petID;
    private String dogName;
    private String dogColor;
    private String dogGender;
    private double price;
    private String describe;

    public Dog() {
    }

    public Dog(int ID, int petID, String dogName, String dogColor, String dogGender, double price, String describe) {
        this.ID = ID;
        this.petID = petID;
        this.dogName = dogName;
        this.dogColor = dogColor;
        this.dogGender = dogGender;
        this.price = price;
        this.describe = describe;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogColor() {
        return dogColor;
    }

    public void setDogColor(String dogColor) {
        this.dogColor = dogColor;
    }

    public String getDogGender() {
        return dogGender;
    }

    public void setDogGender(String dogGender) {
        this.dogGender = dogGender;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return ID + "\t" + petID + "\t" + dogName + "\t" + dogColor + "\t" + dogGender + "\t" + price + "\t" + describe;
    }

    @Override
    public int compareTo(Dog d) {
        if(d.getPetID() > petID)
            return -1;
        else
            if(d.getPetID() == petID)
                return 0;
            else
                return 1;
    }
}