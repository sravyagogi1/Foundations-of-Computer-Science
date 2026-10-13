import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

//InflatingCircle extends YOUR Circle class and implements Animatable

//Animatable requires a step() method, which you will write below, and a
//drawMe(Graphics g) method, which you should already have written in Circle

public class InflatingCircle extends Circle implements Animatable
{
   private int dR;    //int to store how much r (radius) will change in next animation step
   private int minR;  //smallest value we want r to be
   private int maxR;  //largest value we want r to be
      
   // constructors
   public InflatingCircle()
   {
      super(10, 250, 250, Color.BLACK);
      dR = 3;
      minR = 10;
      maxR = 200;
   }
   
   /*
      Add a 7-arg constructor that lets us specify an inflating circle of any size, at any 
      x-position, y-position, of any color, with custom values for dR, minR, and maxR.
      */
   public InflatingCircle(int size, int x, int y, Color c, int dRvalue, int minRvalue, int maxRvalue)
   {
      super(size, x, y, c);
      dR = dRvalue;
      minR = minRvalue;
      maxR = maxRvalue;
   
   }
   
   //accessors
   public int getDR()
   {
      return dR;
   }
   public int getMinR()
   {
      return minR;
   }
   public int getMaxR()
   {
      return maxR;
   }
   
   //modifiers
   public void setDR(int dRValue)
   {
      dR = dRValue;
   }
   public void setMinR(int minRValue)
   {
      minR = minRValue;
   }
   public void setMaxR(int maxRValue)
   {
      maxR = maxRValue;
   }
      
   //instance methods
   public void step()  //Implement Animatable's required step()
   {
      //Check to see if our circle is too small
      //If so, make sure dR is positive (radius is increasing)
      if(getRadius() < minR)
      {
         dR *= -1;
      }
      
      //Check to see if our circle is too big
      //If so, make sure dR is negative (radius is decreasing)
      if(getRadius() > maxR)
      {
         dR *= -1;
      }
      setRadius(getRadius() + dR);  //Change the radius a bit - either out or in - for each animation step
   }
}