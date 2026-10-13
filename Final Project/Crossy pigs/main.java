import javax.swing.*;
import java.awt.*;

//SRAVYA GOGINENI & CERA KAMDAR

public class main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Crossy Pig Game");
        MusicPlayer musicPlayer = new MusicPlayer();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Menu menu = new Menu(frame);
        frame.setContentPane(menu);
        frame.getContentPane().setPreferredSize(new Dimension(900, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
     
    }
}
