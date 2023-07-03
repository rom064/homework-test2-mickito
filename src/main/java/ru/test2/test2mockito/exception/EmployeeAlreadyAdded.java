package ru.test2.test2mockito.exception;

public class EmployeeAlreadyAdded extends RuntimeException{
    public EmployeeAlreadyAdded(String message) {
        super(message);
    }

}
