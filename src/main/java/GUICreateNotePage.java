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
    JTextField titleTextFieldLabel = new JTextField();
    JTextField tagsTextFieldLabel = new JTextField();
    JTextField bodyTextFieldLabel = new JTextField();

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
        bodyPanel.add(titleTextFieldLabel);
        bodyPanel.add(tagsTextFieldLabel);
        bodyPanel.add(bodyTextFieldLabel);
        bodyPanel.setBackground(Color.white);

        titleTextFieldLabel.setPreferredSize(new Dimension(480, 48));
        titleTextFieldLabel.setBackground(Color.white);
        titleTextFieldLabel.setBorder(simpleBorder);
        titleTextFieldLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleTextFieldLabel.setFont(bodyFont);
        titleTextFieldLabel.setText("Title Goes Here");

        tagsTextFieldLabel.setPreferredSize(new Dimension(480, 30));
        tagsTextFieldLabel.setBackground(Color.white);
        tagsTextFieldLabel.setBorder(simpleBorder);
        tagsTextFieldLabel.setFont(bodyFont);
        tagsTextFieldLabel.setText("Tags Go Here");

        bodyTextFieldLabel.setPreferredSize(new Dimension(480, 210));
        bodyTextFieldLabel.setBackground(Color.white);
        bodyTextFieldLabel.setBorder(simpleBorder);
        bodyTextFieldLabel.setFont(bodyFont);
        bodyTextFieldLabel.setText("Note Goes Here");

        //TODO: confirm note button
        //TODO: scrap note button
        //TODO: Auto clear ghost text
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
