import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
public class MusicPlayer
{
   private Clip clip;
   
   public void playBackgroundMusic(String filePath)
   {
      try
      {
         File musicPath = new File(filePath);
         System.out.println("File path: " + filePath);
         if (musicPath.exists())
         {
            System.out.println("File found. Playing music...");
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
         }
         else
         {
            System.out.println("Can't find file");
         }
      }
      catch (UnsupportedAudioFileException e)
      {
         System.err.println("Unsupported audio file format: " + e.getMessage());
      }
      catch (IOException e)
      {
         System.err.println("I/O error while playing audio: " + e.getMessage());
      }
      catch (LineUnavailableException e)
      {
         System.err.println("Audio line unavailable: " + e.getMessage());
      }
   }

   public void stopBackgroundMusic() {
      if (clip != null && clip.isRunning()) {
         clip.stop();
      }
   }
}