import javax.swing.*;
import java.awt.*;

public class Ball extends Square
{
   public Ball(int s, int x, int y, Color c)
   {
      super(s, x, y, c);
   }
   public void drawMe(Graphics g)
   {
      ImageIcon ball = new ImageIcon("download.jpeg");
      g.drawImage(ball.getImage(), getX(), getY(), getSide(), getSide(), null);
   }
}