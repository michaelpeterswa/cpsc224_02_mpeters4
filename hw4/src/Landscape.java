// Author: Jackson Ricks
// ICA6: Mouse and Graphics
// 3/10/17

import sun.security.provider.Sun;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Landscape extends JFrame{
    public int skyX = 0; // Mouse cursor's X position
    public int skyY = 0; // Mouse cursor's Y position
    public int grassX = 0; // Mouse cursor's X position
    public int grassY = 400;
    public int rockX = 100; // Mouse cursor's X position
    public int rockY = 250;
    public int rockSize = 300;
    public int sunX = 400; // Mouse cursor's X position
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
          rock = new Color(102, 0, 102);
          repaint();
      }

      public void mouseReleased(MouseEvent e)
      {
          rock = new Color (153,51,50);
          sky = new Color (40,40,200);
          repaint();
      }

      public void mouseEntered(MouseEvent e)
      {
         grass = new Color(16,230,60);
         repaint();
      }

      public void mouseExited(MouseEvent e)
      {
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
      }

      public void mouseMoved(MouseEvent e)
      {
          rockX = (int) (e.getX() * 1.75 - 300);
          rockY = (int) (e.getY() * 0.25 + 250);

          grassY = (int) (e.getY() * 0.1 + 400);

          rockX = (int) (e.getX() * 1.25 - 250);
          rockY = (int) (e.getY() * 0.25 + 250);

          sunX = e.getX() * 3 - 600;
          sunY = (int) (e.getY() * 0.45 + 50);
          repaint();
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
   // will run when the timer fires
   {
	repaint();
   }

   // draw rectangles and arcs
   public void paintComponent( Graphics g )
   {
     /* super.paintComponent( g ); // call superclass's paintComponent 
	  g.setColor(Color.red);

	// check for boundaries
	if (x < radius)			dx = Math.abs(dx);
	if (x > getWidth() - radius)	dx = -Math.abs(dx);
	if (y < radius)			dy = Math.abs(dy);
	if (y > getHeight() - radius)	dy = -Math.abs(dy);

	// adjust ball position
	x += dx;
	y += dy;
	g.fillOval(x - radius, y - radius, radius*2, radius*2);
   }*/
    g.setColor(sky);
    g.fillRect(skyX, skyY, 600, 600);

    g.setColor(sun);
    g.fillOval(sunX, sunY , sunSize, sunSize);

    g.setColor(rock);
    g.fillArc(rockX, rockY, rockSize, rockSize, 0 , 180);

   g.setColor(grass);
   g.fillRect(grassX,grassY,600,600);

    }
}
    
    
	public static void main(String[] args){
		new Landscape();
	}	
}
