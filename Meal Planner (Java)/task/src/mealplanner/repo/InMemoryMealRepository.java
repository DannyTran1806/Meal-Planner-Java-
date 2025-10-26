package mealplanner.repo;

import mealplanner.domain.Meal;
import java.util.ArrayList;
import java.util.List;

public class InMemoryMealRepository implements MealRepository {
    private List<Meal> meals = new ArrayList<>();

    @Override
    public void save(Meal meal){
        this.meals.add(meal);
    }
    public List<Meal> getMeals(){
        return this.meals;
    }
    @Override
    public void printMeals(){
        if (meals.isEmpty()){
            System.out.println("No meals saved. Add a meal first.");
        }else {
            for (Meal meal : this.meals){
                System.out.printf("%nCategory: %s%nName: %s%n", meal.getCategory(), meal.getMealName());
                System.out.println("Ingredients:");
                for (String ingredient : meal.getIngredients()) {
                    System.out.println(ingredient);
                }
            }
            System.out.println();
        }
    }
}
