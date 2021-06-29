package com.assignment.dunzo.machine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Machine {
    private Outlet outlets;

    @JsonProperty("total_items_quantity")
    private HashMap<String, Integer> itemsQuantity;

    @JsonProperty("beverages")
    private HashMap<String, HashMap<String, Integer>> beverages;
}

