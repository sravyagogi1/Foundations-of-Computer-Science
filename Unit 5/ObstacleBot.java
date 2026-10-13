import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public abstract class ObstacleBot extends Athlete implements Runnable 
{
   public ObstacleBot(int x)
   {
      super(x, 1, Display.NORTH, 0);
   }
   public abstract boolean keepGoing();
 
 
   public void run()
   {
 
      while(keepGoing())
      {
         if(frontIsClear())
            move();
         else
       
         {
            turnRight();
             int counter=0;
            while(!leftIsClear())
            {move();
               counter++;
            }
            turnLeft();
            move();
            turnLeft();
            sprint(counter);
            turnRight();
         }
    
      }
   }
}
