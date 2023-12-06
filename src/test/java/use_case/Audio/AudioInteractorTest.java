//package use_case.Audio;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//
//import static org.mockito.MockitoAnnotations.openMocks;
//
//class AudioInteractorTest {
//
//    @Mock
//    private AudioInputData mockAudioInputData;
//
//    private AudioInteractor audioInteractorUnderTest;
//
//    private AutoCloseable mockitoCloseable;
//
//    @BeforeEach
//    void setUp() {
//        mockitoCloseable = openMocks(this);
//        audioInteractorUnderTest = new AudioInteractor(mockAudioInputData);
//    }
//
//    @AfterEach
//    void tearDown() throws Exception {
//        mockitoCloseable.close();
//    }
//
//    @Test
//    void testPlay() {
//        // Setup
//        // Run the test
//        audioInteractorUnderTest.play();
//
//        // Verify the results
//    }
//
//    @Test
//    void testPause() {
//        // Setup
//        // Run the test
//        audioInteractorUnderTest.pause();
//
//        // Verify the results
//    }
//
//    @Test
//    void testMute() {
//        // Setup
//        // Run the test
//        audioInteractorUnderTest.mute();
//
//        // Verify the results
//    }
//}
