package use_case.login;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class LoginInteractorTest {

    private LoginUserDataAccessInterface userDataAccessInterface;
    private LoginOutputBoundary outputBoundary;
    private LoginInteractor loginInteractor;

    @BeforeEach
    void setUp() {
        userDataAccessInterface = mock(LoginUserDataAccessInterface.class);
        outputBoundary = mock(LoginOutputBoundary.class);
        loginInteractor = new LoginInteractor(userDataAccessInterface, outputBoundary);
    }

    @Test
    void testExecute_passwordMismatch() {
        String username = "testUser";
        String password = "testPassword";
        String wrongPassword = "wrongPassword";

        when(userDataAccessInterface.existsByName(username)).thenReturn(true);
        when(userDataAccessInterface.get(username)).thenReturn(new User() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getPassword() {
                return null;
            }

            @Override
            public ArrayList<String> getTranslationHistory() {
                return null;
            }

            @Override
            public ArrayList<String> getFavorites() {
                return null;
            }
        });

        loginInteractor.execute(new LoginInputData(username, wrongPassword));

        verify(outputBoundary, times(1)).prepareFailView("Incorrect password for " + username + ".");
    }

    @Test
    void testExecute_passwordMatch() {
        String username = "testUser";
        String password = "testPassword";

        when(userDataAccessInterface.existsByName(username)).thenReturn(true);
        when(userDataAccessInterface.get(username)).thenReturn(new User() {
            @Override
            public String getName() {
                return "testUser";
            }

            @Override
            public String getPassword() {
                return "testPassword";
            }

            @Override
            public ArrayList<String> getTranslationHistory() {
                return null;
            }

            @Override
            public ArrayList<String> getFavorites() {
                return null;
            }
        });

        loginInteractor.execute(new LoginInputData(username, password));

        verify(outputBoundary, times(1)).prepareSuccessView(any(LoginOutputData.class));
    }
}