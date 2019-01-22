/*
Michael Peters
HW1
Partners:
Date: 01.20.19
 */

import java.util.Scanner;
import java.util.Random;

public class Yahtzee {
    public static void main(String[] args) {
        System.out.println("Welcome to Yahtzee!");
        inputName();
        for (int i = 0; i < 5; i++){
            System.out.println(rollDie());
        }
    }
    private static void inputName(){
        Scanner s = new Scanner(System.in);
        System.out.print( "Enter your name: "  );
        String name = s.nextLine();
        System.out.println( "Hello " + name + "!" );
    }
    private static int rollDie(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
