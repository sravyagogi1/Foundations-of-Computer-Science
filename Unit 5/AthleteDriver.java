import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class AthleteDriver
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/athleteDemoMap.map");
      Display.setSize(10, 10);
      Display.setSpeed(5);
      
      Athlete lionelMessi = new Athlete();
      Athlete simoneBiles = new Athlete(3, 5, Display.SOUTH, 6);
      
       lionelMessi.sprint(5);
       lionelMessi.putPile(6);
       lionelMessi.turnRight();
       lionelMessi.sprint(9);
       
       simoneBiles.pickPile();
       simoneBiles.move();
       simoneBiles.pickPile();
       simoneBiles.moveToWall();
       simoneBiles.putPile(8);
       simoneBiles.turnAround();
       simoneBiles.move();
       
   }
}
