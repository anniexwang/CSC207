package use_case.clear;

public class ClearOutputData {
    private final boolean clearStatus;

    public ClearOutputData(boolean clearStatus) {
        this.clearStatus = clearStatus;
    }

    public boolean clearStatus() {
        return clearStatus;
    }
}