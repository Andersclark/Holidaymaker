package io.andersclark;
import java.util.Scanner;

public class Client {

    public Client(){
        printMenu();
        userPickMenuOption();
    }

    private void printMenu(){
        System.out.println("Choose option:");
        System.out.println("  1  Register new customer");
        System.out.println("  2  Book a room");
        System.out.println("  3  Cancel a booking");
        System.out.println("  4  Search for rooms");
        System.out.println("  5  Exit program");
    }

    private void userPickMenuOption(){
        Scanner myInput = new Scanner(System.in);
        String option;
        option = myInput.nextLine();
        switch(option){
            case "1":
                System.out.println("You choose 1 - Register new customer");
                break;
            case "2":
                System.out.println("You choose 2 - Book a room");
                break;
            case "3":
                System.out.println("You choose 3 - Cancel a booking");
                System.out.println("  What country?");
                String country;
                country = myInput.nextLine();
                System.out.println("You choose " + country);
                break;
            case "4":
                System.out.println("You choose 4");
                break;
            case "5":
                System.out.println("PROGRAM TERMINATING...");
                break;
        }
    }
}
