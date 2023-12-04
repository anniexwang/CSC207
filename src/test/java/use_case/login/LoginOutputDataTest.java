package use_case.login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginOutputDataTest {

    @Test
    void testGetUsername() {
        String expectedUsername = "testUser";
        LoginOutputData loginOutputData = new LoginOutputData(expectedUsername, false);

        String actualUsername = loginOutputData.getUsername();

        assertEquals(expectedUsername, actualUsername);
    }
}