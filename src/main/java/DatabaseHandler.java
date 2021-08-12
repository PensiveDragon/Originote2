import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Optional;

public class DatabaseHandler {

    Jdbi jdbi = Jdbi.create("jdbc:mysql://localhost:3306/originote", "root", System.getenv("MYSQL_PW"));

    public NoteContent findNoteDataByID(int id) {

        List<NoteContent> NoteContents = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM note_content where id=" + id)
                    .mapToBean(NoteContent.class)
                    .list();
        });

        if (NoteContents.size()!=0) {
            return NoteContents.get(0);
        } else {
            return null;
        }
    }

/*
    public Optional<NoteContent> findNoteDataByIDOptional(int id) {

        try {

            Optional<NoteContent> NoteContent = jdbi.withHandle(handle -> {
                return handle.select("SELECT * FROM note_content where id=" + id)
                        .mapTo(NoteContent.class)
                        .findOne();
            });
            // TODO: Fix errors to make Optional work!
            // TODO: Add exception handler for >1 results.
            return NoteContent;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
*/

    public List<TagContent> findTagDataByTag(String tag) {


        List<TagContent> TagContents = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM tags_to_notes where tag='" + tag + "'")
                    .mapToBean(TagContent.class)
                    .list();
        });

        if (TagContents.size() != 0) {
            return TagContents;
        } else {
            return null;
        }

    }

    public void storeNoteDataAtNextID(NoteContent noteContent) {

        try {

            int result = jdbi.withHandle(handle -> {
                return handle.createUpdate("insert into note_content(title, body) values (:title, :body)")
                        .bind("title", noteContent.getTitle())
                        .bind("body", noteContent.getBody())
                        .execute();
            });

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // insert into note_content(title, body) values ("Film Night Ideas", "Titanic, Shawshank Redemption, Silence of the Lambs");

        // insert into note_content(title, body) values (noteContent.title, noteContent.body);
        // insert into note_content(id, title, body) values (noteContent.id, noteContent.title, noteContent.body);
    }

    public void updateNoteDataAtSpecificID(NoteContent noteContent) {

        try {

            int result = jdbi.withHandle(handle -> {
                return handle.createUpdate("UPDATE note_content SET title=:title, body=:body where id=:id")
                        .bind("id", noteContent.getId())
                        .bind("title", noteContent.getTitle())
                        .bind("body", noteContent.getBody())
                        .execute();
            });

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // insert into note_content(title, body) values ("Film Night Ideas", "Titanic, Shawshank Redemption, Silence of the Lambs");

        // insert into note_content(title, body) values (noteContent.title, noteContent.body);
        // insert into note_content(id, title, body) values (noteContent.id, noteContent.title, noteContent.body);
    }

    public void deleteNoteDataAtID(int id) {

        try {

            int result = jdbi.withHandle(handle -> {
                return handle.createUpdate("delete from note_content where id=" + id)
                        .execute();
            });

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
