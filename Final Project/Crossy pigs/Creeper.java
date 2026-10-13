import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;

public class Creeper extends Square implements Animatable {
    private int dX;
    private int dY;
    private Image creeperImage;
    
    public Creeper(int sideValue, int xValue, int yValue, Color cValue) {
        super(sideValue, xValue, yValue, cValue);
        ImageIcon icon = new ImageIcon("creeper.png");
        creeperImage = icon.getImage();
        dX = 2;
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
        setX(getX() - dX);
        setY(getY() + dY);
    }

    public void draw(Graphics g, JPanel panel) {
        g.drawImage(creeperImage, getX(), getY(), getSide(), getSide(), panel);
    }
}
