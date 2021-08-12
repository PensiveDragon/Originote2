public class TagContent {

    private String tag;
    private int note_id;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    @Override
    public String toString() {
        return "TagContent{" +
                "tag='" + tag + '\'' +
                ", note_id=" + note_id +
                '}';
    }
}
