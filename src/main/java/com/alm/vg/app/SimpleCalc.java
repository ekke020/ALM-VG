package com.alm.vg.app;

import java.util.Scanner;

import com.alm.vg.app.Operations.Operation;

public class SimpleCalc {
    private int value1;
    private int value2;
    private State state = State.INPUT;
    private Operation operation = Operation.ADDITION;

    private enum State {
        INPUT, OPERATION, RESULT
    }

    public void run() {
        System.out.println("Welcome to a simple calculator...");
        System.out.println("Q to quit");
        while (true) {
            switch (state) {
                case INPUT -> request();
                case OPERATION -> chooseOperation();
                case RESULT -> System.out.println("Total: " + calculateResult());
            }
        }
    }

    private void request() {
        try {
            System.out.print("Enter first value: ");
            value1 = parseInput(takeInput());
            System.out.print("Enter second value: ");
            value2 = parseInput(takeInput());
            state = State.OPERATION;
        } catch (NumberFormatException e) {
            System.out.println("Stick to numbers!");
            System.out.println("Q to quit");
        }
    }

    private String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int parseInput(String input) throws NumberFormatException {
        if (input.equalsIgnoreCase("q"))
            System.exit(0);
        return Integer.parseInt(input);
    }

    private void chooseOperation() {
        System.out.println("Enter the operation of choice");
        System.out.println("1) Addition");
        System.out.println("2) Subtraction");
        switch (takeInput()) {
            case "1" -> {
                operation = Operation.ADDITION;
                state = State.RESULT;
            }
            case "2" -> {
                operation = Operation.SUBTRACTION;
                state = State.RESULT;
            }
            default -> System.out.println("Invalid value (Q to quit)");
        }
    }

    private int calculateResult() {
        int result = 0;
        switch (operation) {
            case ADDITION -> result = Operations.add(value1, value2);
            case SUBTRACTION -> result = Operations.subtract(value1, value2);
        }
        state = State.INPUT;
        return result;
    }

}
