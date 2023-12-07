package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesController;
import interface_adapter.select_languages.SelectLanguagesViewModel;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import use_case.select_languages.SelectLanguagesInputBoundary;

class SelectLanguagesViewDiffblueTest {
    /**
     * Method under test:
     * {@link SelectLanguagesView#SelectLanguagesView(SelectLanguagesController, SelectLanguagesViewModel, HistoryViewModel)}
     */
    @Test
    void testConstructor() throws IOException {
        SelectLanguagesController selectLanguagesController = new SelectLanguagesController(
                mock(SelectLanguagesInputBoundary.class));
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        assertEquals("Select Languages View", (new SelectLanguagesView(selectLanguagesController, selectLanguagesViewModel,
                new HistoryViewModel())).viewName);
    }

    /**
     * Method under test:
     * {@link SelectLanguagesView#SelectLanguagesView(SelectLanguagesController, SelectLanguagesViewModel, HistoryViewModel)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "interface_adapter.select_languages.SelectLanguagesViewModel.addPropertyChangeListener(java.beans.PropertyChangeListener)" because "this.selectLanguagesViewModel" is null
        //       at view.SelectLanguagesView.<init>(SelectLanguagesView.java:33)
        //   See https://diff.blue/R013 to resolve this issue.

        SelectLanguagesController selectLanguagesController = new SelectLanguagesController(
                mock(SelectLanguagesInputBoundary.class));
        new SelectLanguagesView(selectLanguagesController, null, new HistoryViewModel());

    }

    /**
     * Method under test: {@link SelectLanguagesView#actionPerformed(ActionEvent)}
     */
    @Test
    void testActionPerformed() throws IOException {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        SelectLanguagesController selectLanguagesController = new SelectLanguagesController(
                mock(SelectLanguagesInputBoundary.class));
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        SelectLanguagesView selectLanguagesView = new SelectLanguagesView(selectLanguagesController,
                selectLanguagesViewModel, new HistoryViewModel());
        selectLanguagesView.actionPerformed(new ActionEvent("42", 1, "foo"));
    }

    /**
     * Method under test:
     * {@link SelectLanguagesView#propertyChange(PropertyChangeEvent)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPropertyChange() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ClassCastException: class java.lang.String cannot be cast to class interface_adapter.select_languages.SelectLanguagesState (java.lang.String is in module java.base of loader 'bootstrap'; interface_adapter.select_languages.SelectLanguagesState is in unnamed module of loader com.diffblue.cover.g.g @1de6cbc3)
        //       at view.SelectLanguagesView.propertyChange(SelectLanguagesView.java:98)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        SelectLanguagesView selectLanguagesView = null;
        PropertyChangeEvent evt = null;

        // Act
        selectLanguagesView.propertyChange(evt);

        // Assert
        // TODO: Add assertions on result
    }
}
