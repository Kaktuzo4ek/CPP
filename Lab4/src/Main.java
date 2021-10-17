import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("The text was successfully read from the file:");
        FileManager.selectTextInBrackets(FileManager.readFromFile());
        System.out.println("\nFound following text in brackets:");
        for (String st : FileManager.listWithTextInBrackets) {
            System.out.println(st);
        }
        System.out.println("\nReplaced all numbers in brackets with a '#' sign:");
        System.out.println(NumberManager.replaceNumber());
        System.out.println("Removed text in brackets at the deepest level:");
        FileManager.deleteTextInBrackets();
        System.out.println("\nRemoved following text in brackets:");
        for (String st : FileManager.listWithDeletedText) {
            System.out.println(st);
        }
    }
}