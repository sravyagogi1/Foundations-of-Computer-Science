import javax.swing.*;
import java.awt.*;

public class Bullseye extends Circle
{
   
   private Color centerColor;
   private Color ringColor;
   
   public Bullseye()
   {
      super(30, 50, 280, Color.RED);
      ringColor = Color.YELLOW;
      centerColor = Color.BLUE;
   }
   
   public Bullseye(int ra, int xa, int ya, Color ca, Color ringC, Color centerC)
   {
      super(ra, xa, ya, ca);
     
      ringColor = ringC;
      centerColor = centerC;
   }
   
   //accessors
   public Color getRingColor()
   {
      return ringColor;
   }
   public Color getCenterColor()
   {
      return centerColor;
   }
   
   //modifiers
   public void setRingColor(Color ringC)
   {
      ringColor = ringC;
   }
   public void setCenterColor(Color centerC)
   {
      centerColor = centerC;
   }
   
   public void drawMe(Graphics g)
   {
      super.drawMe(g);
      int size2 = (int)(getRadius() * .667);
      g.setColor(ringColor);
      g.fillOval(getX()-size2, getY()-size2, size2*2, size2*2);
      
      int size3 = (int)(getRadius() * .333);
      g.setColor(centerColor);
      g.fillOval(getX()-size3, getY()-size3, size3*2, size3*2);
   }
}


