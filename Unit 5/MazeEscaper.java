import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class MazeEscaper extends Athlete implements Escapable
{

   public MazeEscaper()
   {
      super(1, 1, Display.NORTH, 0);
   }
   
   public void escape()
   {
      while(!nextToABeeper())
      {
         turnLeft();
      
         if(frontIsClear())
         {
            move();
         }
         
         else
         {
            turnRight();
            
            if(frontIsClear())
            {
               move();
            }
            
            else
            {
               turnRight();
            
               if(frontIsClear())
               {
                  move();
               }
               else
               {
                  turnRight();
                  move();
               }
            }
         }
      }
   }
}