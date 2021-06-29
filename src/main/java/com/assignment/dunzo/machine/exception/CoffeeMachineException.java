package com.assignment.dunzo.machine.exception;


public class CoffeeMachineException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1163781632957333405L;

    public CoffeeMachineException(String message) {
        super(message);
    }

    public CoffeeMachineException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoffeeMachineException(Throwable cause) {
        super(cause);
    }

}