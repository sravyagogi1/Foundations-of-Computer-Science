import java.awt.*;
import javax.swing.*;

public class CrossyPigPanel extends JPanel {
    public CrossyPigPanel() {
        setLayout(new BorderLayout());
       
        // Set background color to a lighter shade of blue
        setBackground(new Color(189, 215, 238)); // Lighter blue color
       
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(1,1));
       
        // Text
        JLabel title = new JLabel("Welcome To Crossy Pig!");
        title.setFont(new Font("Serif", Font.BOLD, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.CENTER);
      
             
        // Adding operation panel
        JPanel southSubpanel = new JPanel();
        southSubpanel.setLayout(new GridLayout(1,3));
       
        // Adding operation buttons
        JButton playButton = new JButton("Play");
        southSubpanel.add(playButton);
       
        JButton helpButton = new JButton("Help");
        southSubpanel.add(helpButton);
       
        JButton exitButton = new JButton("Exit");
        southSubpanel.add(exitButton);
        
        // Image
        ImageIcon imageIcon = new ImageIcon("pig3.png"); // Load image from resources
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Panel.add(imageLabel, BorderLayout.CENTER);
       
        // Adding the subpanel to the main panel
        add(southSubpanel, BorderLayout.SOUTH);
        add(Panel, BorderLayout.NORTH);
    }
}
