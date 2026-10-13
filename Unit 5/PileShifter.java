import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class PileShifter extends Athlete implements Shiftable
{
   int count = 0;
   public PileShifter(int x, int y)
   {
      super(x, y, Display.WEST, 0);
   }
   public int pickAndCountPile()
   {
      count = 0;
      while (nextToABeeper())
      {
         pickBeeper();
         count ++;
      }
      return count;
   }
  
   public void moveBackOneSpace()
   {
      turnAround();
      move();
   }
  
   public void moveToPile()
   {
      while (!nextToABeeper())
      {
         move();
      }
   }
  
   public void shiftPile()
   {
      pickAndCountPile();
      moveBackOneSpace();
      putPile(count);
      turnAround();
      move();
   }
  
   public void shift()
   {
      while(frontIsClear())
      {
         moveToPile();
         shiftPile();
      }
   }
}