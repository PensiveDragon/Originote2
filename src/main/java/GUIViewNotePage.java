import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUIViewNotePage extends JFrame implements ActionListener {

    ImageIcon image = new ImageIcon("Originote.png");
    Border simpleBorder = BorderFactory.createLineBorder(Color.black, 1);

    JPanel menuBarPanel = new JPanel();
    JPanel bodyPanel = new JPanel();

    JLabel originoteIconjLabel = new JLabel();
    JLabel titleLabel = new JLabel();
    JLabel bodyLabel = new JLabel();
    JLabel tagsLabel = new JLabel();

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
        this.add(bodyPanel,BorderLayout.CENTER);
        menuBarPanel.setPreferredSize(new Dimension(640,50));
        menuBarPanel.setBackground(Color.white);
        menuBarPanel.setLayout(new GridLayout(1,3, 5, 5));

        originoteIconjLabel.setIcon(new ImageIcon(originoteImage.getImage().getScaledInstance(130,50, Image.SCALE_DEFAULT)));
        originoteIconjLabel.setPreferredSize(new Dimension(130,50));
        originoteIconjLabel.setHorizontalAlignment(JLabel.CENTER);
        originoteIconjLabel.setVerticalAlignment(JLabel.CENTER);

        menuBarPanel.add(originoteIconjLabel);

        bodyPanel.setLayout(new FlowLayout());
        bodyPanel.add(titleLabel);
        bodyPanel.add(tagsLabel);
        bodyPanel.add(bodyLabel);
        bodyPanel.setBackground(Color.white);

        titleLabel.setPreferredSize(new Dimension(480, 40));
        titleLabel.setBackground(Color.white);
        titleLabel.setBorder(simpleBorder);

        tagsLabel.setPreferredSize(new Dimension(480, 40));
        tagsLabel.setBackground(Color.white);
        tagsLabel.setBorder(simpleBorder);

        bodyLabel.setPreferredSize(new Dimension(480, 160));
        bodyLabel.setBackground(Color.white);
        bodyLabel.setBorder(simpleBorder);

    }

    public void populateNoteDetails(int note_id) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();
        NoteContent noteContent = databaseHandler.findNoteDataByID(note_id);
        List<TagContent> tagContent = databaseHandler.findTagDataByID(note_id);
        this.setTitle("Originote - View Note: " + note_id);
        titleLabel.setText(noteContent.getTitle());
        tagsLabel.setText(guiFunctionHandler.assembleTagsString(note_id));
        bodyLabel.setText(noteContent.getBody());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
