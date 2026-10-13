import javax.swing.*;
import java.awt.*;

public class Square {
    private int side;
    private int x;  // x coordinate of top left corner
    private int y;  // y coordinate of top left corner
    private Color color;

    // constructors
    public Square()
    {
        side = 10;
        x = 10;
        y = 10;
        color = Color.BLACK;
    }

    public Square(int sideValue, int xValue, int yValue, Color cValue)
    {
        side = sideValue;
        x = xValue;
        y = yValue;
        color = cValue;
    }

    // accessors
    public int getSide()
    {
        return side;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    // modifiers
    public void setSide(int sideValue)
    {
        side = sideValue;
    }

    public void setX(int xValue)
    {
        x = xValue;
    }

    public void setY(int yValue)
    {
        y = yValue;
    }

    // instance methods
    public void drawMe(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, side, side);
    }

    // other useful Java methods
    public String toString()
    {
        return "Square at " + x + ", " + y + " with side length " + side;
    }
}
