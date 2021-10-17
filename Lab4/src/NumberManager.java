public class NumberManager {

    public static char[] replaceNumber(){
        String str = "";
        for (String st : FileManager.listWithTextInBrackets) {
            str += st+"\n";
        }
        int i = 0;
        char [] arrayWithoutNumbers = str.toCharArray();
        while (i < arrayWithoutNumbers.length){
            if (isNumber(arrayWithoutNumbers[i])){
                do {
                    arrayWithoutNumbers[i] = '#';
                    i++;
                }while(isNumber(arrayWithoutNumbers[i]) || (isNumber(arrayWithoutNumbers[i+1]) && (arrayWithoutNumbers[i] == '.'|| arrayWithoutNumbers[i] == ',')));
            }
            else i++;
        }
        return arrayWithoutNumbers;
    }

    private static boolean isNumber(char symbol){
        return symbol == '0' || symbol == '1' || symbol == '2' || symbol == '3' || symbol == '4' || symbol == '5'
                || symbol == '6' || symbol == '7' || symbol == '8' || symbol == '9';
    }
}