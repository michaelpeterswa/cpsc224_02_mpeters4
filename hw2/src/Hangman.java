/*
Homework #2
Due Date: 02.12.19
Names: Michael Peters 
       Jackson Ricks
 */
import javax.swing.JOptionPane;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        gameTime();
    }

    // Returns a word that the user has provided 
    private static String inputWord() {
        String j;
        j = JOptionPane.showInputDialog(null, "Enter a word");
        return j.toLowerCase();
    }

    // Returns a character from a user that will determine if a user wants to play
    private static char inputMenu() {
        String j;
        j = JOptionPane.showInputDialog(null, "Would you like to play hangman? (y/n)");
        return j.toLowerCase().charAt(0);
    }

    // Returns a character from a user that determines if a user wants to use their own word or a random word
    private static char inputChoice() {
        String j;
        j = JOptionPane.showInputDialog(null, "Would you like to use your own word? (y/n): ");
        return j.toLowerCase().charAt(0);
    }

    // Returns a random word from a preset array of words
    private static String randWords() {
        String [] hangWords;
        hangWords = new String[]{"help", "awkward" ,"bagpipes" , "banjo" , "bungler", "croquet", "crypt", "dwarves" ,"fervid",
        "fishhook","fjord", "gypsy",  "haiku", "haphazard", "jinx", "kiosk", "memento", "ostracize", "phlegm",
        "pixel", "rogue", "sphinx", "waxy", "wildebeest", "yacht", "zealous" };

        Random rand = new Random();
        int i = rand.nextInt(25) + 1;
        return hangWords[i];
    }
    
    // Monitors the user's input in the game Hangman
    // Will continue to repeat the game until the user decides they want to quit
    private static void gameTime() {
        String word;
        char menu = inputMenu();
        if(menu == 'y') {
            char choice = inputChoice();
            if (choice == 'n') {
                word = randWords();
            } else {
                word = inputWord();
            }
            int amountOfMisses;
            amountOfMisses = 0;
            int length = word.length();
            String dashes = "";
            for (int i = 0; i < length; i++) {
                dashes = dashes + "_";
            }
            String placeHolder = dashes;

            boolean win = true;
            // Keeps track of the user's guesses on the word
            while (!word.equals(dashes)) {
                dashes = correctGuess(word, dashes, length);
                if (dashes.equals(placeHolder)) {
                    amountOfMisses++;
                    theHangedMan(amountOfMisses);
                    if (amountOfMisses > 5) {
                        win = false;
                        break;
                    }
                } else {
                    placeHolder = dashes;
                }
            }
            // Displays either a winning message or losing message
            if (win) {
                JOptionPane.showMessageDialog(null, "Congratulations    \n your word was:   \n  " + word);
                gameTime();
            } else
                JOptionPane.showMessageDialog(null, "**Hangman** \n************** \n----------- \n  " + word + "\n----------- \n**************");
                gameTime();
        }
        else System.exit(0);
    }

    // Returns a string that will show whether the user entered a correct guess or not
    private static String correctGuess(String word, String dashes, int length) {
        JOptionPane.showMessageDialog(null, "**Hangman** \n************** \n----------- \n  " + dashes + "\n----------- \n**************");
        String j;
        boolean flag = false;
        j = JOptionPane.showInputDialog(null, "Enter a letter").toLowerCase();
        if(!j.isEmpty()) {
            char guess = j.charAt(0);
            if (Character.isLetter(guess)) {
                for (int i = 0; i < length; i++) {
                    if (guess == word.charAt(i)) {
                        dashes = changeCharInPosition(i, guess, dashes);
                        flag = true;
                    }
                }
            }
        }
        else {
            correctGuess(word, dashes, length);
        }
        if (!flag) {
            JOptionPane.showMessageDialog(null, "You missed");
        }
        return dashes;
    }

    // Allows a specific character of a string to be altered while the rest of the string remains unchanged
    private static String changeCharInPosition(int position, char ch, String str) {
        char[] charArray = str.toCharArray();
        charArray[position] = ch;
        return new String(charArray);
    }

    // Displays the "Hanged" man determined by how many letters the user missed
    private static void theHangedMan(int pain) {
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
            JOptionPane.showMessageDialog(null, "    X   \n    -|-    \n   / \\");
    }
}