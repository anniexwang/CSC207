package interface_adapter.clear;

import interface_adapter.clear.ClearPresenter;
import use_case.clear.ClearInputBoundary;
import use_case.clear.ClearInputData;

public class ClearController {
    private final ClearInputBoundary clearUseCaseInteractor;
    private final ClearPresenter clearPresenter;

    public ClearController(ClearInputBoundary clearUseCaseInteractor, ClearPresenter clearPresenter) {
        this.clearUseCaseInteractor = clearUseCaseInteractor;
        this.clearPresenter = clearPresenter;
    }

    public void execute(String username) {
        // need username to access user and delete user
        ClearInputData clearInputData = new ClearInputData(username);
        clearUseCaseInteractor.execute(clearInputData);
    }

    public void goToSignUp() {
        clearPresenter.goToSignUp();
    }
}
