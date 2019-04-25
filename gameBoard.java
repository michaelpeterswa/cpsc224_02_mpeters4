import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File.*;
import javax.imageio.ImageIO;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;



public class gameBoard extends JPanel {

    Deck deck = new Deck();
    //private Player player;
    Card hand = new Card();
    public JLabel jack_display;
    public JLabel queen_display;
    public JLabel king_display;
    public JLabel rBack_display;
    public JLabel gBack_display;
    public JPanel[][] panelHolder;
    private JButton[] choices;
    //private JPanel main;
    //private JPanel status;
    //private JButton reset;
    //private JButton newGame;
    //private JButton exit;
    public Color board = new Color (0,153,0);
    //public JLabel table = new JLabel(new ImageIcon("images/poker-table-layout.jpg"));
    public gameBoard(){

        Deck deck = new Deck();
        //private Player player;
	    Card hand = new Card();
        int i = 3;
        int j = 3;
        JPanel[][] panelHolder = new JPanel[i][j];    
        setLayout(new GridLayout(i,j));

        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) 
            {
                panelHolder[m][n] = new JPanel();
                add(panelHolder[m][n]);
            }
        }
        //setLayout(new GridLayout(3,3));
        //Player player = new Player();
        //JLabel table = new JLabel(new ImageIcon("images/poker-table-layout.jpg"));
        //add(table);
       
        //here
        ImageIcon imageIcon = new ImageIcon("images/JH.png"); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        ImageIcon Jack = new ImageIcon(newimg);  // transform it back
        JLabel jack_display = new JLabel(Jack);

        imageIcon = new ImageIcon("images/QS.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        Jack = new ImageIcon(newimg);  // transform it back
        JLabel queen_display = new JLabel(Jack);

        imageIcon = new ImageIcon("images/KD.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        Jack = new ImageIcon(newimg);  // transform it back
        king_display = new JLabel(Jack);

        imageIcon = new ImageIcon("images/red_back.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        Jack = new ImageIcon(newimg);  // transform it back
        rBack_display = new JLabel(Jack);

        imageIcon = new ImageIcon("images/green_back.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        Jack = new ImageIcon(newimg);  // transform it back
        gBack_display = new JLabel(Jack);

        

        deck.fillDeck();
			
		// shuffle
		deck.shuffle();
			
		// player draws
        hand = deck.deal();
        
        //evaluate(hand);
        if ((hand.face) == 1)
        {
           panelHolder[1][1].add(jack_display);
        }
        else if ((hand.face) == 2)
        {
           panelHolder[1][1].add(queen_display);
        }
        else if ((hand.face) == 3)
        {
           panelHolder[1][1].add(king_display);
        }
        panelHolder[0][1].add(rBack_display);
        panelHolder[1][2].add(gBack_display);

        JPanel buttons = new JPanel();
        choices = new JButton[3];
        choices[0] = new JButton("Check");
        choices[1] = new JButton("Raise");
        choices[2] = new JButton("Fold");
        for (int v = 0; i<= 2; i++)
        {
            choices[v].addActionListener(new ButtonListener());
            panelHolder[2][v].add(choices[v]);  
        }
        //panelHolder[2][2].add(buttons);

       

        //main.add(reset);
        //main.add(newGame);
        //main.add(exit);

        //statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        //status.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        //status.add(statusLabel);
        //pack()
        //add(main, BorderLayout.CENTER);
        //add(status, BorderLayout.SOUTH);
        setVisible(true);

    }
    
     //@Override
    //protected void paintComponent(Graphics g) {

        public class ButtonListener implements ActionListener
        {
          public void actionPerformed(ActionEvent e)
          {
             /*inProgress = true;
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
             */
         }
        }

   /* private class ButtonListenerMenu implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            //
            if (e.getActionCommand() == "Exit") {
                System.exit(0);
            }
            if (e.getActionCommand() == "New Game") {
                new ticTacToe();
            }
            if (e.getActionCommand() == "Reset") {
                if (JOptionPane.showConfirmDialog(null, "This will end the game and set the win/loss stats to 0. Are you sure?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    new ticTacToe();
                else {
                }
            }
        }
    }
    */


}
