import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    
    private final static String filePath = "D:\\3 course 1 sem\\CPP\\Lab4\\lab4.txt";
    protected static  List<String> listWithTextInBrackets = new ArrayList<>();
    protected static List<String> listWithDeletedText = new ArrayList<>();
    protected static String textFromFile;

    public static String readFromFile() throws FileNotFoundException {
        textFromFile ="";
        File allText = new File(filePath);
        Scanner scanner = new Scanner(allText);
        while (scanner.hasNextLine()){
            String tempText = scanner.nextLine();
            textFromFile +=tempText;
            System.out.println(tempText);
        }
        return textFromFile;
    }

    public static void selectTextInBrackets(String text){
        int size = text.length();
        int i = 0, count = 0;
        String recur = "";
        while (i < size) {
            String temp = "";
            if (text.charAt(i) == '(' && i < size) {
                count++;
                do {
                    temp += text.charAt(i);
                    i++;
                } while (text.charAt(i) != '(' && text.charAt(i) != ')');
                if (text.charAt(i) == ')') {
                    temp += ')';
                    listWithTextInBrackets.add(temp);
                } else recur += temp;
            } else if (text.charAt(i) == ')' && i < size) {
                count--;
                if (i == size-1) break;
                do {
                    if (i == size - 1 || text.charAt(i+1)=='(') break;
                    else i++;
                    temp += text.charAt(i);

                } while (text.charAt(i) != '(' && text.charAt(i) != ')');
                recur += temp;
            } else i++;
        }
        if (count != 0){
            System.out.println("Amount of '(' isn't equal amount of ')' " +
                    "Or text starts with ')' Check your text and try again!");
            listWithTextInBrackets.clear();
        }
        if (recur != "" && count == 0 ) {
            selectTextInBrackets(recur);
        }
    }

    public static void deleteTextInBrackets() throws FileNotFoundException {
        int size = textFromFile.length();
        int i = 0;
        String textWithoutDeepBrackets = "";
        while (i < size) {
            String temp = "";
            if (textFromFile.charAt(i) == '(' && i < size) {
                do {
                    temp += textFromFile.charAt(i);
                    i++;
                } while (textFromFile.charAt(i) != '(' && textFromFile.charAt(i) != ')');
                if (textFromFile.charAt(i) == ')') {
                    textWithoutDeepBrackets += '(';
                    temp += ')';
                    listWithDeletedText.add(temp);
                } else textWithoutDeepBrackets += temp;
            } else {
                textWithoutDeepBrackets += textFromFile.charAt(i);
                i++;
            }
        }
        System.out.println(textWithoutDeepBrackets);
    }
}