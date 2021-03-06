import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class GUIViewNotePage extends JFrame implements ActionListener {

    GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();

    ImageIcon image = new ImageIcon("Originote.png");
    Border simpleBorder = BorderFactory.createLineBorder(Color.black, 1);
    Border checkBorder = BorderFactory.createDashedBorder(Color.black);
    Font titleFont = new Font("Default",Font.BOLD,24);
    Font tagsFont = new Font("Default",Font.ITALIC,18);
    Font bodyFont = new Font("Default",Font.PLAIN,18);

    NoteContent currentNoteContent;
    List<TagContent> currentTagContents;
    String[] currentStringTagContents;

    JPanel menuBarPanel = new JPanel();
    JPanel bodyPanel = new JPanel();
    JPanel menuBarSubPanel = new JPanel();

    JLabel originoteIconjLabel = new JLabel();
    JLabel titleLabel = new JLabel();
    JTextArea bodyLabel = new JTextArea();
    JLabel tagsLabel = new JLabel();
    JLabel spacerLabel = new JLabel();

    JScrollPane scrollPane = new JScrollPane(bodyLabel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JButton editNoteButton = new JButton();
    JButton deleteNoteButton = new JButton();

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

        menuBarSubPanel.setLayout(new GridLayout(1,2, 5, 5));
        menuBarSubPanel.setBackground(Color.WHITE);

        originoteIconjLabel.setIcon(new ImageIcon(originoteImage.getImage().getScaledInstance(130,50, Image.SCALE_DEFAULT)));
        originoteIconjLabel.setPreferredSize(new Dimension(130,50));
        originoteIconjLabel.setHorizontalAlignment(JLabel.CENTER);
        originoteIconjLabel.setVerticalAlignment(JLabel.CENTER);

        editNoteButton.setText("Edit Note");
        editNoteButton.setBackground(Color.WHITE);
        editNoteButton.setFocusable(false);
        editNoteButton.addActionListener(e -> {
            System.out.println("Edit Button Clicked!");
            guiFunctionHandler.openNewCreateNotePage(sendNoteDetails(note_id));
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        deleteNoteButton.setText("Delete Note");
        deleteNoteButton.setBackground(Color.WHITE);
        deleteNoteButton.setFocusable(false);
        deleteNoteButton.addActionListener(e -> {
            System.out.println("Delete Button Clicked");
            System.out.println("Deleting note: " + note_id);
            new GUIFunctionHandler().deleteNote(note_id);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        menuBarPanel.add(originoteIconjLabel);
        //menuBarPanel.add(spacerLabel);
        menuBarPanel.add(menuBarSubPanel);

        menuBarSubPanel.add(editNoteButton);
        menuBarSubPanel.add(deleteNoteButton);

        bodyPanel.setLayout(new FlowLayout());
        bodyPanel.add(titleLabel);
        bodyPanel.add(tagsLabel);
        bodyPanel.add(bodyLabel);
        bodyPanel.setBackground(Color.white);

        titleLabel.setPreferredSize(new Dimension(480, 48));
        titleLabel.setBackground(Color.white);
        //titleLabel.setBorder(simpleBorder);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(titleFont);

        tagsLabel.setPreferredSize(new Dimension(480, 30));
        tagsLabel.setBackground(Color.white);
        //tagsLabel.setBorder(simpleBorder);
        tagsLabel.setFont(tagsFont);

        bodyLabel.setPreferredSize(new Dimension(480, 210));
        bodyLabel.setBackground(Color.white);
        bodyLabel.setBorder(checkBorder);
        //bodyLabel.setVerticalAlignment(SwingConstants.TOP);
        bodyLabel.setFont(bodyFont);
        bodyLabel.setLineWrap(true);
        bodyLabel.setWrapStyleWord(true);

    }

    public void populateNoteDetails(int note_id) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();
        NoteContent noteContent = databaseHandler.findNoteDataByID(note_id);
        List<TagContent> tagContent = databaseHandler.findTagDataByID(note_id);
        this.setTitle("Originote - View Note: " + noteContent.getTitle());
        titleLabel.setText(noteContent.getTitle());
        tagsLabel.setText(guiFunctionHandler.assembleTagsString(note_id));
        bodyLabel.setText(noteContent.getBody());
    }

    public NoteContent sendNoteDetails(int note_id) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        return currentNoteContent = databaseHandler.findNoteDataByID(note_id);
    }

    public List<TagContent> sendTagDetails(int note_id) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        return currentTagContents = databaseHandler.findTagDataByID(note_id);
    }

    public String[] sendStringTagDetails(int note_id) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        return currentStringTagContents = databaseHandler.findTagsByID(note_id);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

//    ## View Note Page To Do: ##
//TODO: Fully implement edit note button. Passes note_id reference to CreateNotePage.
//TODO: Fully implement delete note button (and additional confirmation?). Calls relevant deletion functions from Database Handler.
//TODO: Look at changing the window size and arrangement to be more 'note card' size.
