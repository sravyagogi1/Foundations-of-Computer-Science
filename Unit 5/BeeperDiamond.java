import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class BeeperDiamond extends BeeperCascade
{
   public BeeperDiamond()
   {
      super(5,5,Display.EAST,85);
   }
   
   public void makeDiamond(int n)
   {
      cascade(5);
      move();
      putPile(4);
      move();
      putPile(3);
      move();
      putPile(2);
      move();
      putPile(1);
      turnAround();
      sprint(4);
      turnLeft();
      move();
      turnRight();
      cascade(4);
      move();
      cascade(3);
      move();
      turnLeft();
      move();
      turnRight();
      cascade(3);
      move();
      cascade(2);
      move();
      turnLeft();
      move();
      turnRight();
      cascade(2);
      move();
      cascade(1);
      move();
      turnLeft();
      move();
      putBeeper();
      turnAround();
      sprint(5);
      turnRight();
      cascade(4);
      move();
      cascade(3);
      move();
      turnLeft();
      move();
      turnRight();
      cascade(3);
      move();
      cascade(2);
      move();
      turnLeft();
      move();
      turnRight();
      cascade(2);
      move();
      cascade(1);
      move();
      turnLeft();
      move();
      putBeeper();
   }
}