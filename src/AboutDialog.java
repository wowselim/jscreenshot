import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Label;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.net.URI;

class AboutDialog extends Dialog {
  Button ok  = new Button("Ok");
  Label text = new Label("This tool is a simple screenshot program written in Java");
  Label mail = new Label("wowselim@gmail.com");
  
  public AboutDialog() {
    super(new java.awt.Frame(), true);
    setTitle("About this tool...");
    setSize(350, 100);
    setLocationRelativeTo(null);
    setLayout(new java.awt.FlowLayout());
    add(text);
    add(mail);
    mail.setForeground(Color.blue);
    mail.setCursor(new Cursor(Cursor.HAND_CURSOR));
    add(ok);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        dispose();
      }
    });
    ok.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        dispose();
      }
    });
    mail.addMouseListener(new MouseListener() {
      public void mouseClicked(MouseEvent event) { }
      public void mousePressed(MouseEvent event) { }
      public void mouseReleased(MouseEvent event) {
        try {
          Desktop.getDesktop().mail(new URI("mailto:" + mail.getText()));
        } catch (Exception e) {
          e.printStackTrace(System.out);
        }
      }
      public void mouseExited(MouseEvent event) {
        mail.setForeground(Color.blue);
      }
      public void mouseEntered(MouseEvent event) {
        mail.setForeground(Color.red);
      }
    });
    setVisible(true);
  }
}
