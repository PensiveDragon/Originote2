import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIMainPage extends JFrame implements ActionListener {

    JPanel menuBarPanel = new JPanel();
    JPanel bodyPanel = new JPanel();
    JPanel searchBarPanel = new JPanel();
    JPanel recentNotesPanel = new JPanel();
    JPanel displayListPanel = new JPanel();

    JButton newNoteButton;
    JButton listNotesButton;

    JLabel originoteIconjLabel = new JLabel();
    JLabel displayListLabel = new JLabel();

    JButton recentNotes[] = new JButton[5];

    ImageIcon image = new ImageIcon("Originote.png");
    ImageIcon originoteImage = new ImageIcon("SimpleOriginoteLogo.png");
    JTextField jSearchTextField = new JTextField();
    Border testBoundsBorder = BorderFactory.createLineBorder(Color.black, 1);
    Font testFont = new Font("Default",Font.PLAIN,32);

    public GUIMainPage() {

        this.setTitle("Originote");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(640,480);
        this.setLayout(new BorderLayout(10, 10));
        this.setVisible(true);
        this.setIconImage(image.getImage());
        //this.getContentPane().setBackground(Color.gray);



        //### MENU BAR PANEL SETUP

        menuBarPanel.setPreferredSize(new Dimension(640,50));
        menuBarPanel.setBackground(Color.white);
        menuBarPanel.setLayout(new GridLayout(1,3, 5, 5));

        originoteIconjLabel.setIcon(new ImageIcon(originoteImage.getImage().getScaledInstance(130,50, Image.SCALE_DEFAULT)));
        originoteIconjLabel.setPreferredSize(new Dimension(130,50));
        originoteIconjLabel.setHorizontalAlignment(JLabel.CENTER);
        originoteIconjLabel.setVerticalAlignment(JLabel.CENTER);

        newNoteButton = new JButton();
        newNoteButton.setText("New Note");
        newNoteButton.setBackground(Color.white);
        newNoteButton.addActionListener(e -> System.out.println("New Note Button Clicked!"));
        newNoteButton.setFocusable(false);

        listNotesButton = new JButton();
        listNotesButton.setText("List Notes");
        listNotesButton.setBackground(Color.white);
        listNotesButton.addActionListener(e -> System.out.println("List Notes Button Clicked!"));
        listNotesButton.setFocusable(false);

        menuBarPanel.add(originoteIconjLabel);
        menuBarPanel.add(newNoteButton);
        menuBarPanel.add(listNotesButton);

        bodyPanel.setLayout(new BorderLayout(10,10));


        //### SEARCH BAR PANEL SETUP


        //searchBarPanel.setPreferredSize(new Dimension(640,50));
        searchBarPanel.setBackground(Color.white);
        searchBarPanel.setLayout(new FlowLayout());
        searchBarPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        searchBarPanel.validate();

        JButton searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setBackground(Color.white);
        searchButton.addActionListener(e -> System.out.println("Search Button Clicked!"));
        searchButton.setFocusable(false);

        jSearchTextField.setToolTipText("Search Bar");
        jSearchTextField.setText("Enter your search...");
        jSearchTextField.setPreferredSize(new Dimension(400,30));

        searchBarPanel.add(searchButton);
        searchBarPanel.add(jSearchTextField);

        //### RECENT NOTES PANEL SETUP

        recentNotesPanel.setPreferredSize(new Dimension(80,80));
        recentNotesPanel.setBackground(Color.white);

        this.add(menuBarPanel,BorderLayout.NORTH);
        this.add(bodyPanel,BorderLayout.CENTER);
        bodyPanel.add(recentNotesPanel,BorderLayout.CENTER);
        bodyPanel.add(searchBarPanel,BorderLayout.NORTH);

        DatabaseHandler databaseHandler = new DatabaseHandler();

        displayListPanel.setLayout(new GridLayout(6,1, 8, 8));
        displayListPanel.setBounds(10,50, 600,250);
        displayListPanel.setBackground(Color.white);
        displayListPanel.add(displayListLabel);
        //displayListPanel.setBorder(testBoundsBorder);

        displayListLabel.setText("Recent Notes:");
        displayListLabel.setFont(testFont);
        displayListLabel.setHorizontalAlignment(0);
        //displayListLabel0.setBorder(testBoundsBorder);

        populateRecentNotes();

        recentNotesPanel.setLayout(new FlowLayout());
        recentNotesPanel.add(displayListPanel);

        this.validate();

    }

    private void populateRecentNotes() {
        int n = 0;
        GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();
        int[] recentIDs = guiFunctionHandler.findMostRecentNoteIDs();

        for (int i = 0; i <5; i++) {
            recentNotes[i] = new JButton();
            displayListPanel.add(recentNotes[i]);
            recentNotes[i].setPreferredSize(new Dimension(500, 40));
            recentNotes[i].setBackground(Color.white);
            recentNotes[i].setBorder(testBoundsBorder);
            recentNotes[i].setHorizontalAlignment(SwingConstants.LEFT);
            recentNotes[i].setFocusable(false);
            recentNotes[i].addActionListener(this);

            if (recentIDs[n] > 0) {
                recentNotes[i].setText(new GUIFunctionHandler().createDisplayListLabelText(++n, recentIDs[n - 1]));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();

        int[] recentIDs = guiFunctionHandler.findMostRecentNoteIDs();
        if (e.getSource()==recentNotes[0]) {
            System.out.println("First Entry. Note ID: " + recentIDs[0]);
            new GUIViewNotePage(recentIDs[0]);
        } else if (e.getSource()==recentNotes[1]) {
            System.out.println("Second Entry. Note ID: " + recentIDs[1]);
            new GUIViewNotePage(recentIDs[1]);
        } else if (e.getSource()==recentNotes[2]) {
            System.out.println("Third Entry. Note ID: " + recentIDs[2]);
            new GUIViewNotePage(recentIDs[2]);
        } else if (e.getSource()==recentNotes[3]) {
            System.out.println("Forth Entry. Note ID: " + recentIDs[3]);
            new GUIViewNotePage(recentIDs[3]);
        } else if (e.getSource()==recentNotes[4]) {
            System.out.println("Fifth Entry. Note ID: " + recentIDs[4]);
            new GUIViewNotePage(recentIDs[4]);
        } else {
            System.out.println("none");
        };
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