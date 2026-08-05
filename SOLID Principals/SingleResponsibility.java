/**
 * SINGLE RESPONSIBILITY PRINCIPLE (SRP)
 * 
 * Definition: A class should have only ONE reason to change.
 * This means a class should focus on a single task, responsibility, or role.
 * 
 * Instead of creating one large "BakeryEmployee" class that handles baking, managing stock,
 * and selling, we separate the concerns into three focused classes: Baker, InventoryManager, and SalesPerson.
 */

// 1. Baker class is only responsible for baking products.
// If the baking process or recipes change, only this class changes.
class Baker {
    public void bake() {
        System.out.println("Baking..");
    }
}

// 2. InventoryManager class is only responsible for checking stock levels.
// If the inventory logic changes, only this class changes.
class InventoryManager {
    public void manageInventory() {
        System.out.println("Managing Inventory..");
    }
}

// 3. SalesPerson class is only responsible for handling customer checkouts.
// If selling procedures change, only this class changes.
class SalesPerson {
    public void Selling() {
        System.out.println("Selling...");
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {
        
        Baker b = new Baker();
        InventoryManager i = new InventoryManager();
        SalesPerson s = new SalesPerson();

        b.bake();
        i.manageInventory();
        s.Selling();
    }
}

