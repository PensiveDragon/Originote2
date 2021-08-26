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

        return recentIDs;
    }
}
