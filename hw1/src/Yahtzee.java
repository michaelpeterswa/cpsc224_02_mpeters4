/*
Michael Peters
HW1
Partners:
Date: 01.20.19
 */

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class Yahtzee {
    public static void main(String[] args) {
        int[] rolls = new int[5];

        //inputName();
        for (int i = 0; i < 5; i++){
            rolls[i] = rollDie();
        }

        String message = "Roll 1: " +rolls[0] + "  Roll 2: " + rolls[1] + "  Roll 3: " + rolls[2] + "  Roll 4: " + rolls[3] + "  Roll 5: " + rolls[4];
        JOptionPane.showMessageDialog(null, message, "Current Dice Roll", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
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
