import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int Choice;
        Scanner sc = new Scanner(System.in);

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
        System.out.println("13. Search dogs based on its prices, from price… to price..");
        System.out.println("0. Exit");
        System.out.println("=============================");
        System.out.print("Make your choice : ");
        Choice = sc.nextInt();

        switch(Choice){
            case 1:
                
                break;

            case 2:
                break;
        }

    }
}
