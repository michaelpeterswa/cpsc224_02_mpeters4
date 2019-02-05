import java.util.Scanner;
import javax.swing.JOptionPane;

public class Hangman {
    public static void main(String[] args) {
        //inputName();

        String message = "fuck you bih";
        JOptionPane.showMessageDialog(null, message, "Hello!", JOptionPane.WARNING_MESSAGE);
    }

    private static void inputName() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = s.nextLine();
        System.out.println("Hello " + name + "!");

    }
}