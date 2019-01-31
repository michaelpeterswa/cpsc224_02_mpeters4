/*
Homework #1
Due Date: 01.31.19
Names: Michael Peters 
       Jackson Ricks
 */

import java.util.Scanner;
import java.util.Random;

public class Yahtzee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char playAgain = 'y';
        int[] rolls = new int[5];
        String keep ; //setup to roll all dice in the first roll
        int turn;
        while (playAgain == 'y')
        {
        for (int i = 0; i < 5; i++){
            rolls[i] = rollDie();
        }
        //
        keep = "nnnnn"; //setup to roll all dice in the first roll
        turn = 1;
        while (turn < 4 && !keep.equals("yyyyy"))
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
                keep = sc.nextLine();                
            }
            turn++;
        }
        // Start of scoring
        // hand being sorted

        arraySort(rolls, 5);
        System.out.println("\nYour sorted hand is");
        for (int dieNumber = 0; dieNumber < 5; dieNumber++)
        {
            System.out.print(rolls[dieNumber] + " ");
        }
        System.out.println();

        //upper scorecard
        for (int dieValue = 1; dieValue <=6; dieValue++)
        {
          int currentCount = 0;
          for (int diePosition = 0; diePosition < 5; diePosition++)
          {
              if (rolls[diePosition] == dieValue)
                  currentCount++;
          }
        System.out.print("Score " + dieValue * currentCount + " on the ");
        System.out.println(dieValue + " line");
        }

        // lower scorecard
        if (maxOfAKindFound(rolls) >= 3)
        {
            System.out.print( "Score " + totalDice(rolls) + " on the ");
            System.out.println("3 of a Kind line");
        }
        else System.out.println("Score 0 on the 3 of a Kind line");

        if (maxOfAKindFound(rolls) >= 4)
        {
            System.out.print("Score " + totalDice(rolls) + " on the ");
            System.out.println("4 of a Kind line");
        }
        else System.out.println("Score 0 on the 4 of a Kind line");

        if (fullHouseFound(rolls))
            System.out.println("Score 25 on the Full House line");
        else
            System.out.println("Score 0 on the Full House line");

        if (maxStraightFound(rolls) >= 4)
            System.out.println("Score 30 on the Small Straight line");
        else
            System.out.println("Score 0 on the Small Straight line");
    
        if (maxStraightFound(rolls) >= 5)
            System.out.println("Score 40 on the Large Straight line");
        else
            System.out.println("Score 0 on the Large Straight line");
    
        if (maxOfAKindFound(rolls) >= 5)
            System.out.println("Score 50 on the Yahtzee line");
        else
            System.out.println("Score 0 on the Yahtzee line");

        System.out.print("Score " + totalDice(rolls) + " on the ");
        System.out.println("Chance line");
       
        // Asks user if they would play again
        System.out.print("\nEnter 'y' to play again ");
        playAgain = sc.next().charAt(0);
        sc.nextLine();
    }


        System.exit(0);
    }
    //this function simulates the rolling of a single die
    private static int rollDie(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
    //bubble sort from  Gaddis chapter 8
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
    //this function returns the total value of all dice in a hand
    private static int totalDice(int[] array){
        int total = 0;
        for (int diePosition = 0; diePosition < 5; diePosition++)
        {
            total += array[diePosition];
        }
        return total;

    }
    //this function returns the count of the die value occurring most in the hand
    //but not the value itself
    private static int maxOfAKindFound(int [] array){
        int maxCount = 0;
        int currentCount ;
        for (int dieValue = 1; dieValue <=6; dieValue++)
        {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++)
            {
               if (array[diePosition] == dieValue)
                   currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }
    //this function returns true if the hand is a full house
    //or false if it does not
    private static boolean fullHouseFound(int [] hand){
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount ;
        for (int dieValue = 1; dieValue <=6; dieValue++)
        {
            currentCount = 0;
            for (int diePosition = 0; diePosition < 5; diePosition++)
            {
                if (hand[diePosition] == dieValue)
                   currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K && found3K)
            foundFH = true;
        return foundFH;
    }
    //this function returns the length of the longest
    //straight found in a hand
    public static int maxStraightFound(int [] hand){
        int maxLength = 1;
        int curLength = 1;
        for(int counter = 0; counter < 4; counter++)
        {
            if (hand[counter] + 1 == hand[counter + 1] ) //jump of 1
                curLength++;
            else if (hand[counter] + 1 < hand[counter + 1]) //jump of >= 2
                 curLength = 1;
            if (curLength > maxLength)
                 maxLength = curLength;
        }   
        return maxLength;
    }
}
