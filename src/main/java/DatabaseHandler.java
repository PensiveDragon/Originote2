import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class DatabaseHandler {

    Jdbi jdbi = Jdbi.create("jdbc:mysql://localhost:3306/originote", "root", System.getenv("MYSQL_PW"));
    List<NoteContent> NoteContents = jdbi.withHandle(handle -> {
        return handle.createQuery("SELECT * FROM note_content")
                .mapToBean(NoteContent.class)
                .list();
    });

    DatabaseHandler(){
        System.out.println(NoteContents);
    }


}
