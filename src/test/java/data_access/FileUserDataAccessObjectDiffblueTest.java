package data_access;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import entity.User;
import entity.UserFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FileUserDataAccessObjectDiffblueTest {
    /**
     * Method under test:
     * {@link FileUserDataAccessObject#FileUserDataAccessObject(String, UserFactory)}
     */
    @Test
    void testConstructor() throws IOException {
        assertFalse((new FileUserDataAccessObject("Csv Path", mock(UserFactory.class))).existsByName("42"));
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
        FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject("Csv Path", userFactory);
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
