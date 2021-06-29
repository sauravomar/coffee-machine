package com.assignment.dunzo.machine.command;


import com.assignment.dunzo.machine.exception.WeldingMachineException;

import java.util.List;

public interface Command {
    public String execute(List<String> params) throws WeldingMachineException;
}
