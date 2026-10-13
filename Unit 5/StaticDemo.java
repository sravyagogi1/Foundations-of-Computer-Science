//Torbert, e-mail: smtorbert@fcps.edu
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class StaticDemo
{
   public static void takeTheField(Athlete arg)
   {
      arg.sprint(4);
      arg.turnRight();
      arg.sprint(2);
   }
   public static void main(String[] args) 
   {
      Display.openWorld("maps/arena.map");
      Display.setSize(10, 10);
      Display.setSpeed(7);
   	
      Athlete a, b, c, d, e, f, g, h, coach;
      a = new Athlete();
      b = new Athlete();
      c = new Athlete();
      d = new Athlete();
      e = new Athlete();
      f = new Athlete();
      g = new Athlete();
      h = new Athlete();
   	
      coach = new Athlete(2, 7, Display.EAST, Display.INFINITY);
   	
      takeTheField(a);
      a.sprint(3);
      a.turnLeft();
      a.sprint(2);
      a.turnAround();
      
      takeTheField(b);
      b.sprint(5);
      b.turnLeft();
      b.move();
      b.turnAround();
      
      takeTheField(c);
      c.sprint(4);
      c.turnRight();
      
      takeTheField(d);
      d.sprint(3);
      d.turnRight();
      
      
      takeTheField(e);
      e.sprint(2);
      e.turnRight();
      
      takeTheField(f);
      f.move();
      f.turnLeft();
      f.move();
      f.turnAround();
      
      takeTheField(g);
      g.sprint(2);
      g.turnLeft();
      g.sprint(2);
      g.turnAround();
      
      takeTheField(h);
      h.sprint(4);
      h.turnLeft();
      h.sprint(2);
      h.turnAround();
   }
}