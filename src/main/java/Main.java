public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Meow");

        //DatabaseHandler databaseHandler = new DatabaseHandler();
        //System.out.println(databaseHandler.findMaxIDinNoteTable());
        findTests();
        //deleteTest();
        //createTest();
        //updateTest();

        GUIMainPage guiMainPage = new GUIMainPage();
    }

    public static void findTests() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        System.out.println("Number of notes with the tag #film: " + databaseHandler.findIDByTag("film").length);

        System.out.println("Number of notes with the tag #gopher: " + databaseHandler.findIDByTag("gopher").length);

        System.out.println("ID of first note with tag #film: " + databaseHandler.findIDByTag("film")[0]);

        System.out.println("ID of first note with no tag found: " + databaseHandler.findIDByTag("hat")[0]);

        System.out.println(databaseHandler.findNoteDataByID(1));

        System.out.println(databaseHandler.findNoteDataByIDOptional(1));

        System.out.println(databaseHandler.findTagDataByTag("film"));

        System.out.println("All note data: " + databaseHandler.findAllNoteData());

        GUIFunctionHandler guiFunctionHandler = new GUIFunctionHandler();
        //int[] result = guiFunctionHandler.simpleFindMostRecentNoteIDs();
        int[] result = guiFunctionHandler.findMostRecentNoteIDs();
        for (int item : result) {
            //System.out.println("Simple Most Recent Note IDs: " + item);
            System.out.println("Smart Most Recent Note IDs: " + item);
        }

        System.out.println(databaseHandler.findTagDataByID(1));
    }

    public static void createTest() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        NoteContent testData = new NoteContent();
        testData.setTitle("Test Data");
        testData.setBody("Test Content");
        testData.setDateTime(DateTime.now());

        TagContent tagData = new TagContent();
        tagData.setTag("Hats");
        tagData.setNote_id(databaseHandler.findMaxIDinNoteTable());

        //TODO: Make the above command find the right ID automatically.

        databaseHandler.storeNoteDataAtNextID(testData);
        System.out.println("Attempting to add Tag: " + tagData.getTag() + " to id: " + tagData.getNote_id());
        databaseHandler.addTagToSpecificID(tagData.getTag(),tagData.getNote_id());
    }

    public static void updateTest() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        NoteContent updateTestData = new NoteContent();
        updateTestData.setId(5);
        updateTestData.setTitle("Updated Data");
        updateTestData.setBody("Updated Content");
        updateTestData.setDateTime(DateTime.now());
        databaseHandler.updateNoteDataAtSpecificID(updateTestData);
    }

    public static void deleteTest() {
        DatabaseHandler databaseHandler = new DatabaseHandler();

        databaseHandler.deleteAllTagsAtID(5);
        databaseHandler.deleteNoteDataAtID(5);

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