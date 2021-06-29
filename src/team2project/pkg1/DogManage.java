/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team2project.pkg1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author _trananhhh
 */
public class DogManage implements IDog{
    
    List<PetDog> listPetDog = new ArrayList<>();
    List<Dog> listDog = new ArrayList<>();
    
    Scanner sc = new Scanner(System.in);
    
    BufferedReader br;
    PrintWriter out;
    
    public DogManage(){
        String petDogFile = "src/petdog.txt";
        try{
            br = new BufferedReader(new FileReader(petDogFile));
            String line = "";
            while((line = br.readLine()) != null){
            String[] s = line.split(";");
            int id = Integer.parseInt(s[0].trim());

            PetDog petdog = new PetDog(id,s[1]);
            listPetDog.add(petdog);
            }
            br.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        
        
        String dogFile = "src/dog.txt";
        try{
            br=new BufferedReader(new FileReader(dogFile));
            String line = "";
            while((line = br.readLine()) != null){
                String[] x = line.split(";");
                int id = Integer.parseInt(x[0].trim());
                int petId = Integer.parseInt(x[1].trim());
                String dogGender = x[4];
                double price = Double.parseDouble(x[5]);
                Dog dog = new Dog(id, petId, x[2], x[3], dogGender, price, x[6]);
                listDog.add(dog);
            }
            br.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public void outPetDog() {
        if(listPetDog.size() == 0)
            System.out.println("No PetDog found!");
        else{
            System.out.println("ID\tName");
            for(PetDog x : listPetDog)
                System.out.println(x.toString());
        }
    }

    public void outDog() {
        if(listDog.size() == 0)
            System.out.println("No Dog found!");
        else{
            System.out.println("ID\tpetID\tName\tColor\tGender\tPrice\tDescribe");
            for(Dog x : listDog)
                System.out.println(x.toString());
        }
    }

    public void addPetDog() {
        int ID;
        String name;
        
        
        System.out.println("Choose input form: ");
        System.out.println("1.Type data in multiple lines ");
        System.out.println("2.Type data in 1 line with ; ");
        
        if(Integer.parseInt(sc.nextLine()) == 1){
            System.out.print("Enter your PetDog ID : ");
            ID = sc.nextInt();
            while(searchPetDogByID(listPetDog, ID)){
                System.err.println("The ID you choose have beeen used!");
                System.out.print("Please choose another new PetDog ID : ");
                ID = sc.nextInt();
            }
            System.out.print("Enter your PetDog Name : ");
            name = sc.nextLine();
            listPetDog.add(new PetDog(ID, name));
        }
        else{
            String infoPetDog = sc.nextLine();
            
            String[] x = infoPetDog.split(";");
            ID = Integer.parseInt(x[0]);
            
            while(searchPetDogByID(listPetDog, ID)){
                System.err.println("The ID you choose have beeen used!");
                System.out.print("Please input a new Dog info : ");
                infoPetDog = sc.nextLine();
                x = infoPetDog.split(";");
                ID = Integer.parseInt(x[0].trim());
            }
            name = x[1];
            
            listPetDog.add(new PetDog(ID, name));
        }
        
    }
    
    public void addDog() {
        int ID, petID;
        String name;
        String color;
        String gender;
        double price;
        String describe;
        
        System.out.println("Choose input form: ");
        System.out.println("1.Type data in multiple lines ");
        System.out.println("2.Type data in 1 line with ; ");
        
        if(Integer.parseInt(sc.nextLine().trim()) == 1){
            System.out.print("Enter your Dog ID : ");
            ID = sc.nextInt();
            while(searchDogByID(listDog, ID)){
                System.err.println("The ID you choose have beeen used!");
                System.out.print("Please choose a new Dog ID : ");
                ID = sc.nextInt();
            }
            
            System.out.print("Enter your Dog PetID : ");
            petID = sc.nextInt();
            
            System.out.print("Enter your Dog Name : ");
            name = sc.nextLine();
            
            System.out.print("Enter your Dog Color : ");
            color = sc.nextLine();
            
            System.out.print("Enter your Dog Gender : ");
            gender = sc.nextLine();
            
            System.out.print("Enter your Dog Price : ");
            price = sc.nextDouble();
            
            System.out.print("Enter your Dog Describe : ");
            describe = sc.nextLine();
            
            listDog.add(new Dog(ID, petID, name, color, gender, price, describe));
        }
        else{
            String infoDog = sc.nextLine();
            
            String[] x = infoDog.split(";");
            ID = Integer.parseInt(x[0].trim());
            
            while(searchDogByID(listDog, ID)){
                System.err.println("The ID you choose have beeen used!");
                System.out.print("Please input a new Dog info : ");
                infoDog = sc.nextLine();
                x = infoDog.split(";");
                ID = Integer.parseInt(x[0].trim());
            }
            
            petID = Integer.parseInt(x[1].trim());
            gender = x[4];
            price = Double.parseDouble(x[5]);
            
            listDog.add(new Dog(ID, petID, x[2], x[3], gender, price, x[6]));
        }
        
    }
    
    public void deletePetDog(int ID) {
        for(PetDog x : listPetDog)
            if(x.getID() == ID){
                listPetDog.remove(x);
                System.out.println("Remove done!");
                return;
            }
        System.out.println("Not found!");
    }
    
    public void deleteDog(int ID) {
        for(Dog x : listDog)
            if(x.getID() == ID){
                listDog.remove(x);
                System.out.println("Remove done!");
                return;
            }
        System.out.println("Not found!");
    }
    
    public void updateDog(int ID) {
        for(Dog x : listDog)
            if(x.getID() == ID){
                int petID;
                String name;
                String color;
                String gender;
                double price;
                String describe;

                System.out.println("Choose input form: ");
                System.out.println("1.Type data in multiple lines ");
                System.out.println("2.Type data in 1 line with ; ");

                if(Integer.parseInt(sc.nextLine().trim()) == 1){
                    
                    System.out.print("Enter your new Dog PetID : ");
                    x.setPetID(sc.nextInt());
                    
                    System.out.print("Enter your new Dog Name : ");
                    x.setDogName(sc.nextLine());

                    System.out.print("Enter your new Dog Color : ");
                    x.setDogColor(sc.nextLine());

                    System.out.print("Enter your new Dog Gender (true/false) : ");
                    x.setDogGender(sc.nextLine());

                    System.out.print("Enter your new Dog Price : ");
                    x.setPrice(sc.nextDouble());

                    System.out.print("Enter your new Dog Describe : ");
                    x.setDescribe(sc.nextLine());
                }
                else{
                    String infoDog = sc.nextLine();
                    String[] a = infoDog.split(";");
                    
                    x.setPetID(Integer.parseInt(a[0].trim()));
                    x.setDogName(a[1]);
                    x.setDogColor(a[2]);
                    x.setDogGender(a[3]);
                    x.setPrice(Double.parseDouble(a[4]));
                    x.setDescribe(a[5]);
                }
                System.out.println("Update done!");
                return;
            }
        System.out.println("Not found!");
    }
    
    public void savePetDogFile(){
        String datPetDog = "petdog.dat";
        try{
            out = new PrintWriter(datPetDog);
            String line = "";
            for(PetDog i : listPetDog){
                line = i.getID() + ";" + i.getName();
                out.write(line + "\n");
            }
            System.out.println("File saved successfully!");
            out.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
    
    public void saveDogFile(){
        String datDog = "dog.dat";
        try{
            out = new PrintWriter(datDog);
            String line = "";
            for(Dog u : listDog){
                line = u.getID() + ";" + u.getPetID() + "," + u.getDogName() + "," + u.getDogColor() + "," + u.getDogGender() + "," + u.getPrice() + "," + u.getDescribe();
                out.write(line + "\n");
            }
            System.out.println("File saved successfully!");
            out.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
    }

    @Override
    public void sortByName() {
        Collections.sort(listDog, new Comparator<Dog>(){
            //@Override
            public int compare(Dog o1, Dog o2){
                return o1.getDogName().compareToIgnoreCase(o2.getDogName());
            }
        });
    }

    @Override
    public void sortByPrice() {
        Collections.sort(listDog, new Comparator<Dog>(){
            @Override
            public int compare(Dog o1, Dog o2){
                if(o1.getPrice() > o2.getPrice())
                    return 1;
                if(o1.getPrice() == o2.getPrice())
                    return 0;
                return -1;
            }
        });
    }
    
    public void outListDogName(){
        sortByName();
        outDog();
    }
    
    public void outListDogPrice(){
        sortByPrice();
        outDog();
    }
    
    public boolean searchDogByID(List<Dog> listDog, int ID) {
        for(Dog x : listDog)
            if(x.getID() == ID) return true;
        return false;
    }

    public boolean searchPetDogByID(List<PetDog> listPetDog, int ID) {
        for(PetDog x : listPetDog)
            if(x.getID() == ID) return true;
        return false;
    }
    
    @Override
    public void searchByColor(String color) {
        System.out.println("Dog(s) with color " + color + " : ");
        for(Dog x : listDog)
            if(x.getDogColor().equalsIgnoreCase(color))
                System.out.println(x.toString());
    }

    @Override
    public void searchByPrices(double price1, double price2) {
        System.out.println("Dog(s) with price range form " + price1 + " to " + price2 + " : ");
        for(Dog x : listDog)
            if(price1 <= x.getPrice() && x.getPrice() <= price2)
                System.out.println(x.toString());
    }

}
