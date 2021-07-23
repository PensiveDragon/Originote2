public class SelectedLibrary {

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int selectedId;
    public int id;

    @Override
    public String toString() {
        return "SelectedLibrary{" +
                "selectedId=" + selectedId +
                ", id=" + id +
                '}';
    }
}
