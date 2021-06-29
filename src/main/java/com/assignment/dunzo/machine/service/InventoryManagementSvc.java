package com.assignment.dunzo.machine.service;

import com.assignment.dunzo.machine.entities.Bevarage;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSvc  implements IInventoryManagementSvc{
    public static InventoryManagementSvc instance = null;

    //in memory maintainging inventory
    public HashMap<String, Integer> inventory = new HashMap<>();
    private InventoryManagementSvc() {}


    /*
        using singleton pattern to restrict creation of multiple objects
     */
    public static synchronized IInventoryManagementSvc getInstance() {
        if(instance == null){
            instance = new InventoryManagementSvc();
        }
        return instance;
    }


    //Making this thread safe by synchronizing so that at time only 1 drink  or thread can update inventory
    public synchronized boolean process(Bevarage beverage) {

        Map<String, Integer> allIngredients = beverage.getIngredients();
        boolean isPossible = true;

        // in case ingredients not required ideal world not possible better to handle.
        if (allIngredients.isEmpty()){
           return isPossible;
        }

        //checking ingredients in inventory
        for (String ingredient : allIngredients.keySet()) {
            int ingredientInventoryCount = inventory.getOrDefault(ingredient, -1);
            if (ingredientInventoryCount == -1 || ingredientInventoryCount == 0 || allIngredients.get(ingredient) > ingredientInventoryCount) {
                System.out.println(beverage.getName() + " cannot be prepared because " + ingredient + " is not available");
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            for (String ingredient : allIngredients.keySet()) {
                int existingInventory = inventory.get(ingredient);
                inventory.put(ingredient, existingInventory - allIngredients.get(ingredient));
            }
        }
        return isPossible;
    }

    public void setInventory(HashMap<String, Integer> inventory) {
        this.inventory = inventory;
    }

}
