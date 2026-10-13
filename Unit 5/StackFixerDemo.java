import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class StackFixerDemo
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/randomStacks.map");
      Display.setSize(10,10);
      Display.setSpeed(100);
      
      //instantiate 10 StackFixer objects
      
      //call fixStacks() on each StackFixer
     
      StackFixer[] stackFixers = new StackFixer[10];
      
      for (int index = 0; index < stackFixers.length; index++)
      {
         stackFixers[index] = new StackFixer(1, index + 1, index + 1, 10);
      }
      
      for (StackFixer stackFixer : stackFixers)
      {
         stackFixer.fixStacks();
      }
   }
}