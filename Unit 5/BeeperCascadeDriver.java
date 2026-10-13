import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class BeeperCascadeDriver
{
   public static void main(String[] args)
   {
      Display.setSize(10, 10);
      Display.setSpeed(5);
      
      BeeperCascade audrey = new BeeperCascade();
  
      audrey.cascade(5);
   }
}
