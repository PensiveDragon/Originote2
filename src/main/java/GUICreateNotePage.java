import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.List;

public class GUICreateNotePage extends JFrame implements ActionListener {

    GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();

    ImageIcon image = new ImageIcon("Originote.png");

    JPanel menuBarPanel = new JPanel();
    JPanel bodyPanel = new JPanel();
    JPanel menuBarSubPanel = new JPanel();

    JLabel originoteIconjLabel = new JLabel();
    JLabel blankSpacer = new JLabel();

    JButton saveNoteButton = new JButton();
    JButton discardNoteButton = new JButton();

    JTextField titleTextFieldLabel = new JTextField();
    JTextField tagsTextFieldLabel = new JTextField();
    JTextArea bodyTextFieldLabel = new JTextArea();

    Border simpleBorder = BorderFactory.createLineBorder(Color.black, 1);
    Border checkBorder = BorderFactory.createDashedBorder(Color.black);

    Font bodyFont = new Font("Default",Font.PLAIN,18);

    ImageIcon originoteImage = new ImageIcon("SimpleOriginoteLogo.png");

    boolean titleTextFieldClickedOn = false;
    boolean tagsTextFieldClickedOn = false;
    boolean bodyTextAreaClickedOn = false;

    public GUICreateNotePage(NoteContent existingNoteContent) {
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

        menuBarSubPanel.setBackground(Color.WHITE);
        menuBarSubPanel.setLayout(new GridLayout(1,2,5,5));

        originoteIconjLabel.setIcon(new ImageIcon(originoteImage.getImage().getScaledInstance(130,50, Image.SCALE_DEFAULT)));
        originoteIconjLabel.setPreferredSize(new Dimension(130,50));
        originoteIconjLabel.setHorizontalAlignment(JLabel.CENTER);
        originoteIconjLabel.setVerticalAlignment(JLabel.CENTER);

        blankSpacer.setPreferredSize(new Dimension(130, 50));

        saveNoteButton.setText("Save & Exit");
        //saveNoteButton.setPreferredSize(new Dimension(130,50));
        //saveNoteButton.setHorizontalAlignment(SwingConstants.CENTER);
        //saveNoteButton.setVerticalAlignment(SwingConstants.CENTER);
        saveNoteButton.setBackground(Color.white);
        saveNoteButton.addActionListener(e -> {
            System.out.println("Save Note Button Clicked!");
            //TODO: Add function to save note - Function / Database handler action
            //TODO: Add function to update most recent notes list
            NoteContent noteContent = new NoteContent();
            noteContent.setTitle(titleTextFieldLabel.getText());
            noteContent.setBody(bodyTextFieldLabel.getText());
            noteContent.setDateTime(DateTime.now());
            //TagContent tagContent = new TagContent();
            //tagContent.setTag(tagsTextFieldLabel.getText());
            List<String> tagsList = TagsParser.createTagsList(tagsTextFieldLabel.getText());

            guiFunctionHandler.saveNoteInfo(noteContent, tagsList);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        discardNoteButton.setText("Discard");
        discardNoteButton.setBackground(Color.WHITE);
        discardNoteButton.addActionListener(e -> {
            System.out.println("Discard Button Clicked");
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });


        menuBarPanel.add(originoteIconjLabel);
        menuBarPanel.add(menuBarSubPanel);
        //menuBarPanel.add(blankSpacer);
        menuBarSubPanel.add(saveNoteButton);
        menuBarSubPanel.add(discardNoteButton);

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
        titleTextFieldLabel.setText("Title...");
        titleTextFieldLabel.setForeground(Color.GRAY);
        titleTextFieldLabel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!titleTextFieldClickedOn) {
                    titleTextFieldLabel.setText("");
                    titleTextFieldLabel.setForeground(Color.BLACK);
                    titleTextFieldClickedOn = true;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (titleTextFieldLabel.getText().isEmpty()) {
                    titleTextFieldLabel.setText("Title...");
                    titleTextFieldLabel.setForeground(Color.GRAY);
                    titleTextFieldClickedOn = false;
                }
            }
        });

        tagsTextFieldLabel.setPreferredSize(new Dimension(480, 30));
        tagsTextFieldLabel.setBackground(Color.white);
        tagsTextFieldLabel.setBorder(simpleBorder);
        tagsTextFieldLabel.setFont(bodyFont);
        tagsTextFieldLabel.setText("#Tags...");
        tagsTextFieldLabel.setForeground(Color.GRAY);
        tagsTextFieldLabel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!tagsTextFieldClickedOn) {
                    tagsTextFieldLabel.setText("");
                    tagsTextFieldLabel.setForeground(Color.BLACK);
                    tagsTextFieldClickedOn = true;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tagsTextFieldLabel.getText().isEmpty()) {
                    tagsTextFieldLabel.setText("#Tags...");
                    tagsTextFieldLabel.setForeground(Color.GRAY);
                    tagsTextFieldClickedOn = false;
                }
            }
        });

        bodyTextFieldLabel.setPreferredSize(new Dimension(480, 210));
        bodyTextFieldLabel.setBackground(Color.white);
        bodyTextFieldLabel.setBorder(simpleBorder);
        bodyTextFieldLabel.setFont(bodyFont);
        bodyTextFieldLabel.setText("Note...");
        bodyTextFieldLabel.setForeground(Color.GRAY);

        bodyTextFieldLabel.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!bodyTextAreaClickedOn) {
                    bodyTextFieldLabel.setText("");
                    bodyTextFieldLabel.setForeground(Color.BLACK);
                    bodyTextAreaClickedOn = true;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (bodyTextFieldLabel.getText().isEmpty()) {
                    bodyTextFieldLabel.setText("Note...");
                    bodyTextFieldLabel.setForeground(Color.GRAY);
                    bodyTextAreaClickedOn = false;
                }
            }
        });

        if (existingNoteContent!=null) {
            System.out.println("We got one!");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}

//    ## Create Note Page To Do
//TODO: Implement either a character limit on text fields or allow for scrollable views to fit content in.
//TODO: Implement remaining Save & Exit button functionality.
//TODO:   -Text fields snapshot their entered data and sends it to a database function to create a new note.
//TODO:   -Require information to be put in all 3 fields to be able to save.
//TODO:   -Saving note refreshes recent notes list.
//TODO: Implement Edit Note functionality through the same page.
//TODO:   -Check for note information being passed in when the window is opened.
//TODO:   -Populate fields with any existing note information found