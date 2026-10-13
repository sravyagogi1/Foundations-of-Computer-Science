import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

class AnimationPanel extends JPanel
{
   //Start with two static final constants.  "final" is a keyword that
   //means you can't ever change a value.
   public static final int FRAME = 500;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   //fields
   private BufferedImage myImage;  //temporary storage area for the graphics
   private Graphics myBuffer;
   private Timer t;
   private ArrayList<Animatable> animationObjects;
   private int frames;
  
   /*
      Finally, add a new field, an int variable, to count the frames.
   */
    
   //We just need one constructor - initialize all the fields and start the animation!
   public AnimationPanel()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);    //The next two lines draw the background rectangle for the first time
      myBuffer.fillRect(0,0,FRAME,FRAME);
     
      animationObjects = new ArrayList<Animatable>();  //Instantiate the Animatable ArrayList
           
      /*
      Instantiate at least 4 different
      InflatingCircles.  Use lots of different values for color, dR, minR, and maxR. 
      (You can leave the original InflatingCircle if you want, or you can comment it
      out and just make 4 new ones – up to you).  Add all of the new ones to the ArrayList
      of Animatable objects.  Run AnimationDriver and make sure you see all of your circles
      animating.
      */
     
      //Circles
     
      Animatable cr = new InflatingCircle(); //Instantiate an inflating circle...
      animationObjects.add(cr); //...and add it to the ArrayList.  You can do this since InflatingCircle implements Animatable.

      Animatable c1 = new InflatingCircle(40, 100,100, Color.PINK, 1, 3, 120); //Instantiate an inflating circle...
      animationObjects.add(c1);
     
      Animatable c2 = new InflatingCircle(24, 300,120, Color.BLUE, 4, 3, 120); //Instantiate an inflating circle...
      animationObjects.add(c2);
     
      Animatable c3 = new InflatingCircle(6, 230,240, Color.MAGENTA, 6, 3, 200); //Instantiate an inflating circle...
      animationObjects.add(c3);
     
      Animatable c4 = new InflatingCircle(90, 340,300, Color.ORANGE, 2, 3, 120); //Instantiate an inflating circle...
      animationObjects.add(c4);
     
    
    
    
     /*
        Add a new field, an int variable, to AnimationPanel to count the frames. 
        In the constructor, initialize the new field to 0. In animate, increase the value
        of this new variable by 1 each time a new frame is drawn.  Display the value of
        the variable in the top right corner of the animation panel.  You will need to set
        the font, set the color to black, and call drawString.  When the value of the
        variable reaches 500 frames of animation, call the Timer object’s stop method to
        end the animation.
     */
    
    
    
     /*
       Write a new class called ShiftingSquare.  ShiftingSquare should extend the Square
       class and implement Animatable.  It should feature all of the fields, constructors,
       accessors, modifiers, and instance methods necessary so it can be animated (follow
       InflatingCircle as a template).  Give it a default constructor and a 7-arg constructor.
       A ShiftingSquare should store its own dX value, a minX value, and a maxX value.  In
       step it should modify its x value by adding a positive dX.  Adding a positive dX will
       shift the square smoothly to the right until it reaches maxX, when the dX is set to
       negative, making the square shift smoothly to the left until it reaches minX, etc.
      
       Instantiate at least four ShiftingSquares of various sizes, x-positions, y-positions,
       colors, dX values, minX values, and maxX values, taking care that the initial 
       x-position is in between the minX and the maxX.  Add the ShiftingSquares to the
       ArrayList of Animatable objects.   
       */  
      
      //Squares
        
      Animatable s1 = new ShiftingSquare(14, 100,100, Color.WHITE, 1, 1, 400);
      animationObjects.add(s1);
     
      Animatable s2 = new ShiftingSquare(21, 300,120, Color.WHITE, -1, 1, 400);
      animationObjects.add(s2);
     
      Animatable s3 = new ShiftingSquare(17, 230,240, Color.WHITE, 1, 1, 400);
      animationObjects.add(s3);
     
      Animatable s4 = new ShiftingSquare(12, 340,300, Color.WHITE, -1, 1, 400);
      animationObjects.add(s4);
     
      /*     
         In the constructor, initialize the new field to 0.
      */
     
      t = new Timer(5, new AnimationListener());  //A Timer takes two arguments - a time delay (in milliseconds) and an object
                                                  //The object must implement an interface - ActionListener - that demands
                                                  //a single method: actionPerformed().  This class is going to be defined
                                                  //within the AnimationPanel class - look below for "private classes".
                                                  //The Timer waits the given time delay, then calls actionPerformed(), over
                                                  //and over.  It begins when you call .start() and ends when you call .stop().
      t.start();  //Starts the timer
      frames=0;
   }
  
  
   //no accessor or modifier methods; we won't need to access this class's fields from anywhere external to this class
     
   //overridden methods
  
   public void paintComponent(Graphics g)  //Required method to paint to the screen
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
   }
     
   //instance methods
  
   public void animate()
   {
      //This performs the next animation step by drawing to myImage using commands on myBuffer
      //Then, we'll call repaint(), which calls paintComponent(), which draws myImage to the screen
     
      //Clear the current state of myImage by writing over it with a new blank background
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
     
      //Loop through the ArrayList of Animatable objects; do an animation step on each one & draw it
      for(Animatable animationObject : animationObjects)
      {
         animationObject.step();  //do this object’s animation step
         animationObject.drawMe(myBuffer);  //the object draws itself
      }   
      frames++;
      if(frames <= 500)
      {
         myBuffer.setColor(Color.BLACK);
         myBuffer.setFont(new Font("Arial",Font.PLAIN,50));
         myBuffer.drawString(""+frames,25,50);
            if(frames == 500)
            {
               t.stop();
            }
      }     
    /*
       In animate(), increase the value of this new variable by 1 each time a new frame is drawn.
       Display the value of the variable in the top right corner of the animation panel.  You
       will need to set the font, set the color to black, and call drawString.  When the value
       of the variable reaches 500 frames of animation, call the Timer object’s stop method
       to end the animation. 
    */
     
   
   
     
      //Call built-in JFrame method repaint(), which calls paintComponent, which puts the next frame on screen
      repaint();
   }
  
   //private classes
  
   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Timer calls this every 5 ms
      {
         animate();  //...hence animation!
      }
   }
}