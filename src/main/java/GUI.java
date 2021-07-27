import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JPanel menuPanel = new JPanel();
    JPanel basePanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel centerPanel = new JPanel();

    public GUI() {

        this.setTitle("Originote");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(true);
        this.setSize(640,480);
        this.setLayout(new BorderLayout(10,10));
        this.setVisible(true);

        ImageIcon image = new ImageIcon("Originote.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(Color.gray);

        //menuPanel.setBounds(0,0,640,100);
        menuPanel.setPreferredSize(new Dimension(640,100));
        menuPanel.setBackground(Color.pink);

        basePanel.setPreferredSize(new Dimension(640,100));
        basePanel.setBackground(Color.pink);

        leftPanel.setPreferredSize(new Dimension(100,100));
        leftPanel.setBackground(Color.lightGray);

        rightPanel.setPreferredSize(new Dimension(100,100));
        rightPanel.setBackground(Color.lightGray);

        centerPanel.setPreferredSize(new Dimension(80,80));
        centerPanel.setBackground(Color.white);

        this.add(menuPanel,BorderLayout.NORTH);
        this.add(basePanel,BorderLayout.SOUTH);
        this.add(leftPanel,BorderLayout.WEST);
        this.add(rightPanel,BorderLayout.EAST);
        this.add(centerPanel,BorderLayout.CENTER);

        this.validate();

    }

}
