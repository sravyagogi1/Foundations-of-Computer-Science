import javax.swing.*;
import java.awt.*;

public class Unit6Green2Panel extends JPanel
{                                        
   public void paintComponent(Graphics g)
   {
      //As you complete each part of this assignment, uncomment the appropriate
      //code and LEAVE IT UNCOMMENTED.  Your panel will slowly fill with a
      //variety of nifty shapes!
     
     
      //Fill in background.
      g.setColor(Color.LIGHT_GRAY);   
      g.fillRect(0, 0, 400, 400);
     
      //Part 1: Understand the Square class
      Square sq = new Square();  //Use default constructor
      sq.drawMe(g);
      sq.setX(sq.getX() + 20);  //Move this square 20 pixels to the right...
      sq.drawMe(g);                  //...and draw a second copy of it on the grid
     
      Square sq2 = new Square(30, 10, 30, Color.GREEN); //Use 4-arg constructor
      sq2.drawMe(g);
      sq2.setX(sq2.getX() + 50);  //Same with this square - move and draw again
      sq2.setColor(sq2.getColor().darker());  //But this time, we'll make it darker
      sq2.drawMe(g);
    
      System.out.println("sq is: " + sq.toString());
      System.out.println("sq2 is: " + sq2.toString());
    
    
      //Part 2: Write the Circle class, then uncomment the lines below.
    
      Circle cr = new Circle();
      Circle cr2 = new Circle(5, 200, 70, Color.BLUE);
     
      cr.drawMe(g);
      cr.setX(cr.getX() + 40);
      cr.drawMe(g);
     
      cr2.drawMe(g);
      cr2.setX(cr2.getX() + 40);
      cr2.setColor(Color.RED);
      cr2.setRadius(cr2.getRadius() + 5);
      cr2.drawMe(g);
  
      System.out.println("cr is: " + cr.toString());
      System.out.println("cr2 is: " + cr2.toString());
     
     
      //Part 3: Understand the Grid class
     
      Grid gr = new Grid();  //Use default constructorqg
      gr.drawMe(g);
      gr.setDivisions(6);
      gr.setX(gr.getX() + 150);
      gr.drawMe(g);
      System.out.println("gr is: " + gr.toString()); //See toString() working!
     
      Grid gr2 = new Grid(30, 320, 110, Color.BLACK, 5, Color.RED.darker());  //Use 6-arg constructor
      gr2.drawMe(g);
      gr2.setDivisions(3);
      gr2.setY(gr2.getY() + 60);
      gr2.setColor(Color.GRAY.brighter());   //Set the square color...
      gr2.setGridColor(Color.BLUE.darker()); //...and the grid color, separately
      gr2.drawMe(g);
      System.out.println("gr2 is: " + gr2.toString());
     
     
     
      //Part 4: Write the TJ class, then display the image
     
      Square tj = new TJ(50, 300, 25, Color.white);   //polymorphic behavior
      tj.drawMe(g);
     
      //Part 4 continued: Write the Ball class, then display a ball in the lower left corner
    
      Square ball = new Ball(50, 300, 300, Color.white);   //polymorphic behavior
      ball.drawMe(g);


     
      //Part 5: Write the Bullseye clas, then uncomment the lines below.
     
      Bullseye cyanDarkerBlue = new Bullseye(18, 180, 280, Color.CYAN, Color.CYAN.darker(), Color.BLUE);
      cyanDarkerBlue.drawMe(g);
      cyanDarkerBlue.setX(cyanDarkerBlue.getX() + 60);
      cyanDarkerBlue.setRadius((int) (cyanDarkerBlue.getRadius() * 2));
      cyanDarkerBlue.setColor(cyanDarkerBlue.getColor().darker());
      cyanDarkerBlue.setRingColor(cyanDarkerBlue.getRingColor().darker());
      cyanDarkerBlue.setCenterColor(cyanDarkerBlue.getCenterColor().darker());
      cyanDarkerBlue.drawMe(g);
      System.out.println("cyanDarkerBlue is: " + cyanDarkerBlue.toString());
     
     
      Bullseye redYellowBlue = new Bullseye(18, 105, 280, Color.RED, Color.YELLOW, Color.BLUE);
      redYellowBlue.drawMe(g);
      redYellowBlue.setX(redYellowBlue.getX() - 60);
      redYellowBlue.setRadius((int) (redYellowBlue.getRadius() * 2));
      redYellowBlue.setColor(redYellowBlue.getColor().darker());
      redYellowBlue.setRingColor(redYellowBlue.getRingColor().darker());
      redYellowBlue.setCenterColor(redYellowBlue.getCenterColor().darker());
      redYellowBlue.drawMe(g);
      System.out.println("redYellowBlue is: " + redYellowBlue.toString());
   }

}