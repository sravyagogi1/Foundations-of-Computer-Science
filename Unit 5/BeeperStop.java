import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class BeeperStop extends ObstacleBot 
{
   public BeeperStop(int x)
   {
      super(x);
   }

   public boolean keepGoing()
   {
      if(!nextToABeeper())
       {
         return true;
         }
      else
      {
         return false;
         }
   }

}
