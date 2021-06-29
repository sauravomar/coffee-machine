package com.assignment.dunzo.machine.exception;


public class WeldingMachineException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1163781632957333405L;

    public WeldingMachineException(String message) {
        super(message);
    }

    public WeldingMachineException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeldingMachineException(Throwable cause) {
        super(cause);
    }

}