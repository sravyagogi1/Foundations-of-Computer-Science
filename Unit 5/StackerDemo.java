import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class StackerDemo
{
   public static void main(String[] args)
   {
      Display.setSize(10,10);
      Display.setSpeed(8);
      
      Stacker one = new Stacker(1, 1, 4);
      Stacker two = new Stacker(1, 2, 1);
      Stacker three = new Stacker(1, 3, 2);
     
      one.makeStacks(4);
      two.makeStacks(4);
      three.makeStacks(4);
   }
}