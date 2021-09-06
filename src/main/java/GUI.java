import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {

    JPanel menuBarPanel = new JPanel();
    JPanel bodyPanel = new JPanel();
    JPanel searchBarPanel = new JPanel();
    JPanel recentNotesPanel = new JPanel();
    JPanel displayListPanel = new JPanel();

    JButton newNoteButton;
    JButton listNotesButton;

    JLabel originoteIconjLabel = new JLabel();
    JLabel displayListLabel0 = new JLabel();
    JLabel displayListLabel1 = new JLabel();
    JLabel displayListLabel2 = new JLabel();
    JLabel displayListLabel3 = new JLabel();
    JLabel displayListLabel4 = new JLabel();
    JLabel displayListLabel5 = new JLabel();

    JLabel recentNotes[] = new JLabel[5];

    ImageIcon image = new ImageIcon("Originote.png");
    ImageIcon originoteImage = new ImageIcon("SimpleOriginoteLogo.png");
    JTextField jSearchTextField = new JTextField();
    Border testBoundsBorder = BorderFactory.createLineBorder(Color.black, 1);

    public GUI() {

        this.setTitle("Originote");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(true);
        this.setSize(640,480);
        this.setLayout(new BorderLayout(5,5));
        this.setVisible(true);
        this.setIconImage(image.getImage());
        //this.getContentPane().setBackground(Color.gray);



        //### MENU BAR PANEL SETUP

        menuBarPanel.setPreferredSize(new Dimension(640,50));
        menuBarPanel.setBackground(Color.white);
        menuBarPanel.setLayout(new GridLayout(1,3));

        originoteIconjLabel.setIcon(new ImageIcon(originoteImage.getImage().getScaledInstance(130,50, Image.SCALE_DEFAULT)));
        originoteIconjLabel.setPreferredSize(new Dimension(130,50));
        originoteIconjLabel.setHorizontalAlignment(JLabel.CENTER);
        originoteIconjLabel.setVerticalAlignment(JLabel.CENTER);

        newNoteButton = new JButton();
        newNoteButton.setText("New Note");
        newNoteButton.setBackground(Color.white);
        newNoteButton.addActionListener(this);
        newNoteButton.setFocusable(false);

        listNotesButton = new JButton();
        listNotesButton.setText("List Notes");
        listNotesButton.setBackground(Color.white);
        listNotesButton.addActionListener(this);
        listNotesButton.setFocusable(false);

        menuBarPanel.add(originoteIconjLabel);
        menuBarPanel.add(newNoteButton);
        menuBarPanel.add(listNotesButton);

        bodyPanel.setLayout(new BorderLayout(10,10));

        //### SEARCH BAR PANEL SETUP

        searchBarPanel.setPreferredSize(new Dimension(640,50));
        searchBarPanel.setBackground(Color.white);
        searchBarPanel.setLayout(new FlowLayout());
        searchBarPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JButton searchButton = new JButton();
        searchButton.setText("Search");

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
        bodyPanel.add(searchBarPanel,BorderLayout.NORTH);
        this.add(recentNotesPanel,BorderLayout.CENTER);



        DatabaseHandler databaseHandler = new DatabaseHandler();



        displayListPanel.setLayout(new GridLayout(6,1));
        displayListPanel.setBounds(10,50, 600,250);
        displayListPanel.add(displayListLabel0);
//        displayListPanel.add(displayListLabel1);
//        displayListPanel.add(displayListLabel2);
//        displayListPanel.add(displayListLabel3);
//        displayListPanel.add(displayListLabel4);
//        displayListPanel.add(displayListLabel5);
        displayListPanel.setBorder(testBoundsBorder);

        displayListLabel0.setText("Recent Notes:");
        displayListLabel0.setHorizontalAlignment(0);
        //displayListLabel0.setBorder(border);
/*
        displayListLabel1.setText(" 1: " + databaseHandler.findNoteDataByID(1).getTitle() + " : " + databaseHandler.findNoteDataByID(1).getBody());
        //displayListLabel1.setBorder(border);

        displayListLabel2.setText(" 2:");
        //displayListLabel2.setBorder(border);

        displayListLabel3.setText(" 3:");
        //displayListLabel3.setBorder(border);

        displayListLabel4.setText(" 4:");
        //displayListLabel4.setBorder(border);

        displayListLabel5.setText(" 5:");
        //displayListLabel5.setBorder(border);
*/
        populateRecentNotes();


        recentNotesPanel.setLayout(null);
        recentNotesPanel.add(displayListPanel);

        this.validate();

    }

    private void populateRecentNotes() {
        int n = 0;
        GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();
        int[] recentIDs = guiFunctionHandler.findMostRecentNoteIDs();

        for(JLabel note : recentNotes) {
            note = new JLabel();
            displayListPanel.add(note);

            if (recentIDs[n] > 0) {
                note.setText(new GUIFunctionHandler().createDisplayListLabelText(++n, recentIDs[n - 1]));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==newNoteButton) {
            System.out.println("New Note Button Clicked!");
        }
        if (e.getSource()==listNotesButton) {
            System.out.println("List Notes Button Clicked!");
        }
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
