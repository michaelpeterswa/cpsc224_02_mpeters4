/*
Date: 04.26.19
Names: Jackson Ricks
       Michael Peters
 */


import javax.swing.*;    // Needed for Swing classes
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import java.io.File.*;
import javax.imageio.ImageIO;



import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class poker_head extends JFrame
{
    //public static player1 One;
    //public static player2 Two;
    public static gameBoard gameBoard;
    //private menuPanel menu;
    private final int WINDOW_WIDTH = 800; // Window width
    private final int WINDOW_HEIGHT = 800; // Window height
    private static JPanel p;
    
    
    
    /**
     Constructor
     */

    public poker_head()
    {
        // Set the title bar text.
        setTitle("Poker Town");

        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel p = new JPanel();
        //p.setLayout(new GridLayout(1, 2));
        JLabel background = new JLabel(new ImageIcon(this.getClass().getResource("images/table.png")));
        background.setBounds(0,0,800,800);
        background.setLayout(new BorderLayout());
        add(background);


        // Create the three buttons.
        //One = new player1();
        //Two = new player2();
        gameBoard = new gameBoard();
        //menu = new menuPanel();

        //p.add(One);
        //p.add(Two);

        //add(p ,BorderLayout.NORTH);
        background.add(gameBoard,BorderLayout.CENTER);

        //add(menu, BorderLayout.SOUTH);

        // Display the window.
        //pack();
        setVisible(true);
    }

    /**
     main method
     */

    public static void main(String[] args)
    {
        new poker_head();


        //One.textField.setEditable(false);
        //Two.textField.setEditable(false);

        //there was an attempt to make the text box uneditable! :)

    }
}