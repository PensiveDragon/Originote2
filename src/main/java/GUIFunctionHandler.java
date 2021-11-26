import javax.swing.text.html.HTML;
import java.util.List;
import java.util.Locale;

public class GUIFunctionHandler {

    /*
    - Find most recent notes
    - Update recent notes list
    -
    */

    DatabaseHandler databaseHandler = new DatabaseHandler();

    public GUIFunctionHandler() {

    }

    public int[] simpleFindMostRecentNoteIDs() {

        int[] recentIDs = new int[5];

        // top 5 highest id values
        List<NoteContent> noteContents = databaseHandler.findAllNoteData();

        int i = 0;
        for (NoteContent noteContent : noteContents) {
            recentIDs[i] = noteContent.getId();
            i++;
        }

        return recentIDs;
    }

    public int[] findMostRecentNoteIDs() {

        int[] recentIDs = new int[5];

        // read db list of most recently created / altered note ids - FIFO stack? Timestamp column?
        DatabaseHandler databaseHandler = new DatabaseHandler();
        List<NoteContent> noteContents = databaseHandler.findMostRecentFiveNoteData();

        int i = 0;
        for (NoteContent noteContent : noteContents) {
            recentIDs[i] = noteContent.getId();
            i++;
        }

        return recentIDs;
    }

    public String createDisplayListLabelText(int list_int, int note_id) {

        String labelText = "";

        labelText = " " + list_int + ": " + databaseHandler.findNoteDataByID(note_id).getTitle() + " : " + databaseHandler.findNoteDataByID(note_id).getBody();

        return labelText;
    }

    public void openNewViewNotePage(int note_id) {
        new GUIViewNotePage(note_id);
    }

    public void openNewCreateNotePage(NoteContent noteContent) {
        new GUICreateNotePage(noteContent);
    }

    public String assembleTagsString(int note_id) {
        String result = "";


        DatabaseHandler databaseHandler = new DatabaseHandler();
        String[] tags = databaseHandler.findTagsByID(note_id);
        for (int i = 0; i < tags.length; i++) {
            /*String temp = "";
            if (tags[i].contains("  |  ")) {
                System.out.println("ASSEMBLE TAGS STRING: " + tags[i]);
                temp = tags[i].substring(0,tags[i].length()-5);
                System.out.println("ASSEMBLE TAGS STRING: " +temp);
            }*/

            result += "#" + tags[i];
            if ((tags.length - 1) > i) {
                result += "  |  ";
            }
        }
        return result;
    }

    public void openNewSearchResultsPage(String search_parameters) {
        new GUISearchResultsPage(search_parameters);
    }

    public void saveNoteInfo(NoteContent noteContent, List<String> tagsList) {
        System.out.println(noteContent.toString());
        databaseHandler.storeNoteDataAtNextID(noteContent);
        int currentID = databaseHandler.findMaxIDinNoteTable();
        for (String tag: tagsList) {
            System.out.println("#" + tag);
            databaseHandler.addTagToSpecificID(tag, currentID);
        }
    }

    public void updateNoteInfo(NoteContent noteContent, List<String> tagsList) {
        databaseHandler.deleteAllTagsAtID(noteContent.getId());

        for (String tag: tagsList) {
            String temp = "";
            System.out.println("#" + tag);
            temp = tag.replace("|", "");
            //temp = temp.strip();
            databaseHandler.addTagToSpecificID(temp, noteContent.getId());
        }
        databaseHandler.updateNoteDataAtSpecificID(noteContent);
    }

    public void deleteNote(int id) {
        databaseHandler.deleteAllTagsAtID(id);
        databaseHandler.deleteNoteDataAtID(id);
        System.out.println("Deleted note @ ID: " + id);
    }

    public void searchByTag(String searchPhrase) {
        List<TagContent> TagContents = databaseHandler.findTagDataByTag(searchPhrase);
        for (TagContent tag : TagContents) {
            System.out.println("Number of Notes with tag: \"" + searchPhrase + "\" : " + tag.getNote_id());
        }
    }

    public int searchQtyByTag(String searchPhrase) {
        List<TagContent> TagContents = databaseHandler.findTagDataByTag(searchPhrase);
        int result = 0;
        if (TagContents!=null) {
            result = TagContents.size();
        };
        return result;
    }
}
