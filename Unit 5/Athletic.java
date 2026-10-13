import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Athletic extends Athlete implements Runnable
{
   public Athletic()
   {
       super(1,5,Display.EAST,0);
   }
   public void run()
   {
      while(!nextToABeeper())
      {
         if(frontIsClear())
         {
            move();
         }
         else if(!frontIsClear())
         {
            turnLeft();
            move();
            turnRight();
            move();
            turnRight();
            move();
            turnLeft();
         }
     }
   }
}
