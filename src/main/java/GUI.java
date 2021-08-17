import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI extends JFrame {

    JPanel menuPanel = new JPanel();
    JPanel basePanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel displayListPanel = new JPanel();

    JLabel jLabel = new JLabel();
    JLabel displayListLabel0 = new JLabel();
    JLabel displayListLabel1 = new JLabel();
    JLabel displayListLabel2 = new JLabel();
    JLabel displayListLabel3 = new JLabel();
    JLabel displayListLabel4 = new JLabel();
    JLabel displayListLabel5 = new JLabel();

    ImageIcon image = new ImageIcon("Originote.png");
    ImageIcon originoteImage = new ImageIcon("SimpleOriginoteLogo.png");
    JTextField jSearchTextField = new JTextField();

    public GUI() {

        this.setTitle("Originote");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(true);
        this.setSize(640,480);
        this.setLayout(new BorderLayout(10,10));
        this.setVisible(true);


        this.setIconImage(image.getImage());

        //this.getContentPane().setBackground(Color.gray);

        Border border = BorderFactory.createLineBorder(Color.black, 1);


        menuPanel.setPreferredSize(new Dimension(50,50));
        menuPanel.setBackground(Color.white);
        menuPanel.setLayout(null);

        basePanel.setPreferredSize(new Dimension(50,50));
        basePanel.setBackground(Color.white);

        centerPanel.setPreferredSize(new Dimension(80,80));
        centerPanel.setBackground(Color.white);

        this.add(menuPanel,BorderLayout.NORTH);
        //this.add(basePanel,BorderLayout.SOUTH);
        //this.add(centerPanel,BorderLayout.CENTER);

        //jLabel.setText("Originote Logo");
        jLabel.setIcon(new ImageIcon(originoteImage.getImage().getScaledInstance(130,50, Image.SCALE_DEFAULT)));

        jLabel.setPreferredSize(new Dimension(130,50));
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);
        //jLabel.setBorder(border);
        //jLabel.setBackground(Color.pink);
        //jLabel.setOpaque(true);
        jLabel.setBounds(0,0,130,50);
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

/* Improve UI:
- Create Recent Notes module
 -> Heading Bar
 -> 5x rows of clickable entries with text space set 50/50 between title and tags list
- Create Search bar module
 -> TextField taking up most of the line. Fill text stating 'search titles or #searchtags'
 -> 'Search' button at the end
- Create Top bar module
 -> Originote Icon
 -> New Note Button
 -> List Notes Button
 */

/* ## look into tabbed panel / tabbed window
* Fill in recent notes list
* Add search button to end of search bar
* Add search button work functionality
* Add New Note Button
* Add new note button functionality
* Add List Notes Button
* Add List Notes Button functionality
* Make recent notes clickable to open in viewer
* */
