import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Lazy extends Athlete implements Runnable
{
   public Lazy()
   {
       super(1,2,Display.EAST,0);
   }
   public void run()
   {
      while(frontIsClear())
      {
         move();
      }
   }
}