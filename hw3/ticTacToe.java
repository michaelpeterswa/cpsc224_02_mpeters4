/*
Homework #3
Due Date: 02.22.19
Names: Jackson Ricks
       Michael Peters      
 */

import javax.swing.JOptionPane;
import java.util.Random;

import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*; 

public class ticTacToe extends JFrame
{
   private JButton sinister;    // Button 1
   private JTextField textField;
   private JButton dexter;    // Button 2
   private JButton medium;    // Button 3
   private JPanel player1; 
   private JPanel player2;       // A panel to hold components
   private final int WINDOW_WIDTH = 500; // Window width
   private final int WINDOW_HEIGHT = 500; // Window height
   private JLabel messageLabel;

   /**
      Constructor
   */

   public ticTacToe()
   {
      // Set the title bar text.
      setTitle("Tic Tac Toe");

      // Set the size of the window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create the three buttons.
      sinister = new JButton("Sinister");
      dexter = new JButton("Dexter");
      medium = new JButton("Medium");

      messageLabel = new JLabel("Click a button to see the translation ");

      // Register an event listener with all 3 buttons.
      sinister.addActionListener(new ButtonListener());
      medium.addActionListener(new ButtonListener());
      dexter.addActionListener(new ButtonListener());

      // Create a panel and add the buttons to it.
      player1 = new JPanel();
      textField = new JTextField("Player 1", 5);
      player1.setBorder(BorderFactory.createTitledBorder("Player 1 (X) "));
      player1.setLayout(new BoxLayout(player1, BoxLayout.PAGE_AXIS));
      player1.add(textField);
      player1.add(sinister);
      player1.add(medium);
      player1.add(dexter);
      player1.add(messageLabel);

      // Add the panel to the content pane.
      add(player1);

      // Display the window.
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


         // Determine which button was clicked and display
         // a message.
         if (actionCommand.equals("Sinister"))
         {
            messageLabel.setText("Left");
         }
         else if (actionCommand.equals("Dexter"))
         {
            messageLabel.setText("Right");
         }
         else if (actionCommand.equals("Medium"))
         {
            messageLabel.setText("Center");
         }
         
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
