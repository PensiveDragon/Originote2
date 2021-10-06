import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUICreateNotePage extends JFrame implements ActionListener {

    ImageIcon image = new ImageIcon("Originote.png");

    JPanel menuBarPanel = new JPanel();
    JPanel bodyPanel = new JPanel();

    JLabel originoteIconjLabel = new JLabel();
    JLabel titleFieldLabel = new JLabel();
    JLabel tagsFieldLabel = new JLabel();
    JLabel bodyFieldLabel = new JLabel();

    Border simpleBorder = BorderFactory.createLineBorder(Color.black, 1);
    Border checkBorder = BorderFactory.createDashedBorder(Color.black);

    Font bodyFont = new Font("Default",Font.PLAIN,18);

    ImageIcon originoteImage = new ImageIcon("SimpleOriginoteLogo.png");

    public GUICreateNotePage() {
        this.setTitle("Originote - Create New Note");
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
        bodyPanel.add(titleFieldLabel);
        bodyPanel.add(tagsFieldLabel);
        bodyPanel.add(bodyFieldLabel);
        bodyPanel.setBackground(Color.white);

        titleFieldLabel.setPreferredSize(new Dimension(480, 48));
        titleFieldLabel.setBackground(Color.white);
        titleFieldLabel.setBorder(simpleBorder);
        titleFieldLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleFieldLabel.setFont(bodyFont);
        titleFieldLabel.setText("Title Goes Here");

        tagsFieldLabel.setPreferredSize(new Dimension(480, 30));
        tagsFieldLabel.setBackground(Color.white);
        tagsFieldLabel.setBorder(simpleBorder);
        tagsFieldLabel.setFont(bodyFont);
        tagsFieldLabel.setText("Tags Go Here");

        bodyFieldLabel.setPreferredSize(new Dimension(480, 210));
        bodyFieldLabel.setBackground(Color.white);
        bodyFieldLabel.setBorder(simpleBorder);
        bodyFieldLabel.setVerticalAlignment(SwingConstants.TOP);
        bodyFieldLabel.setFont(bodyFont);
        bodyFieldLabel.setText("Note Goes Here");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
