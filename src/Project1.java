/*
Name: Robert Hardy
Project Name: Programming Project 1 - CMIS 215
Date: 28 Oct 2023
Class Description: Primary class that handles user input and converts it to a Player object and then finds the tallest
player that is LTE to the average age of the list of Players.
*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        // Takes input from user: num of players and each player's info
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of players: ");
        ArrayList<Player> arrayList = new ArrayList<>();

        // Loops through num of players and creates Player obj for each and gets sum of age from all players
        int sumOfAge = 0;
        int numOfPlayers = input.nextInt();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.printf("What is player %d's name (first and last):\n", i + 1);
            String name = input.next();
            name += " " + input.next();
            int age;
            int feet;
            int inches;
            while (true) {
                try {
                    System.out.printf("What is %s's age: ", name);
                    age = input.nextInt();
                    break;
                } catch (InputMismatchException ex) {
                    input.next();
                    System.out.println("Please enter a valid integer\n");
                }
            }
            while (true) {
                try {
                    System.out.printf("What is %s's height (feet inches) ", name);
                    feet = input.nextInt();
                    inches = input.nextInt();
                    break;
                } catch (InputMismatchException ex) {
                    input.next();
                    System.out.println("Please enter a valid integer\n");
                }
            }

            Player player = new Player(name,
                    new Height(feet, inches),
                    age);
            sumOfAge += player.getAge();
            arrayList.add(player);
        }

        // Calculates average by sum of age divided by num of players. Purpose for making avgAge double is only for stats
        double avgAge = (double) sumOfAge / numOfPlayers;

        // Iterates through player list and finds player of tallest height that has an age LTE average age
        Player currentTallestPlayer = null;
        for (Player player : arrayList) {
            if (player.getAge() <= avgAge) {
                if (currentTallestPlayer == null) {
                    currentTallestPlayer = player;
                } else if (player.getHeight().toInches() > currentTallestPlayer.getHeight().toInches()) {
                    currentTallestPlayer = player;
                }
            }
        }

        // Prints tallest player's information: name, age, height (feet'inches")
        if (currentTallestPlayer != null) {
            System.out.printf("\nAverage age of players:\t%f\n", avgAge);
            System.out.println("Tallest player less or equal to average age:");
            System.out.println(currentTallestPlayer);
        } else {
            System.out.println("No players were inputted!");
        }
    }
}