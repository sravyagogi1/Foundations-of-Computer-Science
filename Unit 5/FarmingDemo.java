import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class FarmingDemo
{
   public static void workOneRow(Farmer arg)
   {
      for(int i = 0; i < 7; i++)
      {
         arg.workOnePlant();
         arg.move();
      }
      arg.workOnePlant();
   }

   public static void workField(Farmer arg)
   {
      for(int row = 0; row < 4; row++)
      {
         workOneRow(arg);
         arg.turnLeft(); arg.move(); arg.turnLeft();
         workOneRow(arg);
         arg.turnRight(); arg.move(); arg.turnRight();
      }
   }
   public static void main(String[] args)
   {
      Display.setSize(10, 10);
      Display.setSpeed(10);
      
      Farmer f;
      Display.openWorld("maps/field.map");
      f = new Harvester();
      workField(f);
      
      Display.openWorld("maps/field.map");
      f = new Planter();
      workField(f);
               
      Display.openWorld("maps/field.map");
      f = new Cultivator();
      workField(f);
   }
}