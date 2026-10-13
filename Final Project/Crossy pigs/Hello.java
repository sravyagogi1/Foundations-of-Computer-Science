import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

public class Skeleton extends Square implements Animatable {
    private int dX;
    private int dY;
    private Image skeletonImage;

    // Constructor
    public Skeleton(int sideValue, int xValue, int yValue, Color cValue) {
        super(sideValue, xValue, yValue, cValue);
        ImageIcon icon = new ImageIcon("skeleton1.png");
        skeletonImage = icon.getImage();
        dX = 2; // Initial speed in X direction
        dY = 0; // Initial speed in Y direction
    }

    // Accessors
    public int getDX() {
        return dX;
    }

    public int getDY() {
        return dY;
    }

    // Modifiers
    public void setDX(int dXValue) {
        dX = dXValue;
    }

    public void setDY(int dYValue) {
        dY = dYValue;
    }

    // Instance methods
    public void step() {
        setX(getX() + dX);
        setY(getY() + dY);
    }

    public void draw(Graphics g, JPanel panel) {
        g.drawImage(skeletonImage, getX(), getY(), getSide(), getSide(), panel);
    }
}
