
package javaapplication21;


public class JavaApplication21 {

    public static void main(String[] args) {
        String s = "can I affect \"words car bar far\" well I was walking here \"when this cunt walked in\"";
        int quoteCount = numOccurences(s, '\"');   
        for (int i = 0; i< quoteCount; i++) {
            int indexOfQuote = s.indexOf('\"', i);
            int indexOfQuote2 = s.indexOf('\"', indexOfQuote + 1);
            String subString = s.substring(indexOfQuote, indexOfQuote2 + 1);
            String changedSubString = bostonAccent(subString);
            System.out.println(changedSubString);
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
}
    

