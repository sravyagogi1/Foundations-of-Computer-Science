import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class BeeperCascade extends Athlete
{
//constructors
   public BeeperCascade()
   {
      super(5, 5, Display.EAST, Display.INFINITY);
   }
   public BeeperCascade(int x, int y, int dir, int beep)
   {
      super(x, y, dir, beep);
   }
   
//methods
   public void cascade(int n)
   {
      int run = 0;
      for(int i = n;i > 0; i --)
      {
         putPile(i);
         move();
         run++;
      }
      turnAround();
      sprint(run);
   }
}
    
   
   
