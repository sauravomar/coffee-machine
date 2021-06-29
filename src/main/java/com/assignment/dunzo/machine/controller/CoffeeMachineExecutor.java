package com.assignment.dunzo.machine.controller;

import com.assignment.dunzo.machine.entities.Bevarage;
import com.assignment.dunzo.machine.entities.CoffeeMachineInput;
import com.assignment.dunzo.machine.exception.CoffeeMachineException;
import com.assignment.dunzo.machine.service.IInventoryManagementSvc;
import com.assignment.dunzo.machine.service.InventoryManagementSvc;
import com.assignment.dunzo.machine.util.BeverageMakerThread;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class CoffeeMachineExecutor {

    private static CoffeeMachineExecutor coffeeMachineExecutor;
    public CoffeeMachineInput coffeeMachineInput;
    public IInventoryManagementSvc inventoryManagementSvc;
    private ExecutorService executor;


    /**
     * making this class singleton in nature because at a time only 1 coffee machine exists.
     */
    public static CoffeeMachineExecutor getInstance(String input) throws CoffeeMachineException {
        if (coffeeMachineExecutor == null) {
            coffeeMachineExecutor = new CoffeeMachineExecutor(input);
        }
        return coffeeMachineExecutor;
    }

    private CoffeeMachineExecutor(String input) throws CoffeeMachineException {
        System.out.println("Booting New Coffee Machine");
        try{
            this.coffeeMachineInput = new ObjectMapper().readValue(input, CoffeeMachineInput.class);
        }catch (Exception ex){
            throw new CoffeeMachineException(" Failed to parse input");
        }
        executor = Executors.newFixedThreadPool(this.coffeeMachineInput.getMachine().getOutlets().getCount());
    }

    public void prepareItems() {
        System.out.println("Start preparing items");
        setInventory();

        // prepare items with given materials
        HashMap<String, HashMap<String, Integer>> beverages = this.coffeeMachineInput.getMachine().getBeverages();
        for (String key : beverages.keySet()) {
            Bevarage beverage = new Bevarage(key, beverages.get(key));
            executor.execute(new BeverageMakerThread(beverage, this.inventoryManagementSvc));
        }
    }


    public void stop() {
        executor.shutdown();
        inventoryManagementSvc.setInventory(new HashMap<>());
    }

    /*
        this method sets the inventory
     */
    private void setInventory() {
        //Setting inventory
        Map<String, Integer> itemsQuantity = coffeeMachineInput.getMachine().getItemsQuantity();
        HashMap<String, Integer>totalItemsQuantity = new HashMap<>();
        for (String key : itemsQuantity.keySet()) {
            totalItemsQuantity.put(key, itemsQuantity.get(key));
        }
        this.inventoryManagementSvc = InventoryManagementSvc.getInstance();
        this.inventoryManagementSvc.setInventory(totalItemsQuantity);
    }


}
