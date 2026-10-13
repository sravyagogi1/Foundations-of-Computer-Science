import javax.swing.JFrame;
import javax.swing.JPanel;
public class Unit6Green2Driver
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("6-GREEN-02");
      frame.setSize(400, 425);      //In Windows, the menu bar at the top is 25 pixels tall...
      frame.setLocation(100, 50);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new Unit6Green2Panel());    //...so we would expect the content pane to be 400x400.
      frame.setVisible(true);
   }
}