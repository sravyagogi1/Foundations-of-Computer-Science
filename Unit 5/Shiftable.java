public interface Shiftable
{
   public void shift(); //shift one row of piles of beepers
   public void shiftPile(); //shift one pile
   public void moveToPile();
   public void moveBackOneSpace();
   public int pickAndCountPile();
   public void putPile(int beepers); //already written in Athlete
}