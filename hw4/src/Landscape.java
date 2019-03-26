// Author: Jackson Ricks and Michael Peters
// Assignment 4
// 3/25/19

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Landscape extends JFrame{
    public int skyX = 0;
    public int skyY = 0; 
    public int grassX = 0; 
    public int grassY = 400;
    public int rockX = 100; 
    public int rockY = 250;
    public int rockSize = 300;
    public int sunX = 400; 
    public int sunY = 100;
    public int sunSize = 50;
    public Color sky = new Color (40,40,200);
    public Color sun = new Color (255,255,0);
    public Color rock = new Color (153,51,50);
    public Color grass = new Color (12,130,30);

	Landscape()
	{
		setTitle("Motion Parallax");	
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
        ShapePanel sp = new ShapePanel();
        add(sp);
        setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);	
    }
	
	public void paint(Graphics g){
        // Call the superclass's paint method.
        super.paint(g);
    }

   private class MyMouseListener
                       implements MouseListener
   {
      public void mousePressed(MouseEvent e)
      {
         // Get the mouse cursor coordinates.
         sky = new Color(20, 20, 50);
         repaint();
      }

      public void mouseClicked(MouseEvent e)
      {
          // Changes rock to a new purple color
          rock = new Color(102, 0, 102);
          repaint();
      }

      public void mouseReleased(MouseEvent e)
      {
          // Changes rock and sky back to their original colors
          rock = new Color (153,51,50);
          sky = new Color (40,40,200);
          repaint();
      }

      public void mouseEntered(MouseEvent e)
      {
         // Grass is made brighter
         grass = new Color(16,230,60);
         repaint();
      }

      public void mouseExited(MouseEvent e)
      {
        // Grass is made darker whemn mouse is off screen
        grass = new Color(12,130,30);
        repaint();
      }
   }

   /**
      Private inner class to handle mouse motion events.
   */

   private class MyMouseMotionListener implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {
          //implements parallax shifting AND rainbow sky
          sky = new Color (e.getY()%255,e.getX()%255,150);

          rockX = (int) (e.getX() * 1.75 - 300);
          rockY = (int) (e.getY() * 0.25 + 250);

          grassY = (int) (e.getY() * 0.1 + 400);

          rockX = (int) (e.getX() * 1.25 - 250);
          rockY = (int) (e.getY() * 0.25 + 250);

          sunX = e.getX() * 3 - 600;
          sunY = (int) (e.getY() * 0.45 + 50);

          repaint();
      }

      public void mouseMoved(MouseEvent e)
      {
          //implements parallax shifting
          rockX = (int) (e.getX() * 1.75 - 300);
          rockY = (int) (e.getY() * 0.25 + 250);

          grassY = (int) (e.getY() * 0.1 + 400);

          rockX = (int) (e.getX() * 1.25 - 250);
          rockY = (int) (e.getY() * 0.25 + 250);

          sunX = e.getX() * 3 - 600;
          sunY = (int) (e.getY() * 0.45 + 50);
          repaint(); //update scene
      }
   }


   class ShapePanel extends JPanel implements ActionListener
{
   private int delay = 10;
   protected Timer timer;

   private int x = 0;		// x position
   private int y = 0;		// y position
   private int radius = 15;	// ball radius

   private int dx = 2;		// increment amount (x coord)
   private int dy = 2;		// increment amount (y coord)

   public void BallPanel()
   {
      timer = new Timer(delay, this);
	  timer.start();		// start the timer
   }

   public void actionPerformed(ActionEvent e)
   {
	repaint(); //update scene
   }

   // draw rectangles and arcs
   public void paintComponent( Graphics g )
   {
    g.setColor(sky);
    g.fillRect(skyX, skyY, 600, 600);//create sky

    g.setColor(sun);
    g.fillOval(sunX, sunY , sunSize, sunSize); //create sun

    g.setColor(rock);
    g.fillArc(rockX, rockY, rockSize, rockSize, 0 , 180); //create rock

   g.setColor(grass);
   g.fillRect(grassX,grassY,600,600); //create grass

    }
}
    
    
	public static void main(String[] args){
		new Landscape(); //call Landscape Constructor
	}	
}
