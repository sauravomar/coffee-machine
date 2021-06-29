package com.assignment.dunzo.machine.util;

import com.assignment.dunzo.machine.entities.Bevarage;
import com.assignment.dunzo.machine.service.IInventoryManagementSvc;

public class BeverageMakerThread implements Runnable {
    private Bevarage bevarage;
    private IInventoryManagementSvc inventoryManagementSvc;

    public BeverageMakerThread(Bevarage bevarage, IInventoryManagementSvc inventoryManagementSvc) {
        this.bevarage = bevarage;
        this.inventoryManagementSvc =  inventoryManagementSvc;
    }

    @Override
    public void run() {

        if (inventoryManagementSvc.process(bevarage)) {
            System.out.println(bevarage.getName() + " is prepared");
        }

    }
}
