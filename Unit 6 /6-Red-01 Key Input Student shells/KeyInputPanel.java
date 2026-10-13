//WRITE THIS SO THAT THE LEFT ARROW KEY WORKS ONLY

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class KeyInputPanel extends JPanel
{
   //fields
  
   //Most of this is the same as AnimationPanel
   public static final int FRAME = 500;
   private static final Color BACKGROUND = new Color(204, 204, 204);
  
   private BufferedImage myImage; 
   private Graphics myBuffer;
  
   private Timer t;

   private ArrayList<Animatable> animationObjects;
  
   //But we do need a new one: this will be true when the user is holding down the left arrow key.
   //Explaining why we need this is complicated; see the assignment for details.
   private boolean left;
   private boolean right;
   private boolean up;
   private boolean down;
  
   //And we need to declare our square we can control with arrow keys as a field, separately from
   //the arraylist, so we can give it specific commands outside the constructor.
   private ArrowkeySquare sq;
  
  
     
   //constructors
   public KeyInputPanel()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);   
      myBuffer.fillRect(0,0,FRAME,FRAME);
     
      animationObjects = new ArrayList<Animatable>(); 
     
      //Make our ArrowkeySquare
      sq = new ArrowkeySquare(); //DO NOT RE-DECLARE sq - it's a field, it's already declared.  Just assign.
      animationObjects.add(sq); //We want sq to be animated, and also want to give sq other commands, so we
                                //add sq to the arraylist and also refer to it as sq separaetly.
     
      t = new Timer(5, new AnimationListener());
      t.start();  //Animation starts, but square -won't move yet...
     
      //Here's how to enable keyboard input:
      addKeyListener(new Key());  //Key is a private class defined below
      setFocusable(true);  //Don't forget this!
     
      left = false; //at the moment, the user is not pushing down the left arrow key, so "false"
      right = false;
      up = false;
      down = false;
   }
  
  
   //overridden methods
  
   public void paintComponent(Graphics g) 
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null); 
   }
  
  
  
   //instance methods
  
   public void animate()
   {     
      //Clear the current state of myImage by writing over it with a new blank background
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
     
      //Loop through the ArrayList of Animatable objects; do an animation step on each one & draw it
      for(Animatable animationObject : animationObjects)
      {
         animationObject.step(); 
         animationObject.drawMe(myBuffer); 
      }
     
      //Call built-in JFrame method repaint(), which calls paintComponent, which puts the next frame on screen
      repaint();
   }
  
  
  
   //private classes
  
   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
      {
         animate();
      }
   }
  
   private class Key extends KeyAdapter //Make ONE class that EXTENDS KeyAdapter, and tell it what to do when keys are pressed or released
   {
      public void keyPressed(KeyEvent e) //Make ONE method for key presses; this is overridden, and will be called whenever a key is pressed
      {
         if(e.getKeyCode() == KeyEvent.VK_LEFT && !left) //e.getKeyCode() lets us retrieve which key was just pushed.  !left lets us know the user isn't already holding the left arrow down.
         {
            sq.setDX(sq.getDX() - 2);  //Subtract 2 from Square's dX value, effectively setting the value to 0.
            left = true;  //Now, the user is holding down the left key, so set this to true.  Why do we need to keep track of this?  So that holding down one (or even two) key works as expected.
         }
         // write code for the other keys here
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT && !right) //e.getKeyCode() lets us retrieve which key was just pushed.  !left lets us know the user isn't already holding the left arrow down.
         {
            sq.setDX(sq.getDX() + 2);  //Subtract 2 from Square's dX value, effectively setting the value to 0.
            right = true;  //Now, the user is holding down the left key, so set this to true.  Why do we need to keep track of this?  So that holding down one (or even two) key works as expected.
         }
         else if (e.getKeyCode() == KeyEvent.VK_UP && !up)
         {
            sq.setDY(sq.getDY() - 2); // Adjust according to your method to change vertical movement
            up = true;
         }
         else if (e.getKeyCode() == KeyEvent.VK_DOWN && !down)
         {
            sq.setDY(sq.getDY() + 2); // Adjust according to your method to change vertical movement
            down = true;
         }
         if (e.getKeyCode() == KeyEvent.VK_SPACE)
         {
            sq.changeColor();
         }
         else if (e.getKeyCode() == KeyEvent.VK_OPEN_BRACKET)
         {
            sq.resize(-1); // Make the square 1 pixel smaller
         }
         else if (e.getKeyCode() == KeyEvent.VK_CLOSE_BRACKET)
         {
            sq.resize(1); // Make the square 1 pixel larger
         }
         else if (e.getKeyCode() == KeyEvent.VK_T)
         {
            sq.teleport(FRAME); // Assuming FRAME is accessible here, representing the frame size
         }

        
        
      }
     
      public void keyReleased(KeyEvent e) //Also overridden; ONE method that will be called any time a key is released
      {
         if(e.getKeyCode() == KeyEvent.VK_LEFT) // If the user lets go of the left arrow
         {
            sq.setDX(sq.getDX() + 2);  //Again: add 2, don't set to 0 precisely. 
            left = false;  //User is no longer holding the left key, so set this back to false.
         }
         //write code for the other keys here
         else if(e.getKeyCode() == KeyEvent.VK_RIGHT) // If the user lets go of the left arrow
         {
            sq.setDX(sq.getDX() - 2);  //Again: add 2, don't set to 0 precisely. 
            right = false;  //User is no longer holding the left key, so set this back to false.
         }
         else if (e.getKeyCode() == KeyEvent.VK_UP)
         {
            sq.setDY(sq.getDY() + 2); // Reverse the vertical movement adjustment
            up = false;
         }
         else if (e.getKeyCode() == KeyEvent.VK_DOWN)
         {
            sq.setDY(sq.getDY() - 2); // Reverse the vertical movement adjustment
            down = false;
         }       
        
      }
   }
}