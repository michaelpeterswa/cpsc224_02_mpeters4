// Author: Jackson Ricks
// ICA6: Mouse and Graphics
// 3/10/17

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
      // Draw a rectangle.
        //g.setColor(sky);
        //g.fillRect(skyX, skyY, 600, 600);
        
        //g.setColor(grass);
        //g.fillRect(grassX,grassY,600,600);

        //g.setColor(sun);
        //g.fillOval(sunX, sunY , sunSize, sunSize);

        //g.setColor(rock);
       // g.fillArc(rockX, rockY, rockSize, rockSize, 0 , 180);

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

   private class MyMouseMotionListener
                         implements MouseMotionListener
   {
      public void mouseDragged(MouseEvent e)
      {   
      }

      public void mouseMoved(MouseEvent e)
      {
        if (e.getX() > 300 && rockX > 0)
        {
            rockX = rockX -1;
            sunX = sunX - 1;
        }  
        if (e.getX() < 300 && rockX < 600)
        {
            rockX = rockX +1;
            sunX = sunX + 1;
        } 
        if (e.getY() > 450 && grassY > 200)
        {
            rockY = rockY -1;
            sunY = sunY -1;
            grassY = grassY -1;
        } 
        if (e.getY() < 150 && grassY < 500)
        {
            rockY = rockY +1;
            sunY = sunY +1;
            grassY = grassY +1;
        } 
       /* if (e.getY() < 250 && grassY > 300)
        {
            sunY = sunY - 1;
            grassY = grassY -1;
        } 
        if (e.getX() < 300 && rockX < 600)
        {
            rockX = rockX +1;
            sunX = sunX +1;
        }  
        if (e.getY() > 250 && grassY < 600)
        {
            sunY = sunY + 1;
            grassY = grassY +1;
        } */
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

   public BallPanel()
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
   
   g.setColor(grass);
   g.fillRect(grassX,grassY,600,600);

   g.setColor(sun);
   g.fillOval(sunX, sunY , sunSize, sunSize);

     g.setColor(rock);
     g.fillArc(rockX, rockY, rockSize, rockSize, 0 , 180);

    }
}
    
    
	public static void main(String[] args){
		new Landscape();
	}	
}
