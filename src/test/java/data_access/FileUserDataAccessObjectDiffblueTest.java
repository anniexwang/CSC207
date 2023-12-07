package data_access;

import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileUserDataAccessObjectTest2 {
    @Test
    void testConstructor() throws IOException {
        assertDoesNotThrow(() -> new FileUserDataAccessObject("src/test/resources/users.csv", mock(UserFactory.class)));
        assertThrows(RuntimeException.class, () -> new FileUserDataAccessObject("", mock(UserFactory.class)));
    }

    @Test
    void testSave() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        User user = mock(User.class);
        when(user.getName()).thenReturn("testUser");
        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("src/test/resources/users.csv", userFactory);
        assertDoesNotThrow(() -> fileUserDataAccessObject.save(user));
    }

    @Test
    void testGet() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        User user = mock(User.class);
        when(user.getName()).thenReturn("testUser");
        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("src/test/resources/users.csv", userFactory);
        fileUserDataAccessObject.save(user);
        assertNotNull(fileUserDataAccessObject.get("testUser"));
        assertNull(fileUserDataAccessObject.get("nonExistingUser"));
    }

    @Test
    void testAddTranslation() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        User user = mock(User.class);
        when(user.getName()).thenReturn("testUser");
        when(user.getTranslationHistory()).thenReturn(new ArrayList<>());
        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("src/test/resources/users.csv", userFactory);
        fileUserDataAccessObject.save(user);
        assertDoesNotThrow(() -> fileUserDataAccessObject.addTranslation("testUser", Arrays.asList("Hello", "Hola")));
    }

    @Test
    void testUpdateAccounts() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        User user = mock(User.class);
        when(user.getName()).thenReturn("testUser");
        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("src/test/resources/users.csv", userFactory);
        fileUserDataAccessObject.save(user);
        assertDoesNotThrow(() -> fileUserDataAccessObject.updateAccounts());
    }

    @Test
    void testExistsByName() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        User user = mock(User.class);
        when(user.getName()).thenReturn("testUser");
        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("src/test/resources/users.csv", userFactory);
        fileUserDataAccessObject.save(user);
        assertTrue(fileUserDataAccessObject.existsByName("testUser"));
        assertFalse(fileUserDataAccessObject.existsByName("nonExistingUser"));
    }
}