import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class CountStop extends ObstacleBot 
{
   private int stop;
   private int count=0;
   public CountStop(int x,int y)
   {
      super(x);
      stop=y;
     
 
   }

   public boolean keepGoing()
   {
      int x = 0;
 
      if(count<stop-1&& stop!=1)
      {
       count++;
     
         return true;
      }

      else
      {
         return false;
      }
   }

}
