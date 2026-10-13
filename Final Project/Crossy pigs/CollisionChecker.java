import java.awt.Rectangle;
import java.util.List;

public class CollisionChecker
{
    private Pig pig;
    private List<Zombie> zombies;
    private List<Skeleton> skeletons;
    private List<Creeper> creepers;
    private List<Spider> spiders;
    private GameInfo gameInfo;

    public CollisionChecker(Pig pig, List<Zombie> zombies, List<Skeleton> skeletons, List<Creeper> creepers, List<Spider> spiders, GameInfo gameInfo)
    {
        this.pig = pig;
        this.zombies = zombies;
        this.skeletons = skeletons;
        this.creepers = creepers;
        this.spiders = spiders;
        this.gameInfo = gameInfo;
    }

    public void checkCollisions()
    {
        Rectangle pigBounds = new Rectangle(pig.getX(), pig.getY(), pig.getSide(), pig.getSide());

        for (Zombie zombie : zombies)
        {
            if (pigBounds.intersects(new Rectangle(zombie.getX(), zombie.getY(), zombie.getSide(), zombie.getSide())))
            {
                gameInfo.reset();
                return;
            }
        }

        for (Skeleton skeleton : skeletons)
        {
            if (pigBounds.intersects(new Rectangle(skeleton.getX(), skeleton.getY(), skeleton.getSide(), skeleton.getSide())))
            {
                gameInfo.reset();
                return;
            }
        }

        for (Creeper creeper : creepers)
        {
            if (pigBounds.intersects(new Rectangle(creeper.getX(), creeper.getY(), creeper.getSide(), creeper.getSide())))
            {
                gameInfo.reset();
                return;
            }
        }

        for (Spider spider : spiders)
        {
            if (pigBounds.intersects(new Rectangle(spider.getX(), spider.getY(), spider.getSide(), spider.getSide())))
            {
                gameInfo.reset();
                return;
            }
        }
    }

    public void checkBounds()
    {
        if (pig.getX() < 0)
        {
            pig.setX(0);
        }
        else if (pig.getX() + pig.getSide() > GamePanel.WIDTH)
        {
            pig.setX(GamePanel.WIDTH - pig.getSide());
        }

        if (pig.getY() < 0)
        {
            pig.setY(0);
        }
        else if (pig.getY() + pig.getSide() > GamePanel.HEIGHT)
        {
            pig.setY(GamePanel.HEIGHT - pig.getSide());
        }
    }
}
