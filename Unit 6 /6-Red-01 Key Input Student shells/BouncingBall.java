import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class BouncingBall extends BouncingSquare
{
   public BouncingBall(int side, int x, int y, Color c, int dXValue, int dYValue)
   {
      super(side, x, y, c, dXValue, dYValue);  
   }
   public void drawMe(Graphics g)
   {
      ImageIcon ball = new ImageIcon("download.jpeg");
      g.drawImage(ball.getImage(), getX(), getY(),
      getSide(), getSide(), null);
   }

}