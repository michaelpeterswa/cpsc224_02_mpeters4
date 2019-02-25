/*
Homework #3
Due Date: 02.22.19
Names: Jackson Ricks
       Michael Peters
 */


import javax.swing.*;    // Needed for Swing classes
import java.awt.*;

public class ticTacToe extends JFrame
{
    public static player1 One;
    public static player2 Two;
    private static gameButtons game;
    private menuPanel menu;
    private final int WINDOW_WIDTH = 500; // Window width
    private final int WINDOW_HEIGHT = 500; // Window height
    private static JPanel p;
    
    
    /**
     Constructor
     */

    public ticTacToe()
    {
        // Set the title bar text.
        setTitle("Tic Tac Toe");

        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));


        // Create the three buttons.
        One = new player1();
        Two = new player2();
        game = new gameButtons();
        menu = new menuPanel();

        p.add(One);
        p.add(Two);

        add(p ,BorderLayout.NORTH);
        add(game,BorderLayout.CENTER);
        add(menu, BorderLayout.SOUTH);

        // Display the window.
        pack();
        setVisible(true);
    }

    /**
     main method
     */

    public static void main(String[] args)
    {
        new ticTacToe();


        //One.textField.setEditable(false);
        //Two.textField.setEditable(false);

        //there was an attempt to make the text box uneditable! :)

    }
}