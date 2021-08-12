public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Meow");

        DatabaseHandler databaseHandler = new DatabaseHandler();

        System.out.println(databaseHandler.findNoteDataByID(1));

        //System.out.println(databaseHandler.findNoteDataByIDOptional(1));

        System.out.println(databaseHandler.findTagDataByTag("film"));

        NoteContent testData = new NoteContent();
        testData.setTitle("Test Data");
        testData.setBody("Test Content");

        databaseHandler.storeNoteDataAtNextID(testData);
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
- Create methods for storing data
- Create methods for retrieving data
- Create search function for tags
- Tag database storing arrays? New database page with links to notes database?
 */