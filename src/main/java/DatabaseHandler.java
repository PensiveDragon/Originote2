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


    public Optional<NoteContent> findNoteDataByIDOptional(int id) {

        try {

            Optional<NoteContent> NoteContent = jdbi.withHandle(handle -> {
                return handle.select("SELECT * FROM note_content where id=" + id)
                        .mapToBean(NoteContent.class)
                        .findOne();
            });
            // TODO: Fix errors to make Optional work!
            // TODO: Add exception handler for >1 results.
            if (NoteContent.isPresent()) {
                return NoteContent;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


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
    }

    public void addTagToSpecificID(String tag, int note_id) {

        //TODO: prevent duplicate tag/id crashes

        try {

            int result = jdbi.withHandle(handle -> {
                return handle.createUpdate("insert into tags_to_notes(tag, note_id) values (:tag, :note_id)")
                        .bind("tag", tag)
                        .bind("note_id", note_id)
                        .execute();
            });

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void deleteAllTagsAtID(int note_id) {

        try {

            int result = jdbi.withHandle(handle -> {
                return handle.createUpdate("delete from tags_to_notes where note_id=" + note_id)
                        .execute();
            });

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSpecificTagAtID(String tag, int note_id) {

        try {

            int result = jdbi.withHandle(handle -> {
                return handle.createUpdate("DELETE FROM tags_to_notes WHERE note_id=" + note_id + " AND tag='" + tag + "'")
                //return handle.createUpdate("DELETE FROM tags_to_notes WHERE note_id=3 AND tag='Hat'")
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

    TODO: Ask about deletion from SQL database, auto-increment, reusing old numbers (or not), any practical limits on entries
    TODO: Ask about tag association and deletion
    TODO: Look about fuzzy searching for tags / words - just the LIKE keyword?
    */
}
