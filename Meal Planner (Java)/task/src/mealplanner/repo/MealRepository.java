package mealplanner.repo;
import mealplanner.domain.Meal;

public interface MealRepository {
    void save(Meal meal);
    void printMeals();
}
