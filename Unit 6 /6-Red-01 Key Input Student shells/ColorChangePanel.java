import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class ColorChangePanel extends JPanel
{
   public static final int FRAME = 500;
   private static final Color BACKGROUND = new Color(204, 204, 204);

   private BufferedImage myImage;
   private Graphics myBuffer;
   private Timer t;
   private ArrayList<Animatable> animationObjects;
   private ArrayList<ColorChangeSquare> colorChangeSquares;

   public ColorChangePanel()
   {
      myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
  
      animationObjects = new ArrayList<>();
      colorChangeSquares = new ArrayList<>();
  
      for (int i = 0; i < 10; i++)
      {
         ColorChangeSquare square = new ColorChangeSquare();
         animationObjects.add(square);
         colorChangeSquares.add(square);
      }
  
      t = new Timer(5, new AnimationListener());
      t.start();
   }

   public void paintComponent(Graphics g)
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
   }

   public void animate()
   {
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
  
      for (Animatable animationObject : animationObjects) 
      {
         animationObject.step();
      }
      // 
      for (int i = 0; i < colorChangeSquares.size(); i++)
      {
         ColorChangeSquare square = colorChangeSquares.get(i);
         boolean collided = false;
         for (int j = 0; j < colorChangeSquares.size(); j++)
         {
            if (i != j && square.collide(colorChangeSquares.get(j)))
            {
               collided = true;
               break;
            }
         }
         if (collided)
         {
            square.useSecretColor();
         }
         else
         {
            square.useBlack();
         }
      }
  
      for (Animatable animationObject : animationObjects)
      {
         animationObject.drawMe(myBuffer);
      }
  
      repaint();
   }

   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         animate();
      }
   }
}
