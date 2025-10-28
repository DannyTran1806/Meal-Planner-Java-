package mealplanner.ui;

import mealplanner.domain.Meal;
import mealplanner.service.MealService;

import java.util.*;
import static mealplanner.util.Parsers.splitCommaTrim;

public class ConsoleUI {
    private static final Set<String> ALLOWED_CATEGORIES = new HashSet<>(Arrays.asList("breakfast", "lunch", "dinner"));
    private MealService service;
    public Scanner input;
    public ConsoleUI(MealService service, Scanner input) {
        this.service = service;
        this.input = new Scanner(System.in);
    }

    public void menu(){
        boolean exit = false;
        while(!exit){
            System.out.println("What would you like to do (add, show, exit)?");
            switch (input.nextLine().trim()){
                case "add" -> {
                    add();
                }
                case "show" -> {
                    show(service);
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

    public void add(){
        String mealCategory = promptCategory();
        String mealName = mealName();
        String[] ingredients = promptIngredients();

        //Save the meal in the InMemoryMealRepository
        Meal meal = new Meal(mealCategory, mealName, List.of(ingredients));
        service.save(meal);

        System.out.println("The meal has been added!");
    }

    public void show(MealService service) {
        service.printMeals();
    }

    // ---- helpers ------------------------------------------------------------
    private String promptCategory() {
        while(true){
            System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
            String mealCategory = input.nextLine().trim().toLowerCase();
            if(ALLOWED_CATEGORIES.contains(mealCategory)){
                return mealCategory;
            } else {
                System.out.println("Wrong meal category! Choose from: breakfast, lunch, dinner.");
            }
        }
    }

    private String mealName() {
        System.out.println("Input the meal's name:");
        String mealName = input.nextLine().trim();
        while (!mealName.matches("[a-zA-Z ]+")){
            System.out.println("Wrong format. Use letters only!");
            mealName = input.nextLine().trim();
        }
        return mealName;
    }

    private String[] promptIngredients() {
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
        return ingredients;
    }
}
