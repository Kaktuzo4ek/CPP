public class Main {
    public static void main(String[] args){
        try {
            TextManager.readTextFromConsole();
            try{
                TextManager.searchAndSwapWords();
            }catch (IllegalStateException e){
                System.out.println("There is no word in your text that starts with a vowel!");
            }
        }catch (NullPointerException e){
            System.out.println("Your text is empty!");
        }

    }
}
