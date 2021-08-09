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

        List<NoteContent> NoteContents = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM note_content where id=" + id)
                    .mapToBean(NoteContent.class)
                    .list();
        });
        //## Add safety to code for when result is empty!!!
        if (NoteContents.size()!=0) {
            return NoteContents.get(0);
        } else {
            return null;
        }

    }

    public NoteContent findNoteDataByTag(String tag) {

        NoteContent result = new NoteContent();

        return result;
    }

    public void storeNoteDataAtID(NoteContent noteContent) {
        // insert into note_content(title, body) values ("Film Night Ideas", "Titanic, Shawshank Redemption, Silence of the Lambs");

        // insert into note_content(title, body) values (noteContent.title, noteContent.body);
        // insert into note_content(id, title, body) values (noteContent.id, noteContent.title, noteContent.body);
    }

    public void deleteNoteDataAtID(NoteContent noteContent) {
        // delete from selectedLibrary where id=4;
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
