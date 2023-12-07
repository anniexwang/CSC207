// Test for SignupViewModel
package interface_adapter.signup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SignupViewModelTest {
    @Test
    void testGetState() {
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupState signupState = new SignupState();
        signupViewModel.setState(signupState);
        assertEquals(signupState, signupViewModel.getState());
    }

    @Test
    void testSetState() {
        SignupViewModel signupViewModel = new SignupViewModel();
        SignupState signupState = new SignupState();
        signupViewModel.setState(signupState);
        assertEquals(signupState, signupViewModel.getState());
    }
}