import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {
   public static final int WIDTH = 800;
   public static final int HEIGHT = 600;

   private JFrame myOwner;
   private int[][] gameWorld;
   private Pig pig;
   private List<Zombie> zombies;
   private List<Skeleton> skeletons;
   private List<Creeper> creepers;
   private List<Spider> spiders;
   private GamePlayer player;

   private BufferedImage myImage;
   private Graphics myBuffer;

   private CollisionChecker collisionChecker;
   private GameInfo gameInfo;
   private Color gameInfoColor;

   public GamePanel(JFrame owner, GamePlayer player) {
      this.player = player;
      myImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(Color.WHITE);
      myBuffer.fillRect(0, 0, WIDTH, HEIGHT);
  
      this.myOwner = owner;
      setLayout(new BorderLayout());
  
      initializeGameWorld();
  
      JButton backButton = new JButton("Back");
      backButton.addActionListener(new Listener_BackButton());
      add(backButton, BorderLayout.SOUTH);
  
      pig = new Pig(80, 315, 505, Color.PINK);
      
  
      zombies = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
         zombies.add(new Zombie(50, i * 300, 100, Color.GREEN));
      }
  
      skeletons = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
         skeletons.add(new Skeleton(50, i * 300, 350, Color.WHITE));
      }
  
      creepers = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
         creepers.add(new Creeper(50, WIDTH - i * 300, 200, Color.GREEN));
      }
  
      spiders = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
         spiders.add(new Spider(50, WIDTH - i * 300, 450, Color.BLACK));
      }
  
      addKeyListener(new Key());
      setFocusable(true);
  
      gameInfo = new GameInfo(pig);
      gameInfoColor = Color.BLACK;
      collisionChecker = new CollisionChecker(pig, zombies, skeletons, creepers, spiders, gameInfo);
  
      addMouseListener(
         new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               changeGameInfoColor();
               repaint();
            }
         });
  
      Timer timer = new Timer(25,
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               for (Zombie zombie : zombies) {
                  zombie.step();
                  if (zombie.getX() > WIDTH) {
                     zombie.setX(0);
                  }
               }
           
               for (Skeleton skeleton : skeletons) {
                  skeleton.step();
                  if (skeleton.getX() > WIDTH) {
                     skeleton.setX(0);
                  }
               }
           
               for (Creeper creeper : creepers) {
                  creeper.step();
                  if (creeper.getX() < -creeper.getSide()) {
                     creeper.setX(WIDTH);
                  }
               }
           
               for (Spider spider : spiders) {
                  spider.step();
                  if (spider.getX() < -spider.getSide()) {
                     spider.setX(WIDTH);
                  }
               }
           
               collisionChecker.checkCollisions();
               collisionChecker.checkBounds();
           
               gameInfo.updateScore();
               player.updateHighScore(gameInfo.getScore());
           
               repaint();
            }
         });
      timer.start();
   }

   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      drawMap(g);
      pig.draw(g, this);
      for (Zombie zombie : zombies) {
         zombie.draw(g, this);
      }
      for (Skeleton skeleton : skeletons) {
         skeleton.draw(g, this);
      }
      for (Creeper creeper : creepers) {
         creeper.draw(g, this);
      }
      for (Spider spider : spiders) {
         spider.draw(g, this);
      }
  
      g.setColor(gameInfoColor);
      g.setFont(new Font("Arial", Font.BOLD, 24));
      g.drawString("Score: " + gameInfo.getScore(), 10, 40);
      g.drawString("High Score: " + player.getHighScore(), 430, 40);
      g.drawString("Deaths: " + gameInfo.getDeaths(), 780, 40);
   }
  
   private void drawMap(Graphics g) {
      g.setColor(new Color(155, 237, 114));
      g.fillRect(0, 0, 900, 900);
  
      g.setColor(new Color(114, 115, 112));
      g.fillRect(0, 100, 900, 150);
      g.fillRect(0, 350, 900, 150);
  
      g.setColor(Color.WHITE);
      for (int x = 0; x < 900; x += 40) {
         g.drawLine(x, 175, x + 20, 175);
         g.drawLine(x, 425, x + 20, 425);
      }
   }
   private void changeGameInfoColor() {
      Random rand = new Random();
      gameInfoColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
   }

   private class Listener_BackButton implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         myOwner.getContentPane().removeAll();
         myOwner.getContentPane().add(new Menu(myOwner));
         myOwner.getContentPane().revalidate();
         myOwner.getContentPane().repaint();
         myOwner.pack();
      }
   }

   private void initializeGameWorld() {
      gameWorld = new int[10][10];
      for (int i = 0; i < 10; i++) {
         for (int j = 0; j < 10; j++) {
            gameWorld[i][j] = 0;
         }
      }
   }

   private class Key extends KeyAdapter {
      public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            pig.setX(pig.getX() - 50);
         } else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            pig.setX(pig.getX() + 50);
         } else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            pig.setY(pig.getY() - 50);
         } else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            pig.setY(pig.getY() + 50);
         }
         repaint();
      }
   }
}
