package interface_adapter.clear;

import interface_adapter.ViewManagerModel;
import interface_adapter.clear.ClearState;
import interface_adapter.clear.ClearViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.clear.ClearOutputBoundary;
import use_case.clear.ClearOutputData;

public class ClearPresenter implements ClearOutputBoundary {
    // set up View Models
    private final ClearViewModel clearViewModel;
    private final SignupViewModel signupViewModel;
    private ViewManagerModel viewManagerModel;

    // Presenter
    public ClearPresenter(ViewManagerModel viewManagerModel,
                          ClearViewModel clearViewModel,
                          SignupViewModel signupViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.clearViewModel = clearViewModel;
        this.signupViewModel = signupViewModel;
    }
    @Override
    public void prepareSuccessView(ClearOutputData clearData) {
        // takes user back to signup (given account cleared)
        SignupState signupState = signupViewModel.getState();
        this.signupViewModel.setState(signupState);
        this.signupViewModel.firePropertyChanged();
        // set back to signup state
        this.viewManagerModel.setActiveView(signupViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void goToSignUp() {
        this.viewManagerModel.setActiveView(signupViewModel.getViewName()); // Use the correct view name for SignupView
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setClearError(error);
        clearViewModel.firePropertyChanged();
    }
}
