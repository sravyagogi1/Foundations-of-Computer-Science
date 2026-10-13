import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

class BouncingSquarePanel extends JPanel
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
   public BouncingSquarePanel()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);    //The next two lines draw the background rectangle for the first time
      myBuffer.fillRect(0,0,FRAME,FRAME);
     
      animationObjects = new ArrayList<Animatable>();  //Instantiate the Animatable ArrayList
              
      
      //Squares
      
      Animatable s1 = new BouncingSquare(42, 100,100, Color.ORANGE, 2, 2);
      animationObjects.add(s1);
     
      Animatable s2 = new BouncingSquare(58, 300,120, Color.BLUE, 2, 2);
      animationObjects.add(s2);
     
      Animatable s3 = new BouncingSquare(70, 230,240, Color.MAGENTA, 2, 2);
      animationObjects.add(s3);
     
      Animatable s4 = new BouncingSquare(63, 340,300, Color.GREEN, 2, 2);
      animationObjects.add(s4);
     
      //Ball
     
      Animatable b1 = new BouncingBall(64, 200,100, Color.WHITE, 2, 2);
      animationObjects.add(b1);
     
      Animatable b2 = new BouncingBall(34, 210,120, Color.WHITE, 2, 2);
      animationObjects.add(b2);
     
      Animatable b3 = new BouncingBall(57, 220,140, Color.WHITE, 2, 2);
      animationObjects.add(b3);
     
      Animatable b4 = new BouncingBall(45, 340,100, Color.WHITE, 2, 2);
      animationObjects.add(b4);

     
     
     
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
         animationObject.step();  //do this objects animation step
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
       of the variable reaches 500 frames of animation, call the Timer objects stop method
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

