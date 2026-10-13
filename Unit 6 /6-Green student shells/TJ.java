import javax.swing.*;
import java.awt.*;

public class TJ extends Square
{
   public TJ(int s, int x, int y, Color c)
   {
      super(s, x, y, c);
   }
   public void drawMe(Graphics g)
   {
      ImageIcon tommy = new ImageIcon("tj.jpg");
      g.drawImage(tommy.getImage(), getX(), getY(), getSide(), getSide(), null);
   }
}