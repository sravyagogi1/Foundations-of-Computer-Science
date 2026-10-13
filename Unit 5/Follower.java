import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Follower extends Athlete implements Followable
{
   public Follower(int x, int y, int dire, int beeper)
   {
      super(x, y, dire, beeper);
   }
        
   public void followPath()
   {
      move();
     
      boolean front = true;
      boolean left=true;
      boolean right=true;
      while (front == true || left == true || right == true)
      {
         if(frontIsClear())
         {
            move();
            front = nextToABeeper();
            turnLeft();
            turnLeft();
            move();
            turnLeft();
            turnLeft();
         }
         else
         {
            front = false;
         }
        
         if(leftIsClear())
         {
            turnLeft();
            move();
            left = nextToABeeper();
            turnLeft();
            turnLeft();
            move();
            turnLeft();
         }
         else
         {
            left = false;
         }
        
         if(rightIsClear())
         {
            turnLeft();
            turnLeft();
            turnLeft();
            move();
            right = nextToABeeper();
            turnLeft();
            turnLeft();
            move();
            turnLeft();
            turnLeft();
            turnLeft();
         }
         else
         {
            right = false;
         }
        
         if(front)
         {
            move();
         }
         else if(left)
         {
            turnLeft();
            move();
         }
         else if(right)
         {
            turnLeft();
            turnLeft();
            turnLeft();
            move();
         }
      }
     
   }
}