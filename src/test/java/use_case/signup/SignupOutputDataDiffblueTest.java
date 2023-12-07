package use_case.signup;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SignupOutputDataDiffblueTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link SignupOutputData#SignupOutputData(String, boolean)}
     *   <li>{@link SignupOutputData#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        assertEquals("janedoe", (new SignupOutputData("janedoe", true)).getUsername());
    }
}
