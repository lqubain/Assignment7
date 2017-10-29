
p
package javaapplication21;


public class JavaApplication21 {

    public static void main(String[] args) {
        String s = "can I affect \"words car bar far\" well I was walking here \"when this cunt walked in\"" +
                    " well \"we're going to try again car bar far tar. \"";
        int quoteCount = numOccurences(s, '\"');  
        int[] anArray = indexArray(quoteCount, s, '\"');
        System.out.println(java.util.Arrays.toString(anArray));
        
        /*for (int i = 0; i + 1< quoteCount + 1; i = i+2) {
            //int indexOfQuote = s.indexOf('\"', i);
            //int indexOfQuote2 = s.indexOf('\"', indexOfQuote + 1);
            String subString = s.substring(anArray[i]+1, anArray[i+1]);
            //System.out.println(subString);
            subString = subString + "      ";
            String changedSubString = bostonAccent(subString);
            System.out.println(changedSubString);*/
            for (int i = 0; i + 1< quoteCount + 1; i = i+2) {
            //int indexOfQuote = s.indexOf('\"', i);
            //int indexOfQuote2 = s.indexOf('\"', indexOfQuote + 1);
            String subString = s.substring(anArray[i] + 1, anArray[i+1]);
            //System.out.println(subString);
            subString = subString + "      ";
            String changedSubString = bostonAccent(subString);
            System.out.println(changedSubString);
            String replaceString = s.replace(subString, changedSubString);
            System.out.println(replaceString);
        }
    
    }
    public static String bostonAccent(String s) {
        StringBuilder newS = new StringBuilder(s);
        String vowel = "AEIOUaeiou";
        String symbol = ".,?/;'\\[]()\"";
        for (int i = 0; i < s.length(); i++) {
            if (vowel.contains("" + s.charAt(i)) && s.charAt(i+1) == 'r' && (s.charAt(i+2) == ' ' || symbol.contains("" +s.charAt(i+2))) ) {
                newS.setCharAt(i+1, 'h');
            }
            
        } 
        return newS.toString();
    }
    public static int numOccurences(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
      
        }
    return count;    
    }
    public static int[] indexArray (int numA, String s, char c){
        int [] anArray = new int[numA];
        int count = 0; 
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c) {
                anArray[count]=i; 
                count++;
            }
        }
        return anArray; 
    }        
}
    

