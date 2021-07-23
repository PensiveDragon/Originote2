import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Meow");

        Jdbi jdbi = Jdbi.create("jdbc:mysql://localhost:3306/sakila", "root", "your_password_here");
        List<SelectedLibrary> selectedLibraries = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM selectedLibrary")
                    .mapToBean(SelectedLibrary.class)
                    .list();
        });


        System.out.println(selectedLibraries);


        new GUI();

    }
}

/*
    Functions:
     - List
     - Create
     - Edit
     - Search


To Do:
- Create basic GUI - GUI class
- Create temporary note storage system - storage handler class
- Populate GUI from temporary storage system.
- On Start up: check for temp database, if not found, create text document for it.
 */