package com.assignment.dunzo.machine.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Outlet {
    @JsonProperty("count_n")
    private int count;
}