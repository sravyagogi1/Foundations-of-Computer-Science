import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class HelpPanel extends JPanel
{
   private JFrame myOwner;
  
   public HelpPanel(JFrame owner)
   {
      this.myOwner = owner;
      setLayout(new BorderLayout()); 
      setBackground(new Color(189, 215, 238));
     
      JLabel title = new JLabel("How to Play Crossy Pig");
      title.setFont(new Font("Serif", Font.BOLD, 60));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);

      JPanel instructionsPanel = new JPanel();
      instructionsPanel.setLayout(new GridLayout(2, 2));
      instructionsPanel.setBackground(new Color(189, 215, 238));

      JLabel step1 = new JLabel(" 1) Use WASD or the arrow keys to move");
     
      JLabel step2 = new JLabel(" 2) Get to the end without dying to score");
     
      JLabel step3 = new JLabel(" 3) See how many points you can score!");
     
     
      step1.setFont(new Font("Serif", Font.PLAIN, 20));
      step2.setFont(new Font("Serif", Font.PLAIN, 20));
      step3.setFont(new Font("Serif", Font.PLAIN, 20));
      step1.setHorizontalAlignment(SwingConstants.CENTER);
      step2.setHorizontalAlignment(SwingConstants.CENTER);
      step3.setHorizontalAlignment(SwingConstants.CENTER);
      
      //Image
      ImageIcon imageIcon = new ImageIcon("pig3.png"); // Load image from resources
      JLabel imageLabel = new JLabel(imageIcon);
      imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
      

     
      instructionsPanel.add(step1);
      instructionsPanel.add(step2);
      instructionsPanel.add(step3);
      instructionsPanel.add(imageLabel);

      add(instructionsPanel, BorderLayout.CENTER);

    
      JButton backButton = new JButton("Back");
      backButton.setFont(new Font("Serif", Font.BOLD, 16));
      backButton.addActionListener(new Listener_BackButton());
      add(backButton, BorderLayout.SOUTH);
   }
  
   private class Listener_BackButton implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myOwner.getContentPane().removeAll();
         myOwner.getContentPane().add(new Menu(myOwner));
         myOwner.getContentPane().revalidate();
         myOwner.getContentPane().repaint();
         myOwner.pack();
      }
   }
}
