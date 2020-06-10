package news.util;

import java.util.Arrays;
import java.util.List;

public class TextEditor {
    public static List<String> makeNewsTextForParagraphs(String text){
        return Arrays.asList(text.split("[\\r\\n]{2,}"));
    }
}
