import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

// How does Harvester implement Farmer?
// It extends Athlete, which provides implementations of move(), turnRight(), and turnLeft()
// and it defines the final necessary method - workOneIntersection().
// In this case, we want a Harvester to pick up any beeper that is present.

public class Harvester extends Athlete implements Farmer
{
   public Harvester()
   {
      super(2, 2, Display.EAST, Display.INFINITY);
   }
   
   public void workOnePlant()
   {
      if(nextToABeeper())
      {
         pickBeeper();
      }
   }
}