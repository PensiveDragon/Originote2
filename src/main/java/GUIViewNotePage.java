import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIViewNotePage extends JFrame implements ActionListener {

    ImageIcon image = new ImageIcon("Originote.png");
    JPanel menuBarPanel = new JPanel();
    JPanel bodyPanel = new JPanel();
    JLabel originoteIconjLabel = new JLabel();
    ImageIcon originoteImage = new ImageIcon("SimpleOriginoteLogo.png");


    public GUIViewNotePage(int note_id) {
        //this.setTitle("Originote - View Note: " + note_id);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(640,480);
        this.setLayout(new BorderLayout(10, 10));
        this.setVisible(true);
        this.setIconImage(image.getImage());

        populateNoteDetails(note_id);

        //### MENU BAR PANEL SETUP

        this.add(menuBarPanel,BorderLayout.NORTH);
        menuBarPanel.setPreferredSize(new Dimension(640,50));
        menuBarPanel.setBackground(Color.white);
        menuBarPanel.setLayout(new GridLayout(1,3, 5, 5));

        originoteIconjLabel.setIcon(new ImageIcon(originoteImage.getImage().getScaledInstance(130,50, Image.SCALE_DEFAULT)));
        originoteIconjLabel.setPreferredSize(new Dimension(130,50));
        originoteIconjLabel.setHorizontalAlignment(JLabel.CENTER);
        originoteIconjLabel.setVerticalAlignment(JLabel.CENTER);


        menuBarPanel.add(originoteIconjLabel);

        bodyPanel.setLayout(new BorderLayout(10,10));

    }

    public void populateNoteDetails(int note_id) {
        this.setTitle("Originote - View Note: " + note_id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
