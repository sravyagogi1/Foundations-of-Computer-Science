import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class RunRaceDemo
{
      public static void main(String[] args)
   {
      Display.openWorld("maps/track.map");
      Display.setSize(10, 10);
      Display.setSpeed(6);
      
      Athletic r1 = new Athletic();
      Lazy r2 = new Lazy();
      Smart r3 = new Smart();

      Thread t1 = new Thread(r1);
      Thread t2 = new Thread(r2);
      Thread t3 = new Thread(r3);
      
      t1.start();
      t2.start();
      t3.start();
   }
}