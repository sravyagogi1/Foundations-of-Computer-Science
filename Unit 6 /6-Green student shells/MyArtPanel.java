import javax.swing.*;
import java.awt.*;

public class MyArtPanel extends JPanel
{ 
   public void paintComponent(Graphics g)
   { 
      //Background
      g.setColor(new Color(184, 235, 255));
      g.fillRect(0, 0, 400, 400);
      
      //Text
      g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
      g.setColor(new Color(255, 182, 193));
      g.drawString("Flowers :)", 120, 40);
      
      //Grass
      g.setColor(new Color(147, 231, 140));
      for(int x = 5; x < 400; x+=10)
      {
         g.drawLine(x, 325, x, 400);
      }
         
      //filledStem
      g.setColor(new Color(147, 231, 140));
      g.fillRect(200,270,10,400);
      
      //emptyStem
      g.setColor(Color.GREEN.darker());
      g.drawRect(200,270,10,400);
      
      //filledpetals
      g.setColor(Color.WHITE);
      g.fillOval(167, 195, 80, 80);
      g.fillOval(135, 165, 80, 80);
      g.fillOval(200, 165, 80, 80);
      g.fillOval(167, 125, 80, 80);
      
      //emptypetals
      g.setColor(Color.GRAY);
      g.drawOval(167, 195, 80, 80);
      g.drawOval(135, 165, 80, 80);
      g.drawOval(200, 165, 80, 80);
      g.drawOval(167, 125, 80, 80);
      
      
      //filledtriangle
      g.setColor(new Color(252, 255, 145));
      int[] slantX = {180, 205, 230};
      int[] slantY = {220, 180, 220};
      g.drawPolygon(slantX, slantY, 3);
      g.fillPolygon(slantX,slantY,3);
      
      //emptytriangle
      g.setColor(Color.YELLOW.darker());
      int[] slantA = {180, 205, 230};
      int[] slantB = {220, 180, 220};
      g.drawPolygon(slantA, slantB, 3);
      
      
      
      
   }
}