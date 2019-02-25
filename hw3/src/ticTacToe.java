/*
Homework #3
Due Date: 02.22.19
Names: Jackson Ricks
       Michael Peters
 */


import javax.swing.*;    // Needed for Swing classes
import java.awt.*;
import java.awt.event.*;

public class ticTacToe extends JFrame
{
    private player1 One;
    private player2 Two;
    private gameButtons game;

    private JTextField textField;
    private JButton select;    // Correct declaration for 3x3 2d array in java with Jbuttons      // A panel to hold components
    private final int WINDOW_WIDTH = 500; // Window width
    private final int WINDOW_HEIGHT = 500; // Window height
    private JLabel messageLabel;
    private JPanel p;
    
    
    /**
     Constructor
     */

    public ticTacToe()
    {
        // Set the title bar text.
        setTitle("Tic Tac Toe");

        // Set the size of the window.
        setSize(500, 500);

        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel(new BorderLayout());


        // Create the three buttons.
        One = new player1();
        Two = new player2();
        game = new gameButtons();

        messageLabel = new JLabel("Click a button because why not amirite?? ");

        // Register an event listener with all 3 buttons.

        // Create a panel and add the buttons to it.

        // Add the panel to the content pane.
        //add(One);
        //add(Two);

        p.add(One,BorderLayout.WEST);
        p.add(Two,BorderLayout.EAST);
        add(game,BorderLayout.CENTER);

        add(p,BorderLayout.NORTH);

        // Display the window.
        pack();
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

    /*public static class SelectPanel extends JPanel;
    {

        // I think we need to separate the button select panel from player 1 and player 2

        JButton select = new JButton[3][3];
        // Create a GridLayout manager with
        // four rows and one column.
        setLayout(new GridLayout(3, 3));

        // Create the check boxes.
        select[0][0] = new JButton("[]");
        select[0][1] = new JButton("[]");
        select[0][2] = new JButton("[]");
        select[1][0] = new JButton("[]");
        select[1][1] = new JButton("[]");
        select[1][2] = new JButton("[]");
        select[2][0] = new JButton("[]");
        select[2][1] = new JButton("[]");
        select[2][2] = new JButton("[]");

        select[0][0].addActionListener(new ButtonListener());
        select[0][1].addActionListener(new ButtonListener());
        select[0][2].addActionListener(new ButtonListener());
        select[1][0].addActionListener(new ButtonListener());
        select[1][1].addActionListener(new ButtonListener());
        select[1][2].addActionListener(new ButtonListener());
        select[2][0].addActionListener(new ButtonListener());
        select[2][1].addActionListener(new ButtonListener());
        select[2][2].addActionListener(new ButtonListener());

        player1.add(select[0][0]);
        player1.add(select[0][1]);
        player1.add(select[0][2]);
        player1.add(select[1][0]);
        player1.add(select[1][1]);
        player1.add(select[1][2]);
        player1.add(select[2][0]);
        player1.add(select[2][1]);
        player1.add(select[2][2]);
    }*/

    /**
     main method
     */

    public static void main(String[] args)
    {
        new ticTacToe();
    }
}