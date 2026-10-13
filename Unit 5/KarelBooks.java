//Sravya Gogineni 1/17/24
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class KarelBooks
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/school.map");
      Display.setSize(10,10);
      Display.setSpeed(5);
      
      Robot lisa = new Robot();
      Robot pete = new Robot(4,5,Display.SOUTH,0);
      
      lisa.move();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      lisa.pickBeeper();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      lisa.move();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      lisa.move();
      lisa.move();
      lisa.turnLeft();
      lisa.move();
      lisa.move();
      lisa.putBeeper();
      lisa.move();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.move();
      lisa.turnLeft();
      lisa.turnLeft();
      lisa.turnLeft();
      
      pete.move();
      pete.pickBeeper();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.turnLeft();
      pete.turnLeft();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.turnLeft();
      pete.move();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.turnLeft();
      pete.turnLeft();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.turnLeft();
      pete.move();
      pete.move();
      pete.putBeeper();
      pete.turnLeft();
      pete.turnLeft();
      pete.move();
      
   }
}

