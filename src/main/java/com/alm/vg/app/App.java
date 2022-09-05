package com.alm.vg.app;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int value1;
        int value2;
        while (true) {
            try {
                System.out.println("Enter first value: ");
                value1 = parseInput(takeInput());
                System.out.println("Enter second value: ");
                value2 = parseInput(takeInput());
            } catch (NumberFormatException e) {
                System.out.println("Stick to numbers!");
                continue;
            }
            int result = add(value1, value2);
            System.out.println("Total: " + result);
        }
    }

    private static String takeInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static int parseInput(String input) {
        return Integer.parseInt(input);
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

}
