import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

public class PanelSwapDemo
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Panel Swapping Demo");
      //frame.setSize(600, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new PanelSwapPanel(frame));  //Pass "frame" to PanelSwapPanel so it can give frame commands (!)
      frame.pack();  //Allow PanelSwapPanel to decide the size
      frame.setVisible(true);
   }
}

class PanelSwapPanel extends JPanel
{
   private JFrame myOwner;  //The JFrame that contains this panel (!)
   
   private SwapperOne subOne;  //A subpanel that will get swapped out for...
   private SwapperTwo subTwo;  //...a different subpanel
   
   public PanelSwapPanel(JFrame f)
   {
      myOwner = f;  //Store a reference to the JFrame that I belong to (!)
      
      //Add some text in the north
      setLayout(new BorderLayout());
      add(new JLabel("How to swap one subpanel for another"), BorderLayout.NORTH);
      
      //Make and add first subpanel
      subOne = new SwapperOne(this);  //Pass **MYSELF** to SwapperOne (!)
      add(subOne);
      
      subTwo = new SwapperTwo();
      //We **don't** add subTwo!  Just make sure it's ready.
   }
   public void switchSubpanels()
   {
      //All of these commands are necessary, in this order, to remove a subpanel,
      //add another one, then cause the JFrame to figure itself out again, including
      //resizing if necessary.  If you leave something out, you'll get weird behavior.
      remove(subOne);
      add(subTwo);
      repaint();
      revalidate();
      myOwner.pack();  //Again, note - I'm giving the JFrame that contains this panel a command! (!)
   }
}

class SwapperOne extends JPanel
{
   private PanelSwapPanel myOwner;  //The PanelSwapPanel that contains this panel (!)
   
   public SwapperOne(PanelSwapPanel p)
   {
      myOwner = p;  //Store a reference to the PanelSwapPanel that I belong to (!)
      
      setPreferredSize(new Dimension(300, 300)); //Set size here.
            
      setLayout(new GridLayout(2, 1));
      
      add(new JLabel("Press this button to swap panels:"));
      JButton switcheroo = new JButton("Click me!");
      switcheroo.addActionListener(new SwitchListener());
      add(switcheroo);
   }
   
   private class SwitchListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         myOwner.switchSubpanels();  //Send a command to the PanelSwapPanel that contains this one (!)
      }
   }
}

class SwapperTwo extends JPanel
{
   public SwapperTwo()
   {
      setPreferredSize(new Dimension(400, 400));  //Different size!
      setLayout(new GridLayout(1, 1));
      add(new JLabel("This is a different subpanel with a different size!"));
   }
}