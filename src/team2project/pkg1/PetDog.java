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
public class PetDog extends Dog{
    private int ID;
    private String name;

    public PetDog() {
    }

    public PetDog(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    @Override
    public int getID() {
        return ID;
    }
    
    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return ID + "\t" + name;
    }
}
