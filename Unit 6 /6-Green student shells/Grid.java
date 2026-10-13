import javax.swing.*;
import java.awt.*;

public class Grid extends Square
{
   //fields
   //Since we extend Square, we have all of Square's fields already.  We need to add two more:
   private int divisions; // How many divisions in our grid?
   private Color gridColor;  // What is the color of the grid lines?
  
   public Grid()
   {
      super(120, 10, 100, Color.WHITE);  //Use Square's constructor to set Square's fields
      divisions = 10;                    //...then set the two new ones directly
      gridColor = new Color(127, 127, 255);
   }
   public Grid(int makeSide, int makeTopLeftX, int makeTopLeftY, Color makeC, int makeDivisions, Color makeGridColor)
   {
      super(makeSide, makeTopLeftX, makeTopLeftY, makeC);
      divisions = makeDivisions;
      gridColor = makeGridColor;
   }
  
   //We need new accessors and modifiers for the two new fields:
  
   //accessors
   public int getDivisions()
   {
      return divisions;
   }
   public Color getGridColor()
   {
      return gridColor;
   }
  
   //modifiers
   public void setDivisions(int makeDivisions)
   {
      divisions = makeDivisions;
   }
   public void setGridColor(Color makeGridColor)
   {
      gridColor = makeGridColor;
   }
  
   //instance methods
   public void drawMe(Graphics g)
   {
      //This is an overridden method!  Square has a drawMe method, and we're extending Square,
      //so we have access to that method... but we want this class to have a different drawMe
      //method, so we're going to use the same method name.  That means if we call drawMe now,
      //Java will use this one and not call Square's drawMe method.
     
      //BUT: we still want to be able to use Square's version of drawMe so it can draw the square
      //onto g before this new method adds the new grid lines on top.  This is how we do that:
      super.drawMe(g);  //Use super to call Square's version of drawMe to put the square on g.
     
      //...then add the grid on top.
      g.setColor(gridColor);
      for(int xStep = 0; xStep <= divisions; xStep++)
      {
         int xLoc = getX() + (int)( (double)xStep / divisions * getSide() );
         g.drawLine(xLoc, getY(), xLoc, getY() + getSide());
      }
      for(int yStep = 0; yStep <= divisions; yStep++)
      {
         int yLoc = getY() + (int)( (double)yStep / divisions * getSide() );
         g.drawLine(getX(), yLoc, getX() + getSide(), yLoc);
      }
   }
  
   //other useful Java methods
   public String toString()
   {
      //This gets Square's string and then adds more information - another use of super.
      return super.toString() + " with a grid with " + divisions + " divisions, outlined in " + gridColor;
   }
}
