import java.awt.Color;

public class ColorChangeSquare extends BouncingSquare {
   private Color secretColor;

   // Constructor with a specified secret color
   public ColorChangeSquare(Color secretColor) {
      super(50, (int)(Math.random() * (ColorChangePanel.FRAME - 50)), (int)(Math.random() * (ColorChangePanel.FRAME - 50)), Color.BLACK, (int)(Math.random() * 5) + 1, (int)(Math.random() * 5) + 1);
      this.secretColor = secretColor;
   }

   // Default constructor with a randomly chosen secret color
   public ColorChangeSquare() {
      this(new Color((int)(Math.random() * 257), (int)(Math.random() * 257), (int)(Math.random() * 257)));
   }

   // Method to set the square's actual color to its secret color
   public void useSecretColor() {
      setColor(secretColor);
   }

   // Method to set the square's actual color back to black
   public void useBlack() {
      setColor(Color.BLACK);
   }

   // Method to check if this square collides with another square
   public boolean collide(ColorChangeSquare otherSquare) {
      int thisLeft = getX();
      int thisRight = getX() + getSide();
      int thisTop = getY();
      int thisBottom = getY() + getSide();
  
      int otherLeft = otherSquare.getX();
      int otherRight = otherSquare.getX() + otherSquare.getSide();
      int otherTop = otherSquare.getY();
      int otherBottom = otherSquare.getY() + otherSquare.getSide();
  
      return thisLeft < otherRight && thisRight > otherLeft && thisTop < otherBottom && thisBottom > otherTop;
   }
}

