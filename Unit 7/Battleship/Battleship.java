//Name: Sravya Gogineni     Date: April 19th, 2024

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Battleship extends JPanel
{
    // Game components
    private JButton[][] board; // Grid of buttons
    private int[][] matrix; // Matrix representing the location of the battleship
    private int hits, torpedoes;
    private JLabel label;
    private JButton reset; // resets the game
    private final int N = 10; // Size of game board

    // Constructor
    public Battleship()
    {
        //Layot
        setLayout(new BorderLayout());
        hits = 0;
        torpedoes = 0;

        // components
        JPanel north = new JPanel(); // Panel for label at the top
        north.setLayout(new FlowLayout());
        add(north, BorderLayout.NORTH);
        label = new JLabel("Welcome to Battleship -- You have 20 torpedoes.");
        north.add(label);

        JPanel center = new JPanel(); // Panel for game board
        center.setLayout(new GridLayout(N, N));
        add(center, BorderLayout.CENTER);

        // Initialize game board
        board = new JButton[N][N];
        matrix = new int[N][N];
        for (int r = 0; r < N; r++)
        {
            for (int c = 0; c < N; c++)
            {
                board[r][c] = new JButton();
                board[r][c].setOpaque(true);
                board[r][c].setBorderPainted(true);
                board[r][c].setBackground(Color.BLUE);
                board[r][c].addActionListener(new Handler1(r, c)); // Add action listener
                center.add(board[r][c]); // Add button to panel
            }
        }

        // Add reset button
        reset = new JButton("Reset");
        reset.addActionListener(new Handler2());
        reset.setEnabled(true);
        add(reset, BorderLayout.SOUTH);

        // Place battleship randomly
        placeShip();
    }

    // Method to randomly place battleship
    public void placeShip()
    {
        int coin = (int) (Math.random() * 2);
        int startRow, startCol;
        if (coin == 0)
        { // Vertical placement
            startRow = (int) (Math.random() * (N - 3)); // Ensure ship fits vertically
            startCol = (int) (Math.random() * N);
            for (int i = 0; i < 4; i++)
            {
                matrix[startRow + i][startCol] = 1; // Update matrix to indicate battleship positio
            }
        }
        else
        { // Horizontal placement
            startRow = (int) (Math.random() * N);
            startCol = (int) (Math.random() * (N - 3)); // Ensure ship fits horizontally
            for (int i = 0; i < 4; i++)
            {
                matrix[startRow][startCol + i] = 1; // Update matrix to indicate battleship position
            }
        }
    }

    // Action listener for game board buttons
    private class Handler1 implements ActionListener
    {
        private int myRow, myCol;

        public Handler1(int r, int c)
        {
            myRow = r;
            myCol = c;
        }

        public void actionPerformed(ActionEvent e)
        {
            if (matrix[myRow][myCol] == 1) { // Hit
                board[myRow][myCol].setBackground(Color.RED);
                hits++;
                label.setText("Hit! " + (20 - (torpedoes + 1)) + " torpedoes remaining.");
            } else { // Miss
                board[myRow][myCol].setBackground(Color.WHITE);
                label.setText("Miss! " + (20 - (torpedoes + 1)) + " torpedoes remaining.");
            }
            torpedoes++;
            board[myRow][myCol].setEnabled(false);
            if (hits == 4) { // User wins
                label.setText("You sunk my battleship!");
                disableAllButtons(); // Disable all buttons
            } else if (torpedoes == 20) { // User loses
                revealShip(); // Reveal battleship
                disableAllButtons(); // Disable all buttons
            }
        }
    }

    // Action listener for reset button
    private class Handler2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            resetGame(); // Reset game
        }
    }

    // Method to reset the game
    public void resetGame()
    {
        hits = 0;
        torpedoes = 0;
        label.setText("Welcome to Battleship -- You have 20 torpedoes.");
        // Reset game board
        for (int r = 0; r < N; r++)
        {
            for (int c = 0; c < N; c++)
            {
                matrix[r][c] = 0;
                board[r][c].setBackground(Color.BLUE);
                board[r][c].setEnabled(true);
            }
        }
        placeShip(); // Place battleship again
    }

    // Method to disable all buttons
    public void disableAllButtons()
    {
        for (int r = 0; r < N; r++)
        {
            for (int c = 0; c < N; c++)
            {
                board[r][c].setEnabled(false);
            }
        }
    }
    

    // Method to reveal battleship
    public void revealShip()
    {
        for (int r = 0; r < N; r++)
        {
            for (int c = 0; c < N; c++)
            {
                if (matrix[r][c] == 1)
                {
                    board[r][c].setBackground(Color.BLACK);
                    board[r][c].setEnabled(false);
                }
            }
        }
    }
}
