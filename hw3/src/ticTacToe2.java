/*
Homework #3
Due Date: 02.22.19
Names: Jackson Ricks
       Michael Peters
 */


import javax.swing.*;    // Needed for Swing classes
import java.awt.*;
import java.awt.event.*;

public class ticTacToe2 extends JFrame
{
    private player1 One;
    private player2 Two;
    private gameButtons game;
    private menuPanel menu;
    private JPanel selectPanel;
    private JTextField textField;
    private JButton[][] select;;    // Correct declaration for 3x3 2d array in java with Jbuttons      // A panel to hold components
    private final int WINDOW_WIDTH = 500; // Window width
    private final int WINDOW_HEIGHT = 500; // Window height
    private JLabel messageLabel;
    private JPanel p;


    /**
     Constructor
     */

    public ticTacToe2()
    {
        // Set the title bar text.
        setTitle("Tic Tac Toe");

        // Set the size of the window.
        setSize(500, 500);
        setLayout(new BorderLayout());
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        selectPanel = new JPanel();
        p.setLayout(new GridLayout(1, 2));


        // Create the three buttons.
        menu = new menuPanel();
        One = new player1();
        Two = new player2();
        game = new gameButtons();

        select = new JButton[3][3];

        //
        //
        // Add the panel to the content pane.
        //add(One);
        //add(Two);

        p.add(One);
        p.add(Two);


        add(p ,BorderLayout.NORTH);
        add(selectPanel,BorderLayout.CENTER);
        add(menu, BorderLayout.SOUTH);

        // Display the window.
        //pack();
        setVisible(true);
    }

    /**
     Private inner class that handles the event when
     the user clicks a button.
     */

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // Get the action command.
            String actionCommand = e.getActionCommand();
        }
    }

    /**
     main method
     */

    public static void main(String[] args)
    {
        new ticTacToe();
    }
}