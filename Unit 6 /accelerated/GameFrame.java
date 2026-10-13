import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GameFrame extends JFrame
{
   GamePanel panel;

   GameFrame ()
   {
      panel = new GamePanel();
      this.add(panel);
      this.setTitle("Pong Game");
      this.setResizable(false); //same here
      this.setBackground(new Color(255,245,238));
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.pack(); //probably can delete
      this.setVisible(true); //same here
      this.setLocationRelativeTo(null); //same here
   }
}
