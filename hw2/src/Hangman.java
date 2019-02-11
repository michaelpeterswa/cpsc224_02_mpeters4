import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        //inputName();

        //String message = "fuck you bih";
        //JOptionPane.showMessageDialog(null, message, "Hello!", JOptionPane.WARNING_MESSAGE);
        gameTime();
    }

    private static void inputName() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = s.nextLine();
        System.out.println("Hello " + name + "!");

    }

    public static String randWords() {
        String hangWords [] = {"help", "awkward" ,"bagpipes" , "banjo" , "bungler", "croquet", "crypt", "dwarves" ,"fervid", 
        "fishhook","fjord", "gypsy",  "haiku", "haphazard", "jinx", "kiosk", "memento", "ostracize", "phlegm", 
        "pixel", "rogue", "sphinx", "waxy", "wildebeest", "yacht", "zealous" };

        Random rand = new Random();
        int i = rand.nextInt(25) + 1;
        return hangWords[i];
    }
    
    public static void gameTime() {
        String word = randWords();
        int amountOfMisses;
        amountOfMisses = 0;
        int length = word.length();
        String dashes = "";
        for (int i = 0; i < length; i++)
        {
            dashes = dashes + "_";
        }
        String placeHolder = dashes;

        boolean win = true;

        while (!word.equals(dashes)){
          dashes = correctGuess(word, dashes, length);
          if (dashes == placeHolder) {
            amountOfMisses++;
            theHangedMan(amountOfMisses);
            if(amountOfMisses > 5) {
                win = false;
                break;}
          }
          else
          {
              placeHolder = dashes;
          }
        }
        
        if(win == true)
        {
            JOptionPane.showMessageDialog(null, "Congratulations    \n your word was:   \n  " + word);
        }
        else
            JOptionPane.showMessageDialog(null, "**Hangman** \n************** \n----------- \n  " + word + "\n----------- \n**************");
    } 

    public static String correctGuess (String word, String dashes, int length) {
        
        JOptionPane.showMessageDialog(null, "**Hangman** \n************** \n----------- \n  " + dashes + "\n----------- \n**************");
        String j;
        boolean flag = false;
        j = JOptionPane.showInputDialog(null, "Enter a letter");
        j.toLowerCase();
        char guess = j.charAt(0);
        if (Character.isLetter(guess))
        {
          for (int i = 0; i < length; i++) 
          {
              if (guess == word.charAt(i)) {
                dashes = changeCharInPosition(i, guess, dashes);
                flag = true; }
          }
        }
        if (flag == false) {
            JOptionPane.showMessageDialog(null, "You missed");
        }
        return dashes;
    }

    public static String changeCharInPosition(int position, char ch, String str) {
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }

    public static void theHangedMan(int pain) {
        if (pain == 1) 
            JOptionPane.showMessageDialog(null, "   O   ");
        if (pain == 2) 
            JOptionPane.showMessageDialog(null, "   O   \n   |  ");
        if (pain == 3) 
            JOptionPane.showMessageDialog(null, "   O   \n  -|  ");
        if (pain == 4) 
            JOptionPane.showMessageDialog(null, "   O   \n  -|-  ");
        if (pain == 5) 
            JOptionPane.showMessageDialog(null, "   O   \n  -|-  \n   /");
        if (pain == 6) 
            JOptionPane.showMessageDialog(null, "    X   \n    |    \n   / \\");
    }






}