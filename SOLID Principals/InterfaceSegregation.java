/**
 * INTERFACE SEGREGATION PRINCIPLE (ISP)
 * 
 * Definition: Clients should not be forced to depend on methods that are irrelevant to them,
 * avoiding unnecessary dependencies. The goal is to prevent fat interfaces by using multiple
 * small, client-specific interfaces, each with a clear and specific responsibility.
 * 
 * Analogy:
 * Suppose you enter a restaurant and you are a pure vegetarian. A menu card containing
 * vegetarian, non-vegetarian, drinks, and sweets is handed to you. 
 * Clients/Customers should receive a menu relevant only to their needs (e.g., vegetarian only) 
 * instead of a fat, general menu with unnecessary items.
 * Splitting a common menu into smaller, specific ones reduces unnecessary dependencies and minimizes future changes.
 */

import java.util.*;

// 1. Interface for vegetarian menu
interface IVegetarianMenu {
    List<String> getVegetarianItems();
}

// 2. Interface for non-vegetarian menu
interface INonVegetarianMenu {
    List<String> getNonVegetarianItems();
}

// 3. Interface for drinks menu
interface IDrinkMenu {
    List<String> getDrinkItems();
}

// Class for vegetarian menu implementing only the vegetarian interface
class VegetarianMenu implements IVegetarianMenu {
    @Override
    public List<String> getVegetarianItems() {
        return Arrays.asList("Vegetable Curry", "Paneer Tikka", "Salad");
    }
}

// Class for non-vegetarian menu implementing only the non-vegetarian interface
class NonVegetarianMenu implements INonVegetarianMenu {
    @Override
    public List<String> getNonVegetarianItems() {
        return Arrays.asList("Chicken Curry", "Fish Fry", "Mutton Biryani");
    }
}

// Class for drinks menu implementing only the drink interface
class DrinkMenu implements IDrinkMenu {
    @Override
    public List<String> getDrinkItems() {
        return Arrays.asList("Water", "Soda", "Juice");
    }
}

// Helper class to display menu items for specific customer roles
class MenuDisplay {
    public static void displayVegetarianMenu(IVegetarianMenu menu) {
        System.out.println("Vegetarian Menu:");
        for (String item : menu.getVegetarianItems()) {
            System.out.println("- " + item);
        }
    }

    public static void displayNonVegetarianMenu(INonVegetarianMenu menu) {
        System.out.println("Non-Vegetarian Menu:");
        for (String item : menu.getNonVegetarianItems()) {
            System.out.println("- " + item);
        }
    }
}

public class InterfaceSegregation {
    public static void main(String[] args) {
        VegetarianMenu vegMenu = new VegetarianMenu();
        NonVegetarianMenu nonVegMenu = new NonVegetarianMenu();
        DrinkMenu drinkMenu = new DrinkMenu();

        // Vegetarian customer displays only vegetarian menu options
        MenuDisplay.displayVegetarianMenu(vegMenu);
        
        System.out.println();

        // Non-vegetarian customer displays only non-vegetarian menu options
        MenuDisplay.displayNonVegetarianMenu(nonVegMenu);
    }
}
