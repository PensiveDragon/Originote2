import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class GUISearchResultsPage extends JFrame implements ActionListener {

    GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();

    ImageIcon image = new ImageIcon("Originote.png");

    JPanel menuBarPanel = new JPanel();
    JPanel bodyPanel = new JPanel();

    JLabel originoteIconjLabel = new JLabel();

    Border simpleBorder = BorderFactory.createLineBorder(Color.black, 1);
    Border checkBorder = BorderFactory.createDashedBorder(Color.black);

    Font bodyFont = new Font("Default",Font.PLAIN,18);

    ImageIcon originoteImage = new ImageIcon("SimpleOriginoteLogo.png");

    public GUISearchResultsPage(String search_parameters) {
        this.setTitle("Originote - Search Results");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(640,480);
        this.setLayout(new BorderLayout(10, 10));
        this.setVisible(true);
        this.setIconImage(image.getImage());

    //### MENU BAR PANEL SETUP

        this.add(menuBarPanel, BorderLayout.NORTH);
        this.add(bodyPanel,BorderLayout.CENTER);
        menuBarPanel.setPreferredSize(new Dimension(640,50));
        menuBarPanel.setBackground(Color.white);
        menuBarPanel.setLayout(new GridLayout(1,3, 5, 5));

        originoteIconjLabel.setIcon(new ImageIcon(originoteImage.getImage().getScaledInstance(130,50, Image.SCALE_DEFAULT)));
        originoteIconjLabel.setPreferredSize(new Dimension(130,50));
        originoteIconjLabel.setHorizontalAlignment(JLabel.CENTER);
        originoteIconjLabel.setVerticalAlignment(JLabel.CENTER);

        menuBarPanel.add(originoteIconjLabel);

    //### BODY PANEL SETUP

        bodyPanel.setLayout(new FlowLayout());
        bodyPanel.setBackground(Color.white);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}