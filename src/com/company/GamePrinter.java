package com.company;

public class GamePrinter {


    public static void printInstructions() {

        System.out.println("Enter a letter.");

    }
    public static void printFinalResult(boolean result){
        if(result) {
            System.out.println("You've won!");
        }else{
            System.out.println("You've lost!");
        }
    }

    public static void printCurrentResult(String currentResult){
        System.out.println("The current word : " + currentResult);
    }
}
