package mealplanner.ui;

import java.util.Scanner;

import static mealplanner.util.Parsers.splitCommaTrim;

public class ConsoleUI {
    public ConsoleUI() {}

    public void add(){
        Scanner input = new Scanner(System.in);
        System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
        String mealCategory = input.nextLine().trim();
        System.out.println("Input the meal's name:");
        String mealName = input.nextLine().trim();
        System.out.println("Input the ingredients:");
        String ingredientList = input.nextLine().trim();
        String[] ingredients = splitCommaTrim(ingredientList);
        System.out.println("The meal has been added!");

        //TODO: save the meals somehow to show them later on
        System.out.printf("%nCategory: %s%nName: %s%n", mealCategory, mealName);
        System.out.println("Ingredients:");
        for (String ingredient : ingredients) {
            System.out.println(ingredient);
        }
    }
    public void menu(){
        Scanner choice = new Scanner(System.in);
        boolean exit = false;
        while(!exit){
            System.out.println("What would you like to do (add, show, exit)?");
            switch (choice.nextLine().trim()){
                case "add" -> {
                    add();
                }
                case "show" -> {
                    System.out.println("All meals");
                }
                case "exit" -> {
                    exit = true;
                    break;
                }
            }
        }
    }
}
