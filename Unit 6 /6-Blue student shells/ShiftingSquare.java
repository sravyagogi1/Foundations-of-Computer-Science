import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class ShiftingSquare extends Square implements Animatable
{
   private int dX;    //int to store how much r (radius) will change in next animation step
   private int minX;  //smallest value we want r to be
   private int maxX;  //largest value we want r to be
     
   // constructors
   public ShiftingSquare()
   {
      super(10, 250, 250, Color.BLACK);
      dX = 3;
      minX = 10;
      maxX = 200;
   }
  
   /*
      Add a 7-arg constructor that lets us specify an inflating circle of any size, at any
      x-position, y-position, of any color, with custom values for dR, minR, and maxR.
      */
      public ShiftingSquare(int size, int x, int y, Color c, int dXValue, int minXValue, int maxXValue)
   {
      super(size, x, y, c);
      dX = dXValue;
      minX = minXValue;
      maxX = maxXValue;
   }

  
  
  
   //accessors
   public int getDX()
   {
      return dX;
   }
   public int getMinX()
   {
      return minX;
   }
   public int getMaxX()
   {
      return maxX;
   }
  
   //modifiers
   public void setDX(int dXValue)
   {
      dX = dXValue;
   }
   public void setMinR(int minXValue)
   {
      minX = minXValue;
   }
   public void setMaxX(int maxXValue)
   {
      maxX = maxXValue;
   }
     
   //instance methods
   public void step()  //Implement Animatable's required step()
   {
      //Check to see if our circle is too small
      //If so, make sure dR is positive (radius is increasing)
      if(getX() < minX)
      {
         dX *= -1;
      }
     
      //Check to see if our circle is too big
      //If so, make sure dR is negative (radius is decreasing)
      if(getX() > maxX)
      {
         dX *= -1;
      }
      setX(getX() + dX);  //Change the radius a bit - either out or in - for each animation step
   }
}

