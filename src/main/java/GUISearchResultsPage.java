import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class GUISearchResultsPage extends JFrame implements ActionListener {

    GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();

    ImageIcon image = new ImageIcon("Originote.png");

    JPanel menuBarPanel = new JPanel();
    JPanel bodyPanel = new JPanel();
    JPanel searchResultsPanel = new JPanel();
    JPanel searchResultsListPanel = new JPanel();
    JPanel searchBarPanel = new JPanel();

    JLabel originoteIconjLabel = new JLabel();
    JLabel headingLabel = new JLabel();

    JButton searchResults[] = new JButton[5];

    JTextField jSearchTextField = new JTextField();

    boolean jSearchTextFieldClicked = false;

    Border simpleBorder = BorderFactory.createLineBorder(Color.black, 1);
    Border checkBorder = BorderFactory.createDashedBorder(Color.black);

    Font bodyFont = new Font("Default",Font.PLAIN,18);
    Font testFont = new Font("Default",Font.PLAIN,32);

    ImageIcon originoteImage = new ImageIcon("SimpleOriginoteLogo.png");

    public GUISearchResultsPage(String search_parameters) {
        this.setTitle("Originote - Search Results for: " + search_parameters);
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


        //### SEARCH BAR PANEL SETUP


        //searchBarPanel.setPreferredSize(new Dimension(640,50));
        searchBarPanel.setBackground(Color.white);
        searchBarPanel.setLayout(new FlowLayout());
        searchBarPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        searchBarPanel.validate();

        JButton searchButton = new JButton();
        searchButton.setText("Search");
        searchButton.setBackground(Color.white);
        searchButton.addActionListener(e -> {
            System.out.println("Search Button Clicked!");
            String new_search_parameters = jSearchTextField.getText();
            if (new_search_parameters.isEmpty()) {
                jSearchTextField.setText("Enter search terms...");
                jSearchTextField.setForeground(Color.gray);
            } else {
                if ((!new_search_parameters.isEmpty()) & (!new_search_parameters.equals("Search..."))) {
                    guiFunctionHandler.openNewSearchResultsPage(new_search_parameters);
                }
            }
        });
        searchButton.setFocusable(false);

        jSearchTextField.setToolTipText("Search Bar");
        jSearchTextField.setText("Search...");
        jSearchTextField.setPreferredSize(new Dimension(400,30));
        jSearchTextField.setForeground(Color.GRAY);
        jSearchTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!jSearchTextFieldClicked) {
                    jSearchTextField.setText("");
                    jSearchTextField.setForeground(Color.BLACK);
                    jSearchTextFieldClicked = true;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (jSearchTextField.getText().isEmpty()) {
                    jSearchTextField.setText("Search...");
                    jSearchTextField.setForeground(Color.GRAY);
                    jSearchTextFieldClicked = false;
                }
            }
        });

        searchBarPanel.add(searchButton);
        searchBarPanel.add(jSearchTextField);

        //### BODY PANEL SETUP

        bodyPanel.setLayout(new BorderLayout(10,10));
        bodyPanel.setBackground(Color.white);
        bodyPanel.add(searchResultsPanel,BorderLayout.CENTER);
        bodyPanel.add(searchBarPanel,BorderLayout.NORTH);

        searchResultsPanel.setPreferredSize(new Dimension(80,80));
        searchResultsPanel.setBackground(Color.white);
        searchResultsPanel.setLayout(new FlowLayout());

        searchResultsPanel.add(searchResultsListPanel,BorderLayout.NORTH);
        searchResultsListPanel.setLayout(new GridLayout(6,1,8,8));
        searchResultsListPanel.setBounds(10,50, 600,250);
        searchResultsListPanel.setBackground(Color.WHITE);
        searchResultsListPanel.add(headingLabel);


        headingLabel.setText(guiFunctionHandler.searchQtyByTag(search_parameters) + " Results for: \"" + search_parameters + "\"");
        headingLabel.setFont(testFont);
        headingLabel.setHorizontalAlignment(0);

        JButton test = new JButton();
        test.setText("Testing");
        test.setPreferredSize(new Dimension(500, 40));
        test.setBackground(Color.white);
        test.setBorder(simpleBorder);
        test.setHorizontalAlignment(SwingConstants.LEFT);
        test.setFocusable(false);
        test.addActionListener(e -> {
            System.out.println("Test Result Button Clicked!");
        });

        //searchResultsListPanel.add(test);


        //guiFunctionHandler.searchByTag(search_parameters);

        if (new DatabaseHandler().findIDsByTag(search_parameters).length>0) {
            populateSearchResults(search_parameters);
        }
    }

    private void populateSearchResults(String search_parameters) {
        int n = 0;

        DatabaseHandler databaseHandler = new DatabaseHandler();
        int[] searchResultIds = databaseHandler.findIDsByTag(search_parameters);

        for (int i = 0; i <5; i++) {
            searchResults[i] = new JButton();
            searchResults[i].setText("" + (i+1));
            searchResultsListPanel.add(searchResults[i]);
            searchResults[i].setPreferredSize(new Dimension(500, 40));
            searchResults[i].setBackground(Color.white);
            searchResults[i].setBorder(simpleBorder);
            searchResults[i].setHorizontalAlignment(SwingConstants.LEFT);
            searchResults[i].setFocusable(false);
            searchResults[i].addActionListener(e -> {
                System.out.println("Test Result Button Clicked!");
            });

/*
            if (recentIDs[n] > 0) {
                //System.out.println("info i=" + i + " n=" + n + "recentIDs[n]=" + recentIDs[n]);
                searchResults[i].addActionListener(this);
                searchResults[i].setText(new GUIFunctionHandler().createDisplayListLabelText(++n, recentIDs[n - 1]));
            } else {
                searchResults[i].setText(" Create a new Note!");
                searchResults[i].addActionListener(e -> {
                    System.out.println("Recent Notes Create New Note Button Clicked!");
                    guiFunctionHandler.openNewCreateNotePage(null);
                });
            }*/
        }
    }
/*
    public void populateSearchResultsList() {

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
*/
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

//    ## Search Results Page To Do: ##
//TODO: Title line saying: "[x] search results for: [search phrase]"
//TODO: JPanel containing the results. Panel either needs to be scrollable or have result page tabs for large results.
//TODO: Function creating JButtons with each answer in. Displayed and functions in the same way as 'recent notes'.