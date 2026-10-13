import javax.swing.*;
import java.awt.*;

public class CalculatorDriver
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("A simple calculator");
      frame.setSize(750, 350);     frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new CalculatorPanel());
      frame.setVisible(true);    
   }
}