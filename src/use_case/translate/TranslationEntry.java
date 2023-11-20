
package use_case.translate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TranslationEntry {
    private final String inLanguage;
    private final String translation;
    private final String outLanguage;
    private final Date time;


    public TranslationEntry(String inLanguage, String translation, String outLanguage, Date time) {
        this.inLanguage = inLanguage;
        this.translation = translation;
        this.outLanguage = outLanguage;
        this.time = time;
    }

    public String getTranslation(){
        return translation;
    }

    public String getTime(){
        SimpleDateFormat timeFormatted = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return timeFormatted.format(time);
    }

    public String getInLanguage() {return inLanguage;}

    public String getOutLanguage() {return outLanguage;}
}
