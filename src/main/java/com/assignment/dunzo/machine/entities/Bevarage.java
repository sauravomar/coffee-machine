package com.assignment.dunzo.machine.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Bevarage {
    private String name;
    private Map<String, Integer> ingredients;
}
