import javax.swing.*;
import java.awt.*;

public class ColorChangeDriver
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Animation!");
      frame.setSize(500, 525);      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new ColorChangePanel());
      frame.setVisible(true);
   }
}
