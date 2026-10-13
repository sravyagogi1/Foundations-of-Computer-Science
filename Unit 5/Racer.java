import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Racer extends Athlete
{

   public Racer(int y)
   {
      super(1,y,Display.EAST,0);
   }
   
   public void shuttle(int spaces, int beepers)
   {
     
      move();
      turnLeft();
      move();
      turnRight();
      move();
      turnRight();
      move();
      turnLeft();
      sprint(spaces);
      pickPile();
      turnAround();
      sprint(spaces);
      turnRight();
      move();
      turnLeft();
      move();
      turnLeft();
      move();
      turnRight();
      move();
      putPile(beepers);
      turnAround();
     
   }
}