import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File.*;
import javax.imageio.ImageIO;
import java.util.Random;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.concurrent.TimeUnit;
import java.util.TimerTask;
import java.lang.Thread;


public class gameBoard extends JPanel {

    public Deck deck = new Deck();
    //private Player player;
    public Card hand = new Card();
    public Card com_Hand = new Card();
    public JLabel jack_display;
    public JLabel queen_display;
    public JLabel king_display;
    public JLabel display;
    public JLabel rBack_display;
    public JLabel gBack_display;
    public JPanel[][] panelHolder;
    public JButton[] choices;
    public JButton check;
    public JButton call;
    public JButton raise;
    public JButton com;
    public JLabel pot_display;
    public JLabel player = new JLabel("Player: 19");
    public JLabel computer = new JLabel("Computer: 19");
    public String text = "pot: 2";
    public int turn = 0;
    public int money = 20;
    public int com_money = 20;
    public int hum_card;
    public int com_card;
    public int pot = 0;
    public int time = 0;
    public int delay = 1000;
    public Timer timer;
    public ImageIcon Jack;
    public ImageIcon Queen;
    public ImageIcon King;
    public ImageIcon rback;
    //private JPanel main;
    //private JPanel status;
    //private JButton reset;
    //private JButton newGame;
    //private JButton exit;
    public Color board = new Color (0,153,0);
    //public JLabel table = new JLabel(new ImageIcon("images/poker-table-layout.jpg"));
    public gameBoard(){

        //Deck deck = new Deck();
        //private Player player;
	    //Card hand = new Card();
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
        Jack = new ImageIcon(newimg);  // transform it back
        display = new JLabel(Jack);

        imageIcon = new ImageIcon("images/QS.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        Queen = new ImageIcon(newimg);  // transform it back
        display = new JLabel(Queen);

        imageIcon = new ImageIcon("images/KD.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        King = new ImageIcon(newimg);  // transform it back
        display = new JLabel(King);

        imageIcon = new ImageIcon("images/red_back.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        rback = new ImageIcon(newimg);  // transform it back
        rBack_display = new JLabel(rback);

        imageIcon = new ImageIcon("images/green_back.png"); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        newimg = image.getScaledInstance(60, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        ImageIcon gck = new ImageIcon(newimg);  // transform it back
        gBack_display = new JLabel(gck);

        

        deck.fillDeck();
			
		// shuffle
		deck.shuffle();
			
		// player draws
        hand = deck.empty_deal();
        com_Hand = deck.cp_deal();
        System.out.println(com_Hand.face);
        if ((hand.face) == 1)
        {
           //panelHolder[1][1].add(jack_display);
           display.setIcon(Jack);
        }
        else if ((hand.face) == 2)
        {
           //panelHolder[1][1].add(queen_display);
           display.setIcon(Queen);
        }
        else if ((hand.face) == 3)
        {
           //panelHolder[1][1].add(king_display);
           display.setIcon(King);
        }
       // panelHolder[0][1].
       add(display);
        add(rBack_display);
        //panelHolder[1][2].
        add(gBack_display);

        JPanel buttons = new JPanel();
        choices = new JButton[3];
        //choices[0] = 
        check = new JButton("Check");
        
        //choices[1] = 
        raise = new JButton("Raise");
        //choices[2] = 
        call = new JButton("Call");
        com = new JButton("Computer");
        check.setBackground(Color.red);
        check.addActionListener(new ButtonListener());
        raise.addActionListener(new ButtonListener());
        call.addActionListener(new ButtonListener());
        com.addActionListener(new ComListener());
        add(check);
        add(raise);
        add(call);
        add(com);
        for (int v = 0; i<= 2; i++)
        {
            choices[v].setBackground(Color.red); 
            buttons.add(choices[v]);  
        }
        //panelHolder[2][2].add(buttons);
        pot_display = new JLabel();
        pot_display.setText(text);
        //add(buttons);
        add(pot_display);
        add(player);
        add(computer);
       //play_game();

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
              
             /* public void updateScore()
              {
                //timer = new Timer(delay, this);
                //timer.start();
                //timer = new Timer(100000, this);
                //timer.start();
                String new_money;
                text = String.format("Pot: %02d", pot);
                pot_display.setText(text);
                new_money = String.format("Computer: %02d", com_money);
                computer.setText(new_money); 
                new_money = String.format("Human: %02d", money);
                player.setText(new_money);
                //timer = new Timer();
                //timer.setInitialDelay(5000);
               // try {TimeUnit.SECONDS.sleep(1);}
                //catch (InterruptedException k) {System.err.format("IOException: %s%n", k);}
                //timer.stop();
              }*/
         public void actionPerformed(ActionEvent e)
         {
            Random rand = new Random();
            int n = rand.nextInt(50);
            hum_card = hand.face;
            //com_card = com_Hand.face;
            rBack_display.setIcon(rback);
            //while (money > 0 && com_money > 0)
            //{
                
            if (turn == 0)
            {
                  pot+=2;
                  money--;
                  com_money--;
                  updateScore();
                  //try {TimeUnit.SECONDS.sleep(1);}
                  //catch (InterruptedException k) {System.err.format("IOException: %s%n", k);}
                  if (e.getSource() == raise)
                  {
                        //pot_display= new JLabel();
                    pot++;
                    money--; 
                  }
                  updateScore();
                  turn = 1;
            }
            else if (turn == 1)
            {
                    if (pot == 3)
                    {
                        
                          if ((e.getSource() == call) || (e.getSource() == raise))
                          {
                            pot++;
                            money--;
                            updateScore();
                            //Add delay
                            winConditions();
                            updateScore();
                          }
                    turn = 0;
                    }
                    else //pot == 2
                    {
                        
                          if ((e.getSource() == check) || (e.getSource() == call))
                          {
                            //Add delay
                            winConditions();
                            updateScore();
                            turn = 0;
                          }
                          else // raise pot by 1
                          {
                            pot++;
                            money--;
                            updateScore();
                          }
                    }
            }
                

            //}
            
            
            
          //actionperformed bracket  
          }
            
            
            
        
        //class bracket 
        }
        public class ComListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
          {
            Random rand = new Random();
            int n = rand.nextInt(50);
            hum_card = hand.face;
            com_card = com_Hand.face;
            rBack_display.setIcon(rback);

            //while (money > 0 && com_money > 0)
            //{
                
            int com_card2 = com_card;
            if (turn == 0)
            {
                if (time == 1)
                {
                  pot+=2;
                  money--;
                  com_money--;
                  updateScore();
                    if(com_card2 == 0)
                    {
                      if(n >= 40)
                      {
                        pot++;
                        com_money--;
                      }
                    }
                    else if(com_card2 == 1)
                    {
                        if (n >= 25)
                        {
                          pot++;
                          com_money--;
                        }
                    }
                    else 
                    {
                        if (n > 10)
                        {
                          pot++;
                          com_money--;
                        }
                       updateScore();
                       time = 0;
                    }
                
                turn = 1;
                }
            }
            else if (turn == 1)
            {
                    if (pot == 3)
                    {
                            if(com_card2 == 0)
                            {
                                money += pot;
                                pot = 0;
                                updateScore();
                            }
                            else 
                            {
                                if (n >= 25 || ((com_card2 == 2) && (n > 10))) 
                                {
                                  pot++;
                                  com_money--;
                                  updateScore();
                                  winConditions();
                                }
                                else 
                                {
                                    money += pot;
                                    pot = 0;
                                    updateScore();   
                                }
                            time = 0; 
                            }
                        
                    turn = 0;
                    }
                    else //pot == 2
                    {
                            if(com_card2 == 0)
                            {
                                if (n <= 40)
                                {
                                  winConditions();
                                  updateScore();
                                }
                                else
                                {
                                  pot++;
                                  com_money--;
                                  updateScore();
                                }
                            }
                            else if(com_card2 == 1) 
                            {
                                if (n >= 25) //|| ((com_card == 2) && (n > 10))) 
                                {
                                  winConditions();
                                }
                                else 
                                {
                                    pot++;
                                    com_money--;
                                    updateScore();  
                                }
                            }
                            else  
                            {
                                if (n >= 10)
                                {
                                   winConditions();
                                }
                                else 
                                {
                                    pot++;
                                    com_money--;
                                    updateScore();  
                                }
                            }
                            time = 0; 
                    }
            }
                

            //}
            
            
            
          //actionperformed bracket  
          }
        }
        public void updateScore()
        {
                //timer = new Timer(delay, this);
                //timer.start();
                //timer = new Timer(100000, new ActionListener());
                //timer.start();
                String new_money;
                text = String.format("Pot: %02d", pot);
                pot_display.setText(text);
                new_money = String.format("Computer: %02d", com_money);
                computer.setText(new_money); 
                new_money = String.format("Human: %02d", money);
                player.setText(new_money);
                //timer = new Timer();
                //timer.setInitialDelay(5000);
                //timer.stop();
        }

        public void winConditions()
        {
                //timer = new Timer(delay, this);
                //timer.start();
                //timer.start();
                hum_card = hand.face;
                System.out.println(hum_card);
                com_card = com_Hand.face;
                System.out.println(com_card);
                if (hum_card > com_card)
                {
                    money += pot;
                    pot = 0;
                    turn = 0;
                }
                else
                {
                    com_money += pot;
                    pot = 0;
                    turn = 1;
                }
                updateScore();
                if (com_Hand.face == 1)
                {
           //panelHolder[1][1].add(jack_display);
                    rBack_display.setIcon(Jack);
                 }
                else if (com_Hand.face == 2)
                {
           //panelHolder[1][1].add(queen_display);
                    rBack_display.setIcon(Queen);
                 }
                else if (com_Hand.face == 3)
                {
           //panelHolder[1][1].add(king_display);
                    rBack_display.setIcon(King);
                }
                add(rBack_display);
                pot+=2;
                money--;
                com_money--;
                updateScore();
                redeal();
                //timer.stop();
        }

        public void redeal()
        {
            deck = new Deck();
            deck.fillDeck();
            deck.shuffle();
            hand = new Card();
            com_Hand = new Card();
		    // player draws
            hand = deck.empty_deal();
            com_Hand = deck.cp_deal();
            if (hand.face == 1)
            {
           //panelHolder[1][1].add(jack_display);
            display.setIcon(Jack);
            }
            else if (hand.face == 2)
            {
           //panelHolder[1][1].add(queen_display);
              display.setIcon(Queen);
             }
             else if (hand.face == 3)
            {
           //panelHolder[1][1].add(king_display);
             display.setIcon(King);
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
