import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class StackFixer extends Athlete implements Fixable
{
   private int size;
   private int steps;

   public StackFixer(int x, int y, int givenSize, int givenSteps)
   {
      super(x, y, Display.EAST, Display.INFINITY);
       size = givenSize;
       steps = givenSteps;
   }
   
   public void fixStack()
   {
      int count = 0;
      while (nextToABeeper())
      {
         count++;
         pickBeeper();
      }
      putPile(size);
   }
   
   public void fixStacks()
   {
      for(int i = 0; i<steps;i++)
      {
         if(nextToABeeper())
         {
            fixStack();
         }
         move();  
      }
   }
}    
   

