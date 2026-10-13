public class GameInfo
{
    private int score;
    private int highScore;
    private int deaths;
    private Pig pig;
    private final int INITIAL_X;
    private final int INITIAL_Y;

    public GameInfo(Pig pig)
    {
        this.score = 0;
        this.highScore = 0;
        this.deaths = 0;
        this.pig = pig;
        this.INITIAL_X = pig.getX();
        this.INITIAL_Y = pig.getY();
    }

    public void reset()
    {
        deaths++;
        score = 0;
        pig.setX(INITIAL_X);
        pig.setY(INITIAL_Y);
    }

    public void updateScore()
    {
        if (pig.getY() < 20)
        {
            score++;
            if (score > highScore)
            {
                highScore = score;
            }
            pig.setX(INITIAL_X);
            pig.setY(INITIAL_Y);
        }
    }

    public int getScore()
    {
        return score;
    }

    public int getHighScore()
    {
        return highScore;
    }

    public int getDeaths()
    {
        return deaths;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public void setHighScore(int highScore)
    {
        this.highScore = highScore;
    }

    public void setDeaths(int deaths)
    {
        this.deaths = deaths;
    }
}

