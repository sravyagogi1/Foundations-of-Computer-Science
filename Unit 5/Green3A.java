import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
public boolean Green3A extends Robot
{public Green3A(int x, int y, int dir, int beeper)
   {super(x, y, dir, beeper);}  
   public boolean checkSize(int a)
   {
      int count = 0;
      while(nextToABeeper())      {count++;}
      if(count > a)          {return true;}
      else                {return false;} 
   }
   public boolean[] beeperCheck(int a)
   {
   boolean[] Array = new boolean[a];
   for(int i = 0; i < a; i++)
   {
      if(nextToABeeper())
      {
         Array[i] = true;
      }
      if(!nextToABeeper())
      {
         Array[i] = false;
      }}}}