package use_case.retrieve_translation;

// more parameters for input and output language
public class RetrieveTranslationInputData
{
    final private String text;
    final private String targetlanguage;
    public RetrieveTranslationInputData(String targetlanguage, String text)
    {
        this.targetlanguage = targetlanguage;
        this.text = text;
    }

    String gettext() {return text;}
    String gettargetlanguage() {return targetlanguage;}
}
