package use_case.clear;
import interface_adapter.clear.ClearViewModel;

public class ClearInteractor implements ClearInputBoundary {
private final ClearUserDataAccessInterface clearUserDataAccess;
private final ClearOutputBoundary clearPresenter;
private final ClearViewModel clearViewModel; // Add this as a parameter

public ClearInteractor(
    ClearUserDataAccessInterface clearUserDataAccess,
    ClearOutputBoundary clearPresenter,
    ClearViewModel clearViewModel) {
    this.clearUserDataAccess = clearUserDataAccess;
    this.clearPresenter = clearPresenter;
    this.clearViewModel = clearViewModel;
    }
//
    @Override
    public void execute(ClearInputData clearInputData) {
    try{
        String user = clearInputData.getUser();
        clearUserDataAccess.clearUser();
        ClearOutputData clearOutputData = new ClearOutputData(true);
        clearPresenter.prepareSuccessView(clearOutputData);
//// Get the names of deleted users and set them in ClearState
        String deletedUser = getDeletedUserFromDataAccess(); // Implement this method
        clearViewModel.getState().setDeletedUser(deletedUser);
//
        } catch (Exception e) {
        clearPresenter.prepareFailView("Failed to clear user: " + e.getMessage());
        }
    }
    // Implement a method to get the names of deleted users from your data access layer
    private String getDeletedUserFromDataAccess() {
        return clearUserDataAccess.getDeletedUserName();
        }
    }