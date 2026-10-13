import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Ball extends Rectangle
{
   Random random;
   int xVelocity;
   int yVelocity;
   int initialSpeed = 7;

   Ball (int x, int y, int width, int height)
   {
      super (x, y, width, height);
      random = new Random();
      int randomXDir = random.nextInt(2);
      if (randomXDir ==0)
         randomXDir--;
      setXDir(randomXDir * initialSpeed);
  
      int randomYDir = random.nextInt(2);
      if (randomYDir ==0)
         randomYDir--;
      setYDir(randomYDir * initialSpeed);
   }

   public void setXDir (int randomXDir)
   {
      xVelocity = randomXDir;
   }

   public void setYDir (int randomYDir)
   {
      yVelocity = randomYDir;
   }

   public void move ()
   {
      x += xVelocity;
      y += yVelocity;
   }

   public void draw (Graphics g)
   {
      g.setColor(new Color(255, 155, 115 ));
      g.fillOval(x, y, height, width);
   }
}
