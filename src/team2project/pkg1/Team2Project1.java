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
    import java.util.Comparator;
    import static java.lang.System.exit;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;

    /**
     *
     * @author _trananhhh
     */
    public class Team2Project1 {
        public static void main(String[] args){

            int Choice;
            Scanner sc = new Scanner(System.in);
            DogManage DM = new DogManage();

            while(true){
                System.out.println("=============================");
                System.out.println("Welcome to Dogs For Sale Management Program");
                System.out.println("Choose a funtion below : ");
                System.out.println("=============================");
                System.out.println("1. List all PetDogs");
                System.out.println("2. Add a new PetDog");
                System.out.println("3. Remove a PetDog by ID");
                System.out.println("4. Save PetDogs to petdog.txt file");
                System.out.println("5. List all Dogs");
                System.out.println("6. Add a new Dog");
                System.out.println("7. Remove a dog by ID");
                System.out.println("8. Update a dog based on its ID");
                System.out.println("9. Save Dogs to dog.txt file");
                System.out.println("10. List all dogs in ascending order of dog names");
                System.out.println("11. List all dogs in ascending order of dog prices");
                System.out.println("12. Search dogs based on its color");
                System.out.println("13. Search dogs based on its prices, from price ... to price ...");
                System.out.println("0. Exit");
                System.out.println("=============================");
                System.out.print("Make your choice : ");

                Choice = Integer.parseInt(sc.nextLine());

                switch(Choice){
                    case 1:
                        DM.outPetDog();
                        break;

                    case 2:
                        DM.addPetDog();
                        break;

                    case 3:
                        System.out.print("Enter the PetDog ID to delete : ");
                        try{
                            int ID = Integer.parseInt(sc.nextLine());
                            DM.deletePetDog(ID);
                        }
                        catch(NumberFormatException e){
                            System.out.println(e);
                        }
                        break;

                    case 4:
                        DM.savePetDogFile();
                        break;

                    case 5:
                        DM.outDog();
                        break;

                    case 6:
                        DM.addDog();
                        break;

                    case 7:
                        System.out.print("Enter the Dog ID to delete : ");
                        try{
                            int ID = Integer.parseInt(sc.nextLine());
                            DM.deleteDog(ID);
                        }
                        catch(NumberFormatException e){
                            System.out.println(e);
                        }
                        break;

                    case 8:
                        System.out.print("Enter the Dog ID to modify : ");
                        try{
                            int ID = Integer.parseInt(sc.nextLine());
                            DM.updateDog(ID);
                        }
                        catch(NumberFormatException e){
                            System.out.println(e);
                        }
                        break;

                    case 9:
                        DM.saveDogFile();
                        break;

                    case 10:
                        DM.outListDogName();
                        break;

                    case 11:
                        DM.outListDogPrice();
                        break;

                    case 12:
                        DM.searchByColor(sc.nextLine());
                        break;

                    case 13:
                        DM.searchByPrices(sc.nextDouble(), sc.nextDouble());
                        break;

                    case 0:
                        System.out.println("See you again!");
                        exit(0);
                }

            }

        }
    }
