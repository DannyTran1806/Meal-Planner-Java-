package mealplanner.domain;

import java.util.List;

public class Meal {
    private String category;
    private String mealName;
    private List<String> ingredients;

    public Meal(String category, String mealName, List<String> ingredients) {
        this.category = category;
        this.mealName = mealName;
        this.ingredients = ingredients;
    }
    public String getCategory() {
        return category;
    }
    public String getMealName() {
        return mealName;
    }
    public List<String> getIngredients() {
        return ingredients;
    }
}
