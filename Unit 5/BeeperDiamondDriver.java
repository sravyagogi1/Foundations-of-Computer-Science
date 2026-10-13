import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class BeeperDiamondDriver
{
   public static void main(String[] args)
   {
      Display.setSize(10, 10);
      Display.setSpeed(10);
      
      BeeperDiamond audrey = new BeeperDiamond();
  
      audrey.makeDiamond(85);
   }
}
