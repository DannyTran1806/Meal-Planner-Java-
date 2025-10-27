package mealplanner.ui;

import mealplanner.domain.Meal;
import mealplanner.service.MealService;

import java.util.*;
import static mealplanner.util.Parsers.splitCommaTrim;

public class ConsoleUI {
    private MealService service;
    public ConsoleUI(MealService service) {
        this.service = service;
    }

    public void add(){
        Scanner input = new Scanner(System.in);
        String mealCategory = "";
        while(true){
            System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
            mealCategory = input.nextLine().trim();
            if(mealCategory.equals("breakfast") || mealCategory.equals("lunch") || mealCategory.equals("dinner")){
                break;
            } else {
                System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            }
        }
        System.out.println("Input the meal's name:");
        String mealName = input.nextLine().trim();
        while (!mealName.matches("[a-zA-Z ]+")){
            System.out.println("Wrong format. Use letters only!");
            mealName = input.nextLine().trim();
        }
        System.out.println("Input the ingredients:");
        String[] ingredients =  null;
        boolean exit = false;
        while(!exit){
            String ingredientList = input.nextLine().trim();
            ingredients = splitCommaTrim(ingredientList);
            for (String ingredient : ingredients){
                if(ingredientList.endsWith(",") || ingredient.isEmpty() || !ingredient.matches("[a-zA-Z ]+")){
                    exit = false;
                    break;
                }else {
                    exit = true;
                }
            }
            if(!exit){
                System.out.println("Wrong format. Use letters only!");
            }
        }
        System.out.println("The meal has been added!");

        //TODO: save the meals in InMemoryRepository
        Meal meal = new Meal(mealCategory, mealName, List.of(ingredients));
        service.save(meal);

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
                    service.printMeals();
                }
                case "exit" -> {
                    exit = true;
                    System.out.println("Bye!");
                }
                default -> {
                }
            }
        }
    }
}
