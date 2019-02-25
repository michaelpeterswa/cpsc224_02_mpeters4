import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   The BagelPanel class allows the user to select either
   a white or whole wheat bagel.
*/

public class player1 extends JPanel
{
   // The following constants are used to indicate
   // the cost of each type of bagel.
   public int wins = 0;
   public int losses = 0;

   private JTextField textField;
   private JLabel win;
   private JLabel loss;
   private JLabel name;
   private JPanel names;
   private JLabel win_num;
   private JLabel loss_num;

   /**
      Constructor
   */

   public player1()
   {
      // Create a GridLayout manager with 
      // two rows and one column.
      // setPreferredSize(100,200);
      //setPreferredSize(new Dimension (250,80));
      setBorder(BorderFactory.createTitledBorder("Player 1 (X): "));
      BoxLayout boxlayout = new BoxLayout(this, BoxLayout.Y_AXIS);
      setLayout(new GridLayout(3,2));
      //setLayout(boxlayout);
      
      // Create the radio buttons.
      textField = new JTextField("Player 1");
      name = new JLabel("Name:    ");

      JPanel names = new JPanel(new BorderLayout());

      
      win_num = new JLabel(""+wins);
      loss_num = new JLabel(""+losses);
      // Group the radio buttons.
      win = new JLabel("Wins:    ");
      loss = new JLabel("Losses: ");

      // Add a border around the panel.

      // Add the radio buttons to the panel.
      //names.add(name, BorderLayout.WEST);
      //names.add(textField, BorderLayout.CENTER);
      add(name);
      add(textField);
      add(win);
      add(win_num);
      add(loss);
      add(loss_num);
      //add(names);
      //add(win);
      //add(loss);
   }

   /**
      getBagelCost method
      @return The cost of the selected bagel.
   */

}