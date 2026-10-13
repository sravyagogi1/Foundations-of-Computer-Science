import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import javax.swing.JOptionPane;

public class BeeperMathematicianDemo
{
   public static void main(String[] args)
   {
      String filename = JOptionPane.showInputDialog("What robot world?");
      Display.openWorld("maps/" + filename + ".map");
      Display.setSize(10, 10);
      Display.setSpeed(10);
      
      BeeperMathematician one = new BeeperMathematician(1);
      int oneSize = one.getPileSize();
      one.move();
      System.out.println("Row one beeper pile has size: " + oneSize);
      
      BeeperMathematician two = new BeeperMathematician(2);
      boolean twoOdd = two.isOddPile();
      two.move();
      if(twoOdd)
      {
         System.out.println("Row two beeper pile has an odd number of beepers.");
      }
      else
      {
         System.out.println("Row two beeper pile has an even number of beepers.");
      }
      
      BeeperMathematician three = new BeeperMathematician(3);
      double averageOfPiles = three.getAverageOfPiles(3);
      System.out.println("Average of piles in row 3 is: " + averageOfPiles);
      
      BeeperMathematician four = new BeeperMathematician(4);
      boolean[] isOddPile = four.oddsAndEvensInRow(6);
      System.out.print("Row 4: is each pile odd? ");
      for(int i=0; i<isOddPile.length; i++)
      {
         System.out.print(isOddPile[i] + " ");
      }
      System.out.println();
      if (four.nextToABeeper())
      {
         four.move();
         
      }
      four.sprint(6);
      
      BeeperMathematician five = new BeeperMathematician(5);
      BeeperMathematician six = new BeeperMathematician(6);
      int[] pileSizes = five.getPileSizes(6);
      six.placePiles(pileSizes);
      six.move();
      
      BeeperMathematician seven = new BeeperMathematician(7);
      BeeperMathematician eight = new BeeperMathematician(8);
      int multiplier = seven.getPileSize();
      seven.move();
      int[] values = seven.getPileSizes(3);
      int[] scaledPiles = new int[3];
      for (int i = 0; i < 3; i++)
      {
         scaledPiles[i] = values[i] * multiplier;
      }
      eight.placePiles(scaledPiles);
      eight.move();
   }
}