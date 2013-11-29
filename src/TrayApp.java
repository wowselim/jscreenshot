import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.net.ServerSocket;

class TrayApp {
  MenuItem exit   = new MenuItem("Exit");
  MenuItem shot   = new MenuItem("Take Screenshot");
  MenuItem about  = new MenuItem("About...");
  SystemTray tray = SystemTray.getSystemTray();
  PopupMenu menu  = new PopupMenu();
  Image trayImage = Toolkit.getDefaultToolkit().getImage("trayicon.png");
  TrayIcon icon   = new TrayIcon(trayImage, "Screenshot!", menu);
  
  public TrayApp() {
    exit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });
    shot.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        new ScreenShot();
      }
    });
    about.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        new AboutDialog();
      }
    });
    menu.add(shot);
    menu.add(about);
    menu.add(exit);
    
    try {
      ServerSocket singleInstance = new ServerSocket(1234);
      tray.add(icon);
    } catch (AWTException | IOException e) {
      e.printStackTrace(System.out);
      System.exit(0);
    }
  }
  
  public static void main(String[] args) {
    new TrayApp();    
  }
}
