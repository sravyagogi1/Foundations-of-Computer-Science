import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

public class Pig extends Square implements Animatable {
    private int dX;
    private int dY;
    private Image pigImage;

    public Pig(int sideValue, int xValue, int yValue, Color cValue) {
        super(sideValue, xValue, yValue, cValue);
        ImageIcon icon = new ImageIcon("pig3.png");
        pigImage = icon.getImage();
        dX = 0;
        dY = 0;
    }

    public int getDX() {
        return dX;
    }

    public int getDY() {
        return dY;
    }

    public void setDX(int dXValue) {
        dX = dXValue;
    }

    public void setDY(int dYValue) {
        dY = dYValue;
    }

    public void step() {
        setX(getX() + dX);
        setY(getY() + dY);
    }

    public void draw(Graphics g, JPanel panel) {
        g.drawImage(pigImage, getX(), getY(), getSide(), getSide(), panel);
    }
}
