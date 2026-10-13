public interface Farmer
{
   public void move();
   public void turnRight();
   public void turnLeft();
   public void workOnePlant();
}

// Any class that implements Farmer, and has concrete methods to match these headers,
// can be instantiaed and assigned to a reference of type of Farmer, then sent to a 
// static method that takes a Farmer argument.

// Since different classes can implement these functions differently, the same commands
// to that Farmer argument can produce different results.  In object oriented
// programming, this is called polymorphism!