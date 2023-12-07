package use_case.translate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TranslateInteractorTest {
    @Test
    void testExecute() {
        TranslateOutputBoundary translateOutputBoundary = Mockito.mock(TranslateOutputBoundary.class);
        TranslateUserDataAccessInterface userDataAccess = Mockito.mock(TranslateUserDataAccessInterface.class);
        TranslateInteractor translateInteractor = new TranslateInteractor(translateOutputBoundary, userDataAccess);
        translateInteractor.execute(new TranslateInputData("", "janedoe"));
        verify(translateOutputBoundary).prepareFailView("Translation Field Empty");
    }

    @Test
    void testTranslate() {
        TranslateOutputBoundary translateOutputBoundary = Mockito.mock(TranslateOutputBoundary.class);
        TranslateUserDataAccessInterface userDataAccess = Mockito.mock(TranslateUserDataAccessInterface.class);
        TranslateInteractor translateInteractor = Mockito.spy(new TranslateInteractor(translateOutputBoundary, userDataAccess));
        when(translateInteractor.translate("Hola")).thenReturn("Hello");
        String translated = translateInteractor.translate("Hola");
        assertEquals("Hello", translated);
    }
}