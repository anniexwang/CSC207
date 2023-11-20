//import com.google.api.services.translate.Translate;
//
//public class GoogleTranslateExample {
//
//    public static void main(String[] args) {
//
//       // TranslateOptions.newBuilder().setApiKey( "AIzaSyCC_mFDQSVf2T-tumVGFEtEey7z0YhdJiw").build();
//
//
//        Translate translate = TranslateOptions.getDefaultInstance().getService();
//
//        String originalText = "Hello, World!";
//        Translation translation = translate.translate(
//                originalText,
//                TranslateOption.sourceLanguage("en"),
//                TranslateOption.targetLanguage("es")
//        );
//
//        System.out.printf("Original Text: %s%n", originalText);
//        System.out.printf("Translated Text: %s%n", translation.getTranslatedText());
//    }
//}