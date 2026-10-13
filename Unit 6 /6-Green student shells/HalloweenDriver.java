//I will uphold academic and personal integrity in the TJ community.
//-Sravya Gogineni

import javax.swing.JFrame;
import javax.swing.JPanel;
public class HalloweenDriver
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Build a House");
      frame.setSize(400, 425);      //In Windows, the menu bar at the top is 25 pixels tall...
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new HousePanel());    //...so we would expect the content pane to be 400x400.
      frame.setVisible(true);
   }
}