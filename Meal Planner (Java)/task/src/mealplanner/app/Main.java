package mealplanner.app;

import mealplanner.repo.InMemoryMealRepository;
import mealplanner.service.MealService;
import mealplanner.ui.ConsoleUI;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      MealService service = new MealService(new InMemoryMealRepository());
      ConsoleUI ui = new ConsoleUI(service);
      ui.menu();
  }
}