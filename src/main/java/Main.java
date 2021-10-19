import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Meow");

        //tests();

        GUIMainPage guiMainPage = new GUIMainPage();
    }

    public static void tests() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        System.out.println(databaseHandler.findNoteDataByID(1));

        System.out.println(databaseHandler.findNoteDataByIDOptional(1));

        System.out.println(databaseHandler.findTagDataByTag("film"));

        System.out.println("All note data: " + databaseHandler.findAllNoteData());

        NoteContent testData = new NoteContent();
        testData.setTitle("Test Data");
        testData.setBody("Test Content");
        testData.setDateTime(LocalDateTime.now());

        TagContent tagData = new TagContent();
        tagData.setTag("Hats");
        tagData.setNote_id(testData.getId());

        //databaseHandler.addTagToSpecificID(tagData.getTag(), 3);
        //databaseHandler.addTagToSpecificID("Hat", 3);

        //databaseHandler.deleteAllTagsAtID(3);
        //databaseHandler.deleteSpecificTagAtID("Hat", 3);

        GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();
        //int[] result = guiFunctionHandler.simpleFindMostRecentNoteIDs();
        int[] result = guiFunctionHandler.findMostRecentNoteIDs();
        for (int item : result) {
            //System.out.println("Simple Most Recent Note IDs: " + item);
            System.out.println("Smart Most Recent Note IDs: " + item);
        }


        System.out.println(databaseHandler.findTagDataByID(1));

        //databaseHandler.storeNoteDataAtNextID(testData);
        //databaseHandler.deleteNoteDataAtID(4);

        NoteContent updateTestData = new NoteContent();
        updateTestData.setId(5);
        updateTestData.setTitle("Updated Data");
        updateTestData.setBody("Updated Content");
        updateTestData.setDateTime(LocalDateTime.now());

        databaseHandler.updateNoteDataAtSpecificID(updateTestData);

    }
}

/*
    Functions:
     - List
     - Create / Edit
     - Display
     - Search


/*    ## Overall Tasks To Do:
TODO: Create Automatic Tests for DBHandler
TODO: Look at generalising the GUI classes to extend a common class.
*/