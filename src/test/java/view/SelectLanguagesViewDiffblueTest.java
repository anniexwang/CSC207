package view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import interface_adapter.history.HistoryViewModel;
import interface_adapter.select_languages.SelectLanguagesController;
import interface_adapter.select_languages.SelectLanguagesViewModel;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import use_case.select_languages.SelectLanguagesInputBoundary;

class SelectLanguagesViewDiffblueTest {
    @Test
    void testConstructor() throws IOException {
        SelectLanguagesController selectLanguagesController = new SelectLanguagesController(
                mock(SelectLanguagesInputBoundary.class));
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        assertEquals("Select Languages View", (new SelectLanguagesView(selectLanguagesController, selectLanguagesViewModel,
                new HistoryViewModel())).viewName);
    }

    @Test
    void testActionPerformed() throws IOException {
        SelectLanguagesController selectLanguagesController = new SelectLanguagesController(
                mock(SelectLanguagesInputBoundary.class));
        SelectLanguagesViewModel selectLanguagesViewModel = new SelectLanguagesViewModel();
        SelectLanguagesView selectLanguagesView = new SelectLanguagesView(selectLanguagesController,
                selectLanguagesViewModel, new HistoryViewModel());
        selectLanguagesView.actionPerformed(new ActionEvent("42", 1, "foo"));
    }
}