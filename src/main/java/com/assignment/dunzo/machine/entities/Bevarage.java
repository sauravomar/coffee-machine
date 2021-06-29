package com.assignment.dunzo.machine.entities;

import lombok.Getter;

import java.util.Map;

@Getter
public class Bevarage {
    private String name;

    public Bevarage(String name, Map<String, Integer> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    private Map<String, Integer> ingredients;
}
