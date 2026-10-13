import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class BeeperMathematician extends Athlete
{

   public BeeperMathematician(int y)
   {
      super(1,y,Display.EAST,Display.INFINITY);
   }  
   
//Pick up all the beepers in the current location,
// counting as you pick them up.
//Put all the beepers you picked up back down
//Return the count

   public int getPileSize()
      {
         int count = 0;
         while(nextToABeeper())
         {
            pickBeeper();
            count++;
         }
         putpile(count);
         return count;
      }

//Return true if the Robot is standing on a pile of an odd number of beepers, false otherwise.
//Hint: this method should call getPileSize()
   public boolean isOddPile()
   {
      int count = getPileSize();
      if(count % 2 == 0)
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
//Instantiate an array of booleans
//for each pile in piles, determine if it is odd or even. If it is
// odd, store true in the array; otherwise, store false.
//Hint: this method should call isOddPile()
//return the array of booleans
   public boolean[] oddsAndEvensInRow(int piles)
   {
      boolean[] result = new boolean[piles];
      for (int i = 0; i < piles; i++)
      {
         result[i] = isOddPile();
      }
      return result;
   }
//p is an int representing a number of piles, all in a row.
//count the current pile, put it back down, and move forward p times to each new pile.
//Keep track of the total number of beepers in all the piles.
//Return the average size of all p piles - the total / p
//Make sure you perform division with doubles, not with ints
   public double getAverageOfPiles(int p)
   {
      int totalBeepers = 0;

      for (int i = 0; i < p; i++)
      {
         totalBeepers += getPileSize();
         if (i <= p)
            {
               move();
            }
      }
        return (double) totalBeepers / p;
   }
//p is an int representing a number of piles in a row.
//Make a new int array of size p.
//Count the next p piles; ie, count the current pile, replace it, and move forward p times
//Save each count separately in consecutive spaces in the array.
//Return the array.
   public int[] getPileSizes(int p)
   {
      int[] pileSizes = new int[p];
      
      for (int i = 0; i < p; i++)
      {
         pileSizes[i] = getPileSize();
         move();
      }
      return pileSizes;
   }

//piles is an array of ints.
//Starting at the current location, make piles of
// beepers in a row moving forward
// that match the integer values in piles.
//Hint: use a for-loop that counts from 0 to piles.length
   public void placePiles(int[] piles)
   {
      for (int i = 0; i < piles.length; i++)
      {
         putPile(piles[i]);
      if (i < piles.length - 1)
      {
         move();
      }
   }
}
}
         
         