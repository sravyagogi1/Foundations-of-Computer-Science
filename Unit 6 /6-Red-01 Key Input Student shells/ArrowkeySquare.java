import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

//InflatingCircle extends YOUR Circle class and implements Animatable

//Animatable requires a step() method, which is in this file, and a
//drawMe(Graphics g) method, which you should already have in Circle

public class ArrowkeySquare extends Square implements Animatable
{
   private int dX;
   private int dY;
     
   // constructors
   public ArrowkeySquare()
   {
      super(10, 250, 250, Color.WHITE);
      dX = 0;
      dY= 0;
   }
  
   public ArrowkeySquare(int sideValue, int xValue, int yValue, Color cValue)
   {
      super(sideValue, xValue, yValue, cValue);
      dX = 0;
      dY = 0;
   }
  
   //accessors
   public int getDX()
   {
      return dX;
   }
   public int getDY()
   {
      return dY;
   }
  
   //modifiers
   public void setDX(int dXValue)
   {
      dX = dXValue;
   }
   public void setDY(int dYValue)
   {
      dY = dYValue;
   }
  
     
   //instance methods
   public void step()  //Implement Animatable's required step()
   {
      setX(getX() + dX);
      setY(getY() + dY); 
   }
   public void changeColor()
   {
      int r = (int)(Math.random() * 255);
      int g = (int)(Math.random() * 255);
      int b = (int)(Math.random() * 255);
      setColor(new Color(r, g, b));
   }
   public void resize(int change)
   {
      int newSize = getSide() + change;    
      if (newSize > 0)
      {
         setSide(newSize); // Assuming there's a setSide method to adjust the square's size
      }
   }
   public void teleport(int frameSize)
   {
      int newX = (int)(Math.random() * (frameSize - getSide()));
      int newY = (int)(Math.random() * (frameSize - getSide()));
      setX(newX);
      setY(newY);
   }


}


