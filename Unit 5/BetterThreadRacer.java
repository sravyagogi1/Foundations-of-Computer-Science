import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class BetterThreadRacer extends Racer implements Runnable
{
   private int[] distances;
   private int[] pileSizes;
  
   public BetterThreadRacer(int y, int[] distances, int[] pileSizes )
   {
      super(y);
      this.distances = distances;
      this.pileSizes = pileSizes;
   }
  
   public void run()
   {
      for (int i = 0; i < distances.length; i++)
      {
         shuttle(distances[i], pileSizes[i]);
      }
      move();
   }
}
