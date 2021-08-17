public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Meow");

        DatabaseHandler databaseHandler = new DatabaseHandler();

        System.out.println(databaseHandler.findNoteDataByID(1));

        System.out.println(databaseHandler.findNoteDataByIDOptional(1));

        System.out.println(databaseHandler.findTagDataByTag("film"));

        NoteContent testData = new NoteContent();
        testData.setTitle("Test Data");
        testData.setBody("Test Content");

        TagContent tagData = new TagContent();
        tagData.setTag("Hats");
        tagData.setNote_id(testData.getId());

        //databaseHandler.addTagToSpecificID(tagData.getTag(), 3);
        databaseHandler.addTagToSpecificID("Hat", 3);

        //databaseHandler.deleteAllTagsAtID(3);
        databaseHandler.deleteSpecificTagAtID("Hat", 3);

        //databaseHandler.storeNoteDataAtNextID(testData);
        databaseHandler.deleteNoteDataAtID(4);

        NoteContent updateTestData = new NoteContent();
        updateTestData.setId(3);
        updateTestData.setTitle("Updated Data");
        updateTestData.setBody("Updated Content");

        databaseHandler.updateNoteDataAtSpecificID(updateTestData);

        GUI gui = new GUI();


    }
}

/*
    Functions:
     - List
     - Create / Edit
     - Display
     - Search


To Do:
X- Create basic GUI - GUI class
X- Create basic attachment to mysql database
X- Create DB methods for storing data
X- Create DB methods for retrieving data
X- Create DB search function for tags
X- NoteContent database
X- Tag database linking to NoteContent db
- Create New/Edit Note GUI
- Create View Note GUI
- Create Search Result GUI
- Create Automatic Tests for DBHandler
- Create UIHandler class to hook UI to DBHandler

 */