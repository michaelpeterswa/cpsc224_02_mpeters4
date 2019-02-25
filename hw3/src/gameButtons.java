import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   The CoffeePanel class allows the user to select coffee.
*/

public class gameButtons extends JPanel
{
   // The following constants are used to indicate
   // the cost of coffee.
   private int tick;
   private int[][] val;
   public boolean inProgress;

        // To select no coffee
   private JPanel panel;
   private JButton[][] choices;
   private JButton help;
   public int value;
   public String letter;
   /**
      Constructor
   */

   public gameButtons()
   {
      // Create a GridLayout manager with 
      // four rows and one column.
      //setLayout(new GridLayout(3, 3));
       //
       inProgress = false;
      panel = new JPanel();
      panel.setLayout(new GridLayout(3,3)); 
      tick = 0;
      val = new int[3][3];
      value = -1;
      letter = "";

      // Create the radio buttons.
      help = new JButton();
      choices = new JButton[3][3];
      for(int i = 0; i <= 2; i++)
      {
          for(int j = 0; j <= 2; j++)
          {
              choices[i][j] = new JButton(" ");
              choices[i][j].addActionListener(new ButtonListener());
              panel.add(choices[i][j]);
          }
      }
      add(panel);

      // Add the radio buttons to the panel.
   }

   /**
      getCoffeeCost method 
      @return The cost of the selected coffee.
   */

   public class ButtonListener implements ActionListener
   {
     public void actionPerformed(ActionEvent e)
     {
        inProgress = true;
        tick++;
        if (tick % 2 == 1) {
            letter = "X";
            value = 1;
        }
        if (tick % 2 == 0) {
            letter = "O";
            value = 2;
        }

    
      for(int i = 0; i <= 2; i++)
      {
          for(int j = 0; j <= 2; j++)
          {
            if (e.getSource() == choices[i][j]) 
            {
                choices[i][j].setText(letter);
                choices[i][j].setEnabled(false);
                val[i][j] = value;
            }
         }
      }
    
      boolean win = false;
        // Who Won
        if(val[0][0] == val[0][1] && val[0][0] == val[0][2] && val[0][0] != 0)
        {
            win = true;
        }
        else if(val[1][0] == val[1][1] && val[1][0] == val[1][2] && val[1][0] != 0)
        {
            win = true;
        }
        else if(val[2][0] == val[2][1] && val[2][0] == val[2][2] && val[2][0] != 0)
        {
            win = true;
        }

        if(val[0][0] == val[1][0] && val[0][0] == val[2][0] && val[0][0] != 0)
        {
            win = true;
        }
        else if(val[0][1] == val[1][1] && val[0][1] == val[2][1] && val[0][1] != 0)
        {
            win = true;
        }
        else if(val[0][2] == val[1][2] && val[0][2] == val[2][2] && val[0][2] != 0)
        {
            win = true;
        }
    

        if(val[0][0] == val[1][1] && val[0][0] == val[2][2] && val[0][0] != 0)
        {
            win = true;
        }
        else if(val[0][2] == val[1][1] && val[0][2] == val[2][0] && val[0][2] != 0)
        {
            win = true;
        }

        if (win) {
            System.out.println("winner");
            JOptionPane.showMessageDialog(null, "Player " + letter + " wins!");
            inProgress = false;
        } else if (!win && tick == 9) {
            JOptionPane.showMessageDialog(null, "The game ended in a tie.");
            inProgress = false;
        }
    }


     
   }
}