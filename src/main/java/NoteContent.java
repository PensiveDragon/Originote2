import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class NoteContent {

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDateTime(String dateTime) { this.dateTime = dateTime; }

    private int id;
    private String title;
    private String body;
    private String dateTime;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public String getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "NoteContent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
