import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Meow");

        DatabaseHandler databaseHandler = new DatabaseHandler();

        //String test = databaseHandler.findNoteDataByID(1).toString();
        //System.out.println(test);

        System.out.println(databaseHandler.findNoteDataByID(1));

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