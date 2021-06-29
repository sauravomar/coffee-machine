package com.assignment.dunzo.machine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Machine {
    @JsonProperty("outlets")
    private Outlet outlets;

    @JsonProperty("total_items_quantity")
    private HashMap<String, Integer> itemsQuantity;

    @JsonProperty("beverages")
    private HashMap<String, HashMap<String, Integer>> beverages;
}

