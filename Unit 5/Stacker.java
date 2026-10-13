import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Stacker extends Athlete
{
   //fields
   private int size;
   
   //constructor
   public Stacker(int x, int y, int givenSize)
   {
      super(x, y, Display.EAST, Display.INFINITY);
      size = givenSize;
   }
   
   //instance methods
   public void makeStack()
   {
      for(int i = 0; i < size; i++)
      {
         putBeeper();
      }
   }
   
   public void makeStacks(int num)
   {
      for(int i = 0; i < num; i++)
      {
         makeStack();
         move();
      }
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
      for(int i = 0; i<10;i++)
      {
         if(nextToABeeper())
         {
            fixStack();
         }
         move();  
      }
   }
}