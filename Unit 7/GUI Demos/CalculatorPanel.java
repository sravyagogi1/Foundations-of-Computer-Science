import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CalculatorPanel extends JPanel {
   //defining things
   JLabel number;  
   JTextField userIn1;
   JTextField userIn2;
   double num;

   public CalculatorPanel() {
      setLayout(new BorderLayout());
        
      //text  
      JLabel title = new JLabel("A Simple Calculator!");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
        
      //number displayed  
      num = 0;
      number = new JLabel("" + num);
      number.setFont(new Font("Serif", Font.BOLD, 80));
      number.setHorizontalAlignment(SwingConstants.CENTER);
      add(number);
        
      //text ontop user input boxes
      JLabel inputLabel = new JLabel("Enter a number:");
      inputLabel.setHorizontalAlignment(SwingConstants.CENTER);
      
      // Panel for first user input
      JPanel inputPanel1 = new JPanel(new BorderLayout());
      inputPanel1.add(inputLabel, BorderLayout.NORTH);
      
      //text to diaplsy in user input box  
      userIn1 = new JTextField("0", 10); 
      userIn1.setHorizontalAlignment(JTextField.CENTER); 
      inputPanel1.add(userIn1, BorderLayout.CENTER);
        
      // Add inputPanel1 to the west of the main panel
      add(inputPanel1, BorderLayout.WEST);
      
      //adding operation panel  
      JPanel southSubpanel = new JPanel();
      southSubpanel.setLayout(new GridLayout(1,4));
      
      //adding opertion buttons  
      JButton add = new JButton("Add");
      add.addActionListener(new AddListener());
      southSubpanel.add(add);  
        
      JButton subtract = new JButton("Subtract");
      subtract.addActionListener(new SubtractListener());
      southSubpanel.add(subtract);  
        
      JButton multiply = new JButton("Multiply");
      multiply.addActionListener(new MultiplyListener());
      southSubpanel.add(multiply);  
        
      JButton divide = new JButton("Divide");
      divide.addActionListener(new DivideListener());
      southSubpanel.add(divide);  
      
      //adding other user input panel
      add(southSubpanel, BorderLayout.SOUTH);
        
      JPanel eastSubpanel = new JPanel(new BorderLayout());
      
      //text above box
      JLabel inputLabel2 = new JLabel("Enter a number:");
      inputLabel2.setHorizontalAlignment(SwingConstants.CENTER);
      eastSubpanel.add(inputLabel2, BorderLayout.NORTH); // Ensure the label is added to the NORTH position
      
      //text inside box
      userIn2 = new JTextField("0", 10);
      userIn2.setHorizontalAlignment(JTextField.CENTER);
      eastSubpanel.add(userIn2, BorderLayout.CENTER); // Add the text field to the CENTER position

      // Add the eastSubpanel to the main panel
      add(eastSubpanel, BorderLayout.EAST);
   }   
   
   //classes for each buttons function   
   private class AddListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         double newVal1 = Double.parseDouble(userIn1.getText());
         double newVal2 = Double.parseDouble(userIn2.getText());
         num = newVal1 + newVal2;
         number.setText("" + num);
      }
   }
   
   private class SubtractListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         double newVal1 = Double.parseDouble(userIn1.getText());
         double newVal2 = Double.parseDouble(userIn2.getText());
         num = newVal1 - newVal2;
         number.setText("" + num);
      }
   }
   
   private class MultiplyListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         double newVal1 = Double.parseDouble(userIn1.getText());
         double newVal2 = Double.parseDouble(userIn2.getText());
         num = newVal1 * newVal2;
         number.setText("" + num);
      }
   }
   
   private class DivideListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         double newVal1 = Double.parseDouble(userIn1.getText());
         double newVal2 = Double.parseDouble(userIn2.getText());
         num = newVal1 / newVal2;
         number.setText("" + num);
      }
   }
}