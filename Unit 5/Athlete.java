import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Athlete extends Robot
{
//constructors
   public Athlete()
   {
      super(1, 1, Display.NORTH, Display.INFINITY);
   }
   public Athlete(int x, int y, int dir, int beep)
   {
      super(x, y, dir, beep);
   }

//new instance methods
   public void turnAround()
   {
      turnLeft();
      turnLeft();
   }
   public void turnRight()
   {
      turnLeft();
      turnLeft();
      turnLeft();
   }


//move forward the given number of times
   public void sprint(int spaces)
   {
      for(int i = 0;i < spaces; i++)
      {
         move();
      }
   }
   
   //move forward until you hit a wall
   public void moveToWall()
   {
      while (frontIsClear())
      {
         move();
      }
   }
   
   //put down a pile of the given number of beepers
   public void putPile(int beepers)
   {
      for(int i = 0;i < beepers; i ++)
      {
         putBeeper();
      }
   }
   
   //pick up a whole pile of beepers
   //i.e., keep picking up beepers until there aren't any
   public void pickPile()
   {
      while (nextToABeeper())
      {
         pickBeeper();
      }
   }
   
}