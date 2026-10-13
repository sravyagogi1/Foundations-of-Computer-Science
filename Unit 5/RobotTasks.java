import javax.swing.JOptionPane;
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class RobotTasks
{

   public static void main(String[]args)
   {
      String filename = JOptionPane.showInputDialog("What robot world?");
      Display.openWorld("maps/" + filename + ".map");
      Display.setSize(12,12);
      Display.setSpeed(10);
     
      Robot a = new Robot(1,1,Display.EAST,9);
      Robot b = new Robot(1,2,Display.EAST,9);
      Robot c = new Robot(1,3,Display.EAST,9);
      Robot d = new Robot(1,4,Display.EAST,9);
      Robot e = new Robot(1,5,Display.EAST,9);
      Robot f = new Robot(1,6,Display.EAST,9);
      Robot g = new Robot(1,7,Display.EAST,9);
      Robot h = new Robot(1,8,Display.EAST,9);
      Robot i = new Robot(1,9,Display.EAST,20);
      Robot j = new Robot(1,10,Display.EAST,9);
      Robot k = new Robot(1,11,Display.EAST,9);
      Robot l = new Robot(1,12,Display.EAST,9);
      
      while (a.nextToABeeper())
      {
      a.move();
      }
      
      while (b.frontIsClear() && !b.nextToABeeper())
      {
      b.move();
      }
      
      while (c.frontIsClear())
      {
      c.move();
      }
      
      int count = 0;
      
      while (d.frontIsClear())
      {
        while (d.nextToABeeper())
         {
          d.pickBeeper();
          count++;
         }
         d.move();
      }
      
      if (d.frontIsClear())
      {
         d.move();
      }
      
      while (d.nextToABeeper())
      {
         d.pickBeeper();
         count++;
      }
      
      System.out.println("I have " + count + " beepers.");
      
      while (e.frontIsClear())
      {
         while (e.nextToABeeper())
         {
            e.pickBeeper();
         }
         e.move();
         
         while (e.nextToABeeper())
         {
            e.pickBeeper();
         }
      }
      
      int gaps = 0;
      
      while (f.nextToABeeper())
      {
         f.move();
      }
      if (gaps == 0);
      {
         gaps++;
         f.move();
         while(f.nextToABeeper())
         {
            f.move();
         }
      }
      
      int steps = 0;
      if (g.frontIsClear())
      {
         while ((!g.nextToABeeper()) || !g.frontIsClear())
         {
            g.move();
            steps++;
         }
      }
      
      System.out.println("The number of steps is " + steps);
      
      if (h.nextToABeeper())
      {
         h.move();
         h.move();
         h.move();
         h.move();
         h.move();
      }
      
      else if(!h.nextToABeeper())
      {
         h.move();
         h.move();
         h.move();
      }
      
      for (int pile = 0;pile<5; pile++)
      {
         i.putBeeper();
         i.putBeeper();
         i.putBeeper();
         i.putBeeper();
         i.move();
      }
      
      while (j.frontIsClear())
      {
         if (!j.nextToABeeper())
         {
            j.putBeeper();
         }
         j.move();
      }
      
      while (!k.rightIsClear())
      {
         k.putBeeper();
         k.move();
      }
      
      while (l.rightIsClear() || (! l.nextToABeeper()))
      {
         l.move();
      } 
      
      
}}