import javax.swing.*;
import java.awt.event.*; // Needed for event listener interface



/**
 The KiloConverter class displays a JFrame that
 lets the user enter a distance in kilometers. When
 the Calculate button is clicked, a dialog box is
 displayed with the distance converted to miles.
 */

public class LatinTranslator extends JFrame
{
    private JPanel panel;             // To reference a panel
    private JLabel word;      // To reference a label

    private JButton button1;       // To reference a button
    private JButton button2;       // To reference a button
    private JButton button3;       // To reference a button
    private final int WINDOW_WIDTH = 310;  // Window width
    private final int WINDOW_HEIGHT = 100; // Window height

    /**
     Constructor
     */

    public LatinTranslator()
    {
        // Set the window title.
        setTitle("Latin Translator");

        // Set the size of the window.
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build the panel and add it to the frame.
        buildPanel();

        // Add the panel to the frame's content pane.
        add(panel);

        // Display the window.
        setVisible(true);
    }

    /**
     The buildPanel method adds a label, text field, and
     and a button to a panel.
     */

    private void buildPanel()
    {
        // Create a label to display instructions.
        word = new JLabel("English Word");

        // Create a button with the caption "Calculate".
        button1 = new JButton("Dexter");
        button2 = new JButton("Medium");
        button3 = new JButton("Sinister");

        // Create a JPanel object and let the panel
        // field reference it.
        panel = new JPanel();

        button1.addActionListener(new ButtonListenerRight());
        button2.addActionListener(new ButtonListenerCenter());
        button3.addActionListener(new ButtonListenerLeft());

        // Add the label, text field, and button
        // components to the panel.

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(word);
    }

    private class ButtonListenerRight implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            word.setText("Right");
        }
    }
    private class ButtonListenerCenter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           word.setText("Center");
        }
    }
    private class ButtonListenerLeft implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            word.setText("Left");
        }
    }
    public static void main(String[] args)
    {
        new LatinTranslator();
    }
}