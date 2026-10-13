import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GamePlayer {
    private String name;
    private int highScore;

    public GamePlayer(String name) {
        this.name = name;
        this.highScore = 0;
        loadHighScore();
    }

    private void loadHighScore() {
        try {
            File file = new File(name + ".txt");
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                if (scanner.hasNextInt()) {
                    highScore = scanner.nextInt();
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println("Error loading high score: " + e.getMessage());
        }
    }

    public void saveHighScore() {
        try {
            FileWriter writer = new FileWriter(name + ".txt");
            writer.write(String.valueOf(highScore));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving high score: " + e.getMessage());
        }
    }

    public void updateHighScore(int score) {
        if (score > highScore) {
            highScore = score;
            saveHighScore();
        }
    }

    public String getName() {
        return name;
    }

    public int getHighScore() {
        return highScore;
    }
}

