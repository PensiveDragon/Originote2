import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JPanel menuPanel = new JPanel();

    public GUI() {

        menuPanel.setBackground(Color.red);
        menuPanel.setBounds(0,0, 60, 40);

        this.setSize(640,480);
        this.setTitle("Originote");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.getContentPane().setBackground(Color.gray);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("Originote.png");
        this.setIconImage(image.getImage());

        this.add(menuPanel);

    }


}
