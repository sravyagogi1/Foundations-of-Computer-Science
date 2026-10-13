import javax.swing.*;
import java.awt.*;

public class KeyInputDriver
{
    public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Keyboard input!");
      //frame.setSize(500, 525);  //I'm not going to use this now, because Java is weird about frame.setSize()
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new KeyInputPanel());
      frame.getContentPane().setPreferredSize(new Dimension(500,500));  //NEW: This is a BETTER way to set a 500x500 panel.
      frame.pack();                                                     //Use these two lines together.
      frame.setVisible(true);
   }
}