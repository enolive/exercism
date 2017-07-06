import com.google.common.base.Strings;

import java.text.MessageFormat;

public class Twofer {
    public String twofer(String name) {
        String personName =  Strings.isNullOrEmpty(name) ? "you" : name ;
        return MessageFormat.format("One for {0}, one for me.", personName);
    }

}