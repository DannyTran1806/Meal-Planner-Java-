package mealplanner;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.println("Which meal do you want to add (breakfast, lunch, dinner)?");
      String mealCategory = input.nextLine().trim();
      System.out.println("Input the meal's name:");
      String mealName = input.nextLine().trim();
      System.out.println("Input the ingredients:");
      String ingredientList = input.nextLine().trim();
      String[] ingredients = ingredientList.split("\\s*,\\s*");
      System.out.printf("%nCategory: %s%nName: %s%n", mealCategory, mealName);
      System.out.println("Ingredients:");
      for (String ingredient : ingredients) {
          System.out.println(ingredient);
      }
      System.out.println("The meal has been added!");
  }
}