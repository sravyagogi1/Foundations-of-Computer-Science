import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Cultivator extends Athlete implements Farmer
{
   public Cultivator()
   {
      super(2, 2, Display.EAST, Display.INFINITY);
   }
   
   public void workOnePlant()
   {
      if(nextToABeeper())
      {
         pickBeeper();
      }
      else if(!nextToABeeper())
      {
         putBeeper();
      }
   }
}