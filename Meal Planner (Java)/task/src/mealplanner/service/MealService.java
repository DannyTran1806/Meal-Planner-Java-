package mealplanner.service;

import mealplanner.domain.Meal;
import mealplanner.repo.MealRepository;

import java.util.List;

public class MealService {
    private MealRepository repo;
    public MealService(MealRepository repo) {
        this.repo = repo;
    }

    public Meal createMeal(String category, String mealName, String[] ingredients) {
        return new  Meal(category, mealName, List.of(ingredients));
    }

    public void save(Meal meal) {
        repo.save(meal);
    }

    public void printMeals(){
        repo.printMeals();
    }
}
