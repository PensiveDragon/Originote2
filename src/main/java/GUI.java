import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI extends JFrame {

    JPanel menuPanel = new JPanel();
    JPanel basePanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel displayListPanel = new JPanel();

    JLabel jLabel = new JLabel();

    JTextField jSearchTextField = new JTextField();

    public GUI() {

        this.setTitle("Originote");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(true);
        this.setSize(640,480);
        this.setLayout(new BorderLayout(10,10));
        this.setVisible(true);

        ImageIcon image = new ImageIcon("Originote.png");
        this.setIconImage(image.getImage());
        //this.getContentPane().setBackground(Color.gray);

        Border border = BorderFactory.createLineBorder(Color.GREEN, 3);


        menuPanel.setPreferredSize(new Dimension(50,50));
        menuPanel.setBackground(Color.pink);
        menuPanel.setLayout(null);

        basePanel.setPreferredSize(new Dimension(50,50));
        basePanel.setBackground(Color.pink);

        leftPanel.setPreferredSize(new Dimension(50,50));
        leftPanel.setBackground(Color.lightGray);

        rightPanel.setPreferredSize(new Dimension(50,50));
        rightPanel.setBackground(Color.lightGray);

        centerPanel.setPreferredSize(new Dimension(80,80));
        centerPanel.setBackground(Color.white);

        this.add(menuPanel,BorderLayout.NORTH);
        this.add(basePanel,BorderLayout.SOUTH);
        this.add(leftPanel,BorderLayout.WEST);
        this.add(rightPanel,BorderLayout.EAST);
        this.add(centerPanel,BorderLayout.CENTER);

        jLabel.setText("Originote Logo");
        jLabel.setPreferredSize(new Dimension(50,50));
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);
        jLabel.setBorder(border);
        //jLabel.setBackground(Color.pink);
        //jLabel.setOpaque(true);
        jLabel.setBounds(0,0,200,50);
        menuPanel.add(jLabel);

        jSearchTextField.setPreferredSize(new Dimension(400,25));
        displayListPanel.setLayout(new GridLayout(5,1));
        displayListPanel.setBorder(border);

        //centerPanel.setLayout(null);
        centerPanel.add(jSearchTextField);
        centerPanel.add(displayListPanel);

        this.validate();

    }

}
