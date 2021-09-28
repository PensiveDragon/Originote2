import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIViewNotePage extends JFrame implements ActionListener {

    ImageIcon image = new ImageIcon("Originote.png");

    public GUIViewNotePage(int note_id) {
        this.setTitle("Originote - View Note: " + note_id);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(640,480);
        this.setLayout(new BorderLayout(10, 10));
        this.setVisible(true);
        this.setIconImage(image.getImage());


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
