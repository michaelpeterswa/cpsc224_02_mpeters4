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

        // To select no coffee
   private JPanel panel;
   private JButton[][] choices;
   private JButton help;
   /**
      Constructor
   */

   public gameButtons()
   {
      // Create a GridLayout manager with 
      // four rows and one column.
      //setLayout(new GridLayout(3, 3));
      panel = new JPanel();
      panel.setLayout(new GridLayout(3,3)); 
      tick = 0;
      val = new int[3][3];

      // Create the radio buttons.
      help = new JButton();
      choices = new JButton[3][3];
      for(int i = 0; i <= 2; i++)
      {
          for(int j = 0; j <= 2; j++)
          {
              choices[i][j] = new JButton();
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
    ImageIcon X = new ImageIcon("pics/smile.png");
    ImageIcon O = new ImageIcon("Dice/frown.png");
     public void actionPerformed(ActionEvent e)
     {
         /*
        tick++;
       
        if (tick % 2 == 1) {
            setIcon(X);
            setDisabledIcon(X);
            setEnabled(False);
            //val[i][j] = 1;
        }
        if (tick % 2 == 0) {
            setIcon(O);
            setDisabledIcon(O);
            setEnabled(False);
            //val[i][j] = 0;
        }*/
/*
        // Display Letters
        for (int i = 0; i < 9; i++) {
            if (a.getSource() == b[i]) {
                b[i].setIcon(ltr);
                b[i].setDisabledIcon(ltr);
                b[i].setEnabled(false);
                letters[i] = letter;
            }
        }

        // Who Won

        // Horizontal
        if (letters[0].equals(letters[1]) && letters[1].equals(letters[2]) && !letters[0].equals("")) {
            win = true;
        } else if (letters[3].equals(letters[4]) && letters[4].equals(letters[5]) && !letters[3].equals("")) {
            win = true;
        } else if (letters[6].equals(letters[7]) && letters[7].equals(letters[8]) && !letters[6].equals("")) {
            win = true;
        }

        // Vertical
        if (letters[0].equals(letters[3]) && letters[3].equals(letters[6]) && !letters[0].equals("")) {
            win = true;
        } else if (letters[1].equals(letters[4]) && letters[4].equals(letters[7]) && !letters[1].equals("")) {
            win = true;
        } else if (letters[2].equals(letters[5]) && letters[5].equals(letters[8]) && !letters[2].equals("")) {
            win = true;
        }

        // Diagonal
        if (letters[0].equals(letters[4]) && letters[4].equals(letters[8]) && !letters[0].equals("")) {
            win = true;
        } else if (letters[2].equals(letters[4]) && letters[4].equals(letters[6]) && !letters[2].equals("")) {
            win = true;
        }

        if (win) {
            JOptionPane.showMessageDialog(null, "Player " + letter + " wins!");
            for (JButton i : b) {
                i.setEnabled(false);
            }
        } else if (!win && value == 9) {
            JOptionPane.showMessageDialog(null, "The game ended in a tie.");
        }
    }
*/

     }
   }
}