/*
Michael Peters
HW1
Partners: Jackson Ricks
Date: 01.20.19
 */

import java.util.Scanner;
import java.util.Random;

public class Yahtzee {

    //
    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rolls = new int[5];

        for (int i = 0; i < 5; i++){
            rolls[i] = rollDie();
        }
        //
        String keep = "nnnnn"; //setup to roll all dice in the first roll
        int turn = 1;
        while (turn < 4 && keep != "yyyyy")
        {
            //roll dice not kept
            for (int dieNumber = 0; dieNumber < 5; dieNumber++)
            {
                if (keep.charAt(dieNumber) != 'y')
                    rolls[dieNumber] = rollDie();
            }
            //output roll
            System.out.println("Your roll was: ");
            for (int dieNumber = 0; dieNumber < 5; dieNumber++)
            {
                System.out.print(rolls[dieNumber] + " ");
            }
            System.out.println();
            //if not the last roll of the hand prompt the user for dice to keep
            if (turn < 3)
            {
                System.out.println("enter dice to keep (y or n) ");
                sc.nextLine();
            }
            turn++;
        }

        //

        arraySort(rolls, 5);
        String message = "Roll 1:   " +rolls[0] + "\nRoll 2:   " + rolls[1] + "\nRoll 3:   " + rolls[2] + "\nRoll 4:   " + rolls[3] + "\nRoll 5:   " + rolls[4] + "\n\nTotal:    " + totalDice(rolls);
        System.out.print(message);
        System.exit(0);
    }
    //
    //

    private static int rollDie(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
    private static void arraySort(int[] array, int size){
        boolean swap;
        int temp;

        do
        {
            swap = false;
            for (int count = 0; count < (size - 1); count++)
            {
                if (array[count] > array[count + 1])
                {
                    temp = array[count];
                    array[count] = array[count + 1];
                    array[count + 1] = temp;
                    swap = true;
                }
            }
        } while (swap);
    }
    private static int totalDice(int[] array){
        int total = 0;
        for (int diePosition = 0; diePosition < 5; diePosition++)
        {
            total += array[diePosition];
        }
        return total;

    }
}
