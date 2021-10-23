import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextManager {
    public static String [] sentences;
    public static String finalText = "";

    public static void readTextFromConsole(){
        System.out.println("Enter text:");
        Scanner scanner = new Scanner(System.in);
            String tmp = scanner.nextLine();
            if(tmp.isEmpty()){
                throw new NullPointerException();
            }
            sentences = tmp.split("[?!.]");
            System.out.println();
    }

    public static void searchAndSwapWords() {
        for (int i = 0; i < sentences.length; i++) {
            int longestWord = 0;
            int longestWordIndex = 0;
            int firstVowelWordIndex = 0;
            boolean isVowelWord = false;

            String[] temp = sentences[i].split("\\s");
            Pattern p = Pattern.compile("(\\b[AEIOUYaeiouy][a-z']*\\b)");
            Matcher m = p.matcher(sentences[i]);
            m.find();

            for (int j = 0; j < temp.length; j++) {
                if(temp[j].length() > longestWord) {
                    longestWord = temp[j].length();
                    longestWordIndex = j;
                }
                if(temp[j].equals(m.group())) {
                    firstVowelWordIndex = j;
                    isVowelWord = true;
                }
            }

            int idx = i+1;
            System.out.println("Swap words in sentence " + idx + ": [" + temp[firstVowelWordIndex] + ", " + temp[longestWordIndex] + "]");

            if(isVowelWord) {
                String tmp = temp[firstVowelWordIndex];
                temp[firstVowelWordIndex] = temp[longestWordIndex];
                temp[longestWordIndex] = tmp;
            }else{
                throw new IllegalStateException();
            }

            for (int j = 0; j < temp.length; j++) {
                if(j != 0) {
                    finalText += " ";
                }
                finalText += temp[j];
            }
            finalText += "\n";
        }

        System.out.println("\nSentences:");
        System.out.println(finalText);
    }
}
