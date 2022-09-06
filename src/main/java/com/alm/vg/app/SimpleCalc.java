package com.alm.vg.app;

import java.util.Scanner;

import com.alm.vg.app.Operations.Operation;

public class SimpleCalc {
    private int value1;
    private int value2;

    private int result;

    private State state = State.INPUT_ONE;
    private State previous = State.INPUT_ONE;

    private Operation operation = Operation.ADDITION;
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    protected enum State {
        INPUT_ONE, INPUT_TWO, OPERATION, RESULT, ERROR, PRINT
    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getResult() {
        return result;
    }

    public State getState() {
        return state;
    }

    public Operation getOperation() {
        return operation;
    }

    public void run() {
        System.out.println("Welcome to a simple calculator...");
        System.out.println("Q to quit");
        while (running) {
            switch (state) {
                case INPUT_ONE -> {
                    System.out.print("Enter value1: ");
                    value1 = request(takeInput());
                    state = State.INPUT_TWO;
                }
                case INPUT_TWO -> {
                    System.out.print("Enter value2: ");
                    value2 = request(takeInput());
                    state = State.OPERATION;
                }
                case OPERATION -> {
                    System.out.println("Enter the operation of choice");
                    System.out.println("1) Addition");
                    System.out.println("2) Subtraction");
                    chooseOperation(takeInput());
                }
                case RESULT -> result = calculateResult();
                case PRINT -> {
                    System.out.println("Operation result: " + result);
                    state = State.INPUT_ONE;
                }
                case ERROR -> {
                    System.out.println("Invalid value (Q to quit)");
                    state = previous;
                }
            }
        }
    }

    protected int request(String input) {
        try {
            int value = parseInput(input);
            state = State.OPERATION;
            return value;
        } catch (NumberFormatException e) {
            previous = state;
            state = State.ERROR;
            return 0;
        }
    }

    private String takeInput() {
        return scanner.nextLine();
    }

    private int parseInput(String input) throws NumberFormatException {
        if (input.equalsIgnoreCase("q"))
            running = false;
        return Integer.parseInt(input);
    }

    protected void chooseOperation(String input) {
        switch (input.toLowerCase()) {
            case "1" -> {
                operation = Operation.ADDITION;
                state = State.RESULT;
            }
            case "2" -> {
                operation = Operation.SUBTRACTION;
                state = State.RESULT;
            }
            case "q" -> running = false;
            default -> {
                previous = state;
                state = State.ERROR;
            }
        }
    }

    protected int calculateResult() {
        int result = 0;
        switch (operation) {
            case ADDITION -> result = Operations.add(value1, value2);
            case SUBTRACTION -> result = Operations.subtract(value1, value2);
        }
        state = State.PRINT;
        return result;
    }

}
