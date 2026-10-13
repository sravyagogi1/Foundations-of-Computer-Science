import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class BouncingSquare extends Square implements Animatable
{
   private int dX;   
   private int dY; 
     
   // constructors
   public BouncingSquare()
   {
      super(10, 250, 250, Color.BLACK);
      dX = 3;
      dY = 3;
   }
   public BouncingSquare(int side, int x, int y, Color c, int dXValue, int dYValue)
   {
      super(side, x, y, c);
      dX = dXValue;
      dY = dYValue;
     
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
   public void step()
   {
      if(getX() < 0)
      {
         dX *= -1;
      }
       
      if(getX() > 500-getSide())
      {
         dX *= -1;
      }
      if(getY() < 0)
      {
         dY *= -1;
      }
     
      if(getY() > 500-getSide())
      {
         dY *= -1;
      }
     
      setX(getX() + dX);
      setY(getY() + dY);
  }
}

