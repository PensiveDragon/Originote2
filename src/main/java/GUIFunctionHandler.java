import java.util.List;

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
}
