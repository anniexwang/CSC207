
package use_case.translate;

import java.util.Date;

public class TranslationEntry {
    private final String value;
    private final Date time;

    public TranslationEntry(String value, Date time) {
        this.value = value;
        this.time = time;
    }

    public String getValue(){
        return value;
    }

    public Date getTime(){
        return time;
    }
}


