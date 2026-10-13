import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;

public class Menu extends JPanel {
    private JFrame myOwner;
    private JPanel menuPanel;
    private HelpPanel helpPanel;
    private GamePanel gamePanel;
    private GamePlayer player;
    private BufferedImage myImage;

    public Menu(JFrame frame) {
        this.myOwner = frame;
        setLayout(new BorderLayout());
        setBackground(new Color(189, 215, 238));

        JPanel Panel = new JPanel();

        JLabel title = new JLabel("Welcome To Crossy Pig!");
        title.setFont(new Font("Serif", Font.BOLD, 60));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.CENTER);

       
        String playerName = JOptionPane.showInputDialog("Enter your name:");
        if (playerName == null || playerName.trim().isEmpty()) {
            System.exit(0);
        }
        player = new GamePlayer(playerName);

        helpPanel = new HelpPanel(frame);
        gamePanel = new GamePanel(frame, player);

        menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout());

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new Listener_PlayButton());
        playButton.setPreferredSize(new Dimension(220, 150));
        menuPanel.add(playButton);

        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(new Listener_HelpButton());
        helpButton.setPreferredSize(new Dimension(220, 150));
        menuPanel.add(helpButton);

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new Listener_QuitButton());
        quitButton.setPreferredSize(new Dimension(220, 150));
        menuPanel.add(quitButton);

        ImageIcon imageIcon = new ImageIcon("pig3.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        menuPanel.add(imageLabel, BorderLayout.NORTH);

        menuPanel.setBackground(new Color(189, 215, 238));

        add(menuPanel, BorderLayout.SOUTH);
    }

    private class Listener_PlayButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switchToGamePanel();
        }
    }

    private void switchToGamePanel() {
        removeAll();
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.requestFocusInWindow();
        revalidate();
        repaint();
        myOwner.pack();
    }

    private class Listener_HelpButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switchToHelpPanel();
        }
    }

    private void switchToHelpPanel() {
        removeAll();
        add(helpPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
        myOwner.pack();
    }

    private class Listener_QuitButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
