import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextManagerTest {
    @Test
    void findFirstVowelWordIndex(){
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        int firstVowelWordIndex = 0;
        String[] words = text.split("\\s");
        Pattern p = Pattern.compile("(\\b[AEIOUYaeiouy][a-z']*\\b)");
        Matcher m = p.matcher(text);
        m.find();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(m.group())) {
                firstVowelWordIndex = i;
            }
        }
        assertTrue(firstVowelWordIndex == 1);
    }

    @Test
    void findLongestWordIndex(){
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        int longestWord = 0;
        int longestWordIndex = 0;
        String[] words = text.split("\\s");
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > longestWord) {
                longestWord = words[i].length();
                longestWordIndex = i;
            }
        }
        assertTrue(longestWordIndex == 10);
    }

    @Test
    void swapWords(){
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        int longestWord = 0;
        int longestWordIndex = 0;
        int firstVowelWordIndex = 0;
        String[] words = text.split("\\s");
        Pattern p = Pattern.compile("(\\b[AEIOUYaeiouy][a-z']*\\b)");
        Matcher m = p.matcher(text);
        m.find();
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > longestWord) {
                longestWord = words[i].length();
                longestWordIndex = i;
            }
            if (words[i].equals(m.group())) {
                firstVowelWordIndex = i;
            }
        }
        String tmp = words[firstVowelWordIndex];
        words[firstVowelWordIndex] = words[longestWordIndex];
        words[longestWordIndex] = tmp;
        assertTrue(words[1].equals("typesetting"));
    }

    @Test
    void findVowelWord(){
        String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        boolean isVowelWord = false;
        String[] words = text.split("\\s");
        Pattern p = Pattern.compile("(\\b[AEIOUYaeiouy][a-z']*\\b)");
        Matcher m = p.matcher(text);
        m.find();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(m.group())) {
                isVowelWord = true;
            }
        }
        assertTrue(isVowelWord);
    }
}
