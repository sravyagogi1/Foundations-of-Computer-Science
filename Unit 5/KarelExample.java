// name:      date: 
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class KarelExample
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/first.map");
      
      Robot karel = new Robot();
      
      karel.move();
   }
}

