import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MainPanel extends JPanel
{
    private TJStudent student;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField yearField;
    private JTextField fileField;

    public MainPanel()
    {
        student = new TJStudent("Audrey", 14, "Freshman");

        nameField = new JTextField(20);
        ageField = new JTextField(3);
        yearField = new JTextField(20);
        fileField = new JTextField("filename.txt", 20);

        nameField.setText(student.getName());
        ageField.setText(Integer.toString(student.getAge()));
        yearField.setText(student.getYear());

        JButton showButton = new JButton("Show current values");
        showButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                nameField.setText(student.getName());
                ageField.setText(Integer.toString(student.getAge()));
                yearField.setText(student.getYear());
            }
        });

        JButton modifyButton = new JButton("Modify fields as shown");
        modifyButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                student.setName(nameField.getText());
                student.setAge(Integer.parseInt(ageField.getText()));
                student.setYear(yearField.getText());
            }
        });

        JButton saveButton = new JButton("Save to file");
        saveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    saveToFile(fileField.getText());
                }
                catch (IOException ex)
                {
                    showError(ex);
                }
            }
        });

        JButton loadButton = new JButton("Load from file");
        loadButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    loadFromFile(fileField.getText());
                }
                catch (IOException ex)
                {
                    showError(ex);
                }
            }
        });

        setLayout(new GridLayout(6, 2));
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Year:"));
        add(yearField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Save/Load:"));
        add(fileField);
        add(showButton);
        add(modifyButton);
        add(saveButton);
        add(loadButton);
    }

    private void saveToFile(String fileName) throws IOException
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName)))
        {
            writer.println(student.getName());
            writer.println(student.getAge());
            writer.println(student.getYear());
        }
    }

    private void loadFromFile(String fileName) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            student.setName(reader.readLine());
            student.setAge(Integer.parseInt(reader.readLine()));
            student.setYear(reader.readLine());
            nameField.setText(student.getName());
            ageField.setText(Integer.toString(student.getAge()));
            yearField.setText(student.getYear());
        }
    }

    private void showError(Exception ex)
    {
        System.out.println("Error: " + ex.getMessage());
    }
}


public class TJStudent
{
    private String name;
    private int age;
    private String year;

    public TJStudent(String name, int age, String year)
    {
        this.name = name;
        this.age = age;
        this.year = year;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getYear()
    {
        return year;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setYear(String year)
    {
        this.year = year;
    }
}


