package interface_adapter.history;

public class HistoryState {
    private String word = "";

    public HistoryState(HistoryState copy) {
        word = copy.word;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public HistoryState() {}

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
