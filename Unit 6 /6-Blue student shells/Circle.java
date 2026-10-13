import javax.swing.*;
import java.awt.*;

public class Circle
{
   private int r;
   private int x; //x coordinate of the center
   private int y; //y coordinate of the center
   private Color c;
   
   //constructors
   public Circle()
   {
      r = 10;
      x = 200;
      y = 20;
      c = Color.BLACK;
   }
   public Circle(int rValue, int xValue, int yValue, Color cValue)
   {
      r = rValue;
      x = xValue;
      y = yValue;
      c = cValue;
   }
   
   //accessors
   public int getRadius()
   {
      return r;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public Color getColor()
   {
      return c;
   }
   
   //modifiers
   public void setRadius(int rValue)
   {
      r = rValue;
   }
   public void setX(int xValue)
   {
      x = xValue;
   }
   public void setY(int yValue)
   {
      y = yValue;
   }
   public void setColor(Color cValue)
   {
      c = cValue;
   }
   
   //instance methods
   public void drawMe(Graphics g)
   {
      g.setColor(c);
      g.fillOval(x-r, y-r, 2*r, 2*r);
   }
   
   //other useful Java methods
   
   public String toString()
   {
      return "Circle at center " + x + ", " + x + " with radius " + r + " and color set to " + c;
   }
   
   
}