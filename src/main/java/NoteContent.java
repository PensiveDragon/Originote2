import java.time.LocalDateTime;

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

    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    private int id;
    private String title;
    private String body;
    private LocalDateTime dateTime;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public LocalDateTime getDateTime() { return dateTime; }

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
