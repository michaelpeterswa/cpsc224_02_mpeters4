import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuPanel extends JPanel {

    private JPanel main;
    private JPanel status;
    private JButton reset;
    private JButton newGame;
    private JButton exit;

    public menuPanel(){

        main = new JPanel();
        status = new JPanel();

        setLayout(new BorderLayout());

        main.setLayout(new GridLayout(1,3));

        JLabel statusLabel = new JLabel("Current Status");
        reset = new JButton("Reset");
        newGame = new JButton("New Game");
        exit = new JButton("Exit");

        newGame.addActionListener(new ButtonListenerMenu());
        reset.addActionListener(new ButtonListenerMenu());
        exit.addActionListener(new ButtonListenerMenu());

        main.add(reset);
        main.add(newGame);
        main.add(exit);

        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        status.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        status.add(statusLabel);

        add(main, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);

    }
    private class ButtonListenerMenu implements ActionListener
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


}
