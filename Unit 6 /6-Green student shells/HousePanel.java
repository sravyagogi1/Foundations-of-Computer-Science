import javax.swing.*;
import java.awt.*;

/*
This is a demonstration of many graphics commands!
Run HouseDriver.java, and look at the resulting image as you read along with the comments below.
            
As you read this, please feel free to experiment!  Change values, move commands around, watch what happens!
*/

public class HousePanel extends JPanel  // JPanel is a built-in class of Java Swing.  It has many methods to display
{                                        // graphics content, but doesn't automatically use them.  We will use them!

   /*
   Where are the constructors?
   Well, if you only want a default constructor that calls the superclass's default constructor, you don't need to
   write that!  A HousePanel() just needs to extend JPanel(), whichJava can do automatically.
   */
   
   public void paintComponent(Graphics g) // paintComponent() is called automatically, but usually shows nothing.  We'll
   {                                      // add commands here to show what we want when this panel is loaded in a JFrame.
   
      /*
      HousePanel is a content pane made up of individual pixels, each identified by an x coordinate and a y coordinate.
      In Java graphics, x and y coordinates are counted from the TOP LEFT corner.  In other words, the top left is (0,0).  
      The x value of a pixel increases to the right as you'd expect.  The y value increases on the way DOWN.  So the 
      point (10, 25) is directly ABOVE (10, 100), and in this particular program's case (400,400) is the BOTTOM RIGHT.
      
      You draw objects or words onto the screen with individual graphics commands.  These draw one thing at a time onto 
      the content pane.  It all happens so fast that it looks like it's simultaneous, but it isn't.  You'll notice below 
      that we take the Graphics object g automatically passed into this method and alternate setting a color and then 
      drawing something.  Each time you set a color, that color is used for all the things you draw until you set a 
      different color on a later line of code.
      
      Java's Color class predefines thirteen color constants:  BLACK, BLUE, CYAN, DARK_GRAY, GRAY, GREEN, LIGHT_GRAY, 
      MAGENTA, ORANGE, PINK, RED, WHITE, and YELLOW.  You can see several examples below.  You can also define your 
      own colors; see NOTE 1 at the bottom of this file.
      */
      
      //Fill in background.  We'll use a rectangle to cover the whole content pane, which is 400x400.
      g.setColor(Color.LIGHT_GRAY);  	
      g.fillRect(0, 0, 400, 400);  //4 args.  Starting at top left corner, (x, y, width, height).
   	
   	//Draw house
      g.setColor(Color.RED.darker());
      g.fillRect(210,75,25,100);
      g.setColor(Color.GREEN.darker());      //We can call .darker() or .brighter() on any built in color constant.
      g.fillRect(0, 350, 400, 350);				//Draw the green ground.  4 args, (x, y, x2, y2) draws a line from (x, y) to (x2, y2).
      g.setColor(Color.RED);
      g.fillRect(100, 200, 150, 150);			//Draw a square for red walls.  Note difference between drawRect and fillRect.
      g.setColor(Color.BLACK);
      g.fillRect(150, 275, 50, 75);     	   //Draw a solid black door.
   
   	//Draw the triangle roof, which needs three points: 	(75, 200) and
      int[] roofX = {75, 175, 275};			//			      (175, 150) and
      int[] roofY = {200, 50, 200};		//			      (275, 200)
      g.drawPolygon(roofX, roofY, 3);		//Draw the roof (color is still black).  More explanation of this method in NOTE 2 below.
      g.fillPolygon(roofX,roofY,3);
   
      //Draw the sun
      g.setColor(Color.YELLOW);
      g.fillOval(275, 50, 100, 100);  //4 args; this one's a little strange.  Imagine a rectangle around the oval and
                                    //the arguments are (x, y, width, height) as before, where (x, y) is the top left 
                                    //OF THAT RECTANGLE (not the oval's center).  So, the sun is not centered at (300,75).
                                    //If you drew a rectangle (square in this case) around the sun, the top left would be
                                    //at (300,75).  The center of this circle is at (325, 100) - how do I know that?
   
   	//Display the string
      //Font is an object in Java.  Constructor takes (style, plain/bold/italic, and size).  More examples in NOTE 3.
      g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));  //We'll use size 30 serif font, bold AND italic.
      g.setColor(Color.WHITE);
      g.drawString("Welcome Home", 75, 383); //The arguments are (String, x, y), where x,y is the location of the BOTTOM left corner
                                            //of the first letter.  (Not the TOP left corner, like the rectangles/ovals.)
      
      //Draw the picket fence (still white from setting the color above).
      for(int x = 5; x < 400; x+=20)  //Use a loop to draw equally spaced identical shapes; note x+=10 not x+=1.
         g.drawLine(x, 300, x, 350);
      
      //Draw the clouds (also still white).  These are on top of the sun because we drew them later.
      for(int x = 20; x < 300; x+=35)
         g.drawOval(x, 100, 50, 30);
      
   }
}

/*
NOTE 1: custom colors!

Google "color picker", pick your color, and type in the three RGB values in a 
Color constructor to create your own color.  For example: 
         g.setColor(new Color(66, 135, 245));   //Common mistake: don't forget "new".


NOTE 2: how drawPolygon works!

To be specific, drawPolygon takes two integer arrays and a number of points.  It iterates over both lists
simultaneously, taking each x coordinate in turn from the first and each y coordinate in turn from the second.
The last point is automatically connected back to the first.  For this to work, the length of both arrays
should be equal to the integer given as the final argument.


NOTE 3: More Font examples!

new Font("Serif", Font.PLAIN, 8)
new Font("SansSerif", Font.BOLD, 20)
new Font("Monospaced", Font.ITALIC, 12)
new Font("Arial", Font.BOLD | Font.ITALIC, 60)

Try them out and see what they look like!
*/