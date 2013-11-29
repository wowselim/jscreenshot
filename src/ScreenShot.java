import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.imageio.ImageIO;

import java.io.File;

class ScreenShot {
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  Robot robot          = null;
  Rectangle screenRect = new Rectangle(0, 0, (int) screenSize.getWidth(), (int) screenSize.getHeight());
  Image img            = null;
  
  File screenShotDir   = new File("screenshots");
  File screenShotFile  = new File("screenshots/screenshot.png");
  
  public ScreenShot() {
    try {
      robot = new Robot();
      img = robot.createScreenCapture(screenRect);
      screenShotDir.mkdir();
      screenShotFile.createNewFile();
      ImageIO.write((BufferedImage) img, "png", screenShotFile);
      Desktop.getDesktop().open(screenShotDir);
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
}
