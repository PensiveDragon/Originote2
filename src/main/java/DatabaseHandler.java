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

    public NoteContent findNoteDataByID(int id) {

        NoteContent result = new NoteContent();



        return result;
    }

    public NoteContent findNoteDataByTag(String tag) {

        NoteContent result = new NoteContent();

        return result;
    }


    /* methods to access sql
    Default Screen:
    - Populate Recent notes call: either sort by >id (easiest) or array of id's most recently created/edited (best).
    -> Select * from note_content
    New/Edit Note Screen:
    - Create new note
    - Create new tags
    - Edit note
    - Edit tags
    View Note Screen:
    - Populate from database
    -> Select * from note_content where id=x
    Search Screen:
    - Populate list with search results
    -> Select * from note_tags where tag=x
    -> Select * from note_content where title contains x

    ## Join can be used to find data from one table using information from another connected table. ##
    */
}
