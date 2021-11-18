import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Optional;

public class DatabaseHandler {

    Jdbi jdbi = Jdbi.create("jdbc:mysql://localhost:3306/originote", "root", System.getenv("MYSQL_PW"));

    public List<NoteContent> findAllNoteData() {

        List<NoteContent> NoteContents = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM note_content")
                    .mapToBean(NoteContent.class)
                    .list();
        });

        if (NoteContents.size()!=0) {
            return NoteContents;
        } else {
            return null;
        }
    }

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

            Optional<NoteContent> noteContent = jdbi.withHandle(handle -> {
                return handle.select("SELECT * FROM note_content where id=" + id)
                        .mapToBean(NoteContent.class)
                        .findOne();
            });
            // TODO: Add exception handler for >1 results.
            if (noteContent.isPresent()) {
                return noteContent;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String[] findTagsByID(int id) {


        List<TagContent> TagContents = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM tags_to_notes where note_id='" + id + "'")
                    .mapToBean(TagContent.class)
                    .list();
        });

        String[] results = new String[TagContents.size()];

        for (int i = 0; i < TagContents.size(); i++) {
            results[i] = TagContents.get(i).getTag();
            //System.out.println("Tag " + i + " added.");
        }

        return results;
    }

    public int findMaxIDinNoteTable() {

        try {

            Optional<Integer> result = jdbi.withHandle(handle -> {
                return handle.select("select max(id) as LastID from note_content")
                        .mapTo(Integer.class)
                        .findOne();
            });

            if (result.isPresent()) {
                return result.get();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
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

    public int[] findIDByTag(String tag) {

        List<TagContent> TagContents = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM tags_to_notes where tag='" + tag + "'")
                    .mapToBean(TagContent.class)
                    .list();
        });

        int[] results = new int[TagContents.size()];
        int i = 0;

        if (TagContents.size() != 0) {
            for (TagContent tagContent: TagContents) {
                results[i] = tagContent.getNote_id();
                i++;
            }
            return results;
        } else {
            int[] empty = new int[0];
            return empty;
        }
    }

    public List<TagContent> findTagDataByID(int id) {

        List<TagContent> TagContents = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM tags_to_notes WHERE note_id=" + id)
                    .mapToBean(TagContent.class)
                    .list();
        });

        if (TagContents.size()!=0) {
            return TagContents;
        } else {
            return null;
        }
    }

    public List<NoteContent> findMostRecentFiveNoteData() {

        List<NoteContent> NoteContents = jdbi.withHandle(handle -> {
            return handle.createQuery("SELECT * FROM note_content ORDER BY date_time DESC LIMIT 5")
                    .mapToBean(NoteContent.class)
                    .list();
        });

        if (NoteContents.size()!=0) {
            return NoteContents;
        } else {
            return null;
        }
    }

    public void storeNoteDataAtNextID(NoteContent noteContent) {

        try {

            int result = jdbi.withHandle(handle -> {
                return handle.createUpdate("insert into note_content(title, body, date_time) values (:title, :body, :date_time)")
                        .bind("title", noteContent.getTitle())
                        .bind("body", noteContent.getBody())
                        .bind("date_time", noteContent.getDateTime())
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
                return handle.createUpdate("UPDATE note_content SET title=:title, body=:body, date_time=:date_time where id=:id")
                        .bind("id", noteContent.getId())
                        .bind("title", noteContent.getTitle())
                        .bind("body", noteContent.getBody())
                        .bind("date_time", noteContent.getDateTime())
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
    */
}
