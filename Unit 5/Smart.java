import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Smart extends Athlete implements Runnable
{
   public Smart()
   {
       super(1,8,Display.EAST,0);
   }
   public void run()
   {
      while(!nextToABeeper())
      {
         if(frontIsClear())
         {
            move();
         }
         else
         {         
            turnLeft();
            move();
            turnRight();
            move();
         }
     }
   }
}
