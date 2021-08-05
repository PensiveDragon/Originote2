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
    JLabel displayListLabel0 = new JLabel();
    JLabel displayListLabel1 = new JLabel();
    JLabel displayListLabel2 = new JLabel();
    JLabel displayListLabel3 = new JLabel();
    JLabel displayListLabel4 = new JLabel();
    JLabel displayListLabel5 = new JLabel();

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

        Border border = BorderFactory.createLineBorder(Color.black, 1);


        menuPanel.setPreferredSize(new Dimension(50,50));
        menuPanel.setBackground(Color.white);
        menuPanel.setLayout(null);

        basePanel.setPreferredSize(new Dimension(50,50));
        basePanel.setBackground(Color.white);

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

        //jSearchTextField.setPreferredSize(new Dimension(400,25));
        jSearchTextField.setBounds(10,10,480,25);
        jSearchTextField.setToolTipText("Search Bar");
        jSearchTextField.setText("Enter your search...");


        displayListPanel.setLayout(new GridLayout(6,1));
        displayListPanel.setBounds(10,50, 480,250);
        displayListPanel.add(displayListLabel0);
        displayListPanel.add(displayListLabel1);
        displayListPanel.add(displayListLabel2);
        displayListPanel.add(displayListLabel3);
        displayListPanel.add(displayListLabel4);
        displayListPanel.add(displayListLabel5);
        displayListPanel.setBorder(border);

        displayListLabel0.setText("Recent Notes:");
        displayListLabel0.setHorizontalAlignment(0);
        //displayListLabel0.setBorder(border);

        displayListLabel1.setText(" 1:");
        //displayListLabel1.setBorder(border);

        displayListLabel2.setText(" 2:");
        //displayListLabel2.setBorder(border);

        displayListLabel3.setText(" 3:");
        //displayListLabel3.setBorder(border);

        displayListLabel4.setText(" 4:");
        //displayListLabel4.setBorder(border);

        displayListLabel5.setText(" 5:");
        //displayListLabel5.setBorder(border);


        centerPanel.setLayout(null);
        centerPanel.add(jSearchTextField);
        centerPanel.add(displayListPanel);

        this.validate();

    }

}

/* ## look into tabbed panel / tabbed window */