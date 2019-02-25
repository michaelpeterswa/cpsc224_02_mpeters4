//Michael Peters
// ica4
// 02.22.2019

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Dice extends JFrame {
    private JPanel dicePanel;
    private JPanel buttonPanel;
    private JLabel label1;
    private JLabel label2;
    private JButton diceButton;

    public static void main(String[] args) {
        new Dice();
    }

    public Dice() {

        setTitle("Dice Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        dicePanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        dicePanel.add(label1);
        dicePanel.add(label2);

        buttonPanel = new JPanel();
        diceButton = new JButton("Roll!");
        diceButton.addActionListener(new ButtonListener());
        buttonPanel.add(diceButton);

        add(dicePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Random randomNum = new Random();
            int num = randomNum.nextInt(6) + 1;
            int num2 = randomNum.nextInt(6) + 1;

            if(num == 1){
                label1.setIcon(new ImageIcon("Die1.png"));
            }
            else if(num == 2){
                label1.setIcon(new ImageIcon("Die2.png"));
            }
            else if(num == 3){
                label1.setIcon(new ImageIcon("Die3.png"));
            }
            else if(num == 4){
                label1.setIcon(new ImageIcon("Die4.png"));
            }
            else if(num == 6){
                label1.setIcon(new ImageIcon("Die5.png"));
            }
            else{
                label1.setIcon(new ImageIcon("Die6.png"));
            }

            if(num2 == 1){
                label2.setIcon(new ImageIcon("Die1.png"));
            }
            else if(num2 == 2){
                label2.setIcon(new ImageIcon("Die2.png"));
            }
            else if(num2 == 3){
                label2.setIcon(new ImageIcon("Die3.png"));
            }
            else if(num2 == 4){
                label2.setIcon(new ImageIcon("Die4.png"));
            }
            else if(num2 == 5){
                label2.setIcon(new ImageIcon("Die5.png"));
            }
            else{
                label2.setIcon(new ImageIcon("Die6.png"));
            }


            pack();
        }
    }
}