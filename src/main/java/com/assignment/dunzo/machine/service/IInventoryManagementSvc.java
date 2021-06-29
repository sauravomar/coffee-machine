package com.assignment.dunzo.machine.service;

import com.assignment.dunzo.machine.entities.Bevarage;

import java.util.HashMap;

public interface IInventoryManagementSvc {
    boolean process(Bevarage beverage);
    void setInventory(HashMap<String, Integer> inventory);
}
