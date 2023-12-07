package data_access;

import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FileUserDataAccessObjectTest {
    /**
     * Method under test:
     * {@link FileUserDataAccessObject#FileUserDataAccessObject(String, UserFactory)}
     */
    @Test
    void testConstructor() throws IOException {
        assertFalse((new FileUserDataAccessObject("src/test/resources/users.csv", mock(UserFactory.class))).existsByName("42"));
        assertFalse((new FileUserDataAccessObject("username", mock(UserFactory.class))).existsByName("42"));
        assertThrows(RuntimeException.class, () -> new FileUserDataAccessObject("", mock(UserFactory.class)));
    }




    /**
     * Method under test: {@link FileUserDataAccessObject#save(User)}
     */
    @Test
    void testSave2() throws IOException {
        UserFactory userFactory = mock(UserFactory.class);
        User user = mock(User.class);
        when(user.getName()).thenThrow(new RuntimeException("foo"));
        when(userFactory.create(Mockito.<String>any(), Mockito.<String>any(), Mockito.<ArrayList<String>>any(),
                Mockito.<ArrayList<String>>any())).thenReturn(user);
        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("src/test/resources/users.csv", userFactory);
        User user2 = mock(User.class);
        when(user2.getName()).thenReturn(",");
        assertThrows(RuntimeException.class, () -> fileUserDataAccessObject.save(user2));
        verify(user).getName();
        verify(user2).getName();
        verify(userFactory, atLeast(1)).create(Mockito.<String>any(), Mockito.<String>any(),
                Mockito.<ArrayList<String>>any(), Mockito.<ArrayList<String>>any());
    }

    /**
     * Method under test: {@link FileUserDataAccessObject#get(String)}
     */
    @Test
    void testGet() throws IOException {
        assertNull((new FileUserDataAccessObject("Csv Path", mock(UserFactory.class))).get("janedoe"));
    }
}
