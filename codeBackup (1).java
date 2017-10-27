import java.util.Arrays; 
import java.util.ArrayList;
import java.util.*; 
/* Laith Qubain
 * 10/27
 * Assignment 7
 * 1068
 */
public class Assignment7 {
    public static void main(String[] args) {
        String script = "very very poor door score score deer door tuna funa stuna door door DOOR FLOOR for  fa  very very poor poor fleer ";
        script = replaceVeryLC(script);
        script = replaceVeryUC(script);
        script = replaceVeryMC(script);
        System.out.println(replace(script));
    }
    public static String replaceVeryLC(String script) {
        String newScript = script.replace("very", "wicked");
        return newScript;
    }
    public static String replaceVeryUC (String script) {
        String newScript = script.replace("VERY", "WICKED");
        return newScript;
    }
    public static String replaceVeryMC (String script) {
        String newScript = script.replace("Very", "Wicked");
        return newScript;
    }
    public static char[] replace (String script){
        ArrayList<Character> scriptARR = new ArrayList<Character>();
        
        for (char c : script.toCharArray()) {
            scriptARR.add(c);
        }        
        
        for (int count = 2 ; count < script.length() ; count ++){
            ArrayList<Character> ahARR = new ArrayList<Character>();
            ahARR.add('a');
            ahARR.add('h');
            if ((((scriptARR.get(count-1) == 'o' && scriptARR.get(count-2) == 'o')) && (scriptARR.get(count+1) == ' ' || isSymbol(scriptARR.get(count+1)))) && (scriptARR.get(count) == 'r')){
                  scriptARR.set(count, 'w');
                  scriptARR.addAll(count+1, ahARR);
              }
        }
        
        for (int count = 2 ; count < script.length() ; count ++){
            ArrayList<Character> ahARR = new ArrayList<Character>();
            ahARR.add('A');
            ahARR.add('H');
            if ((((scriptARR.get(count-1) == 'O' && scriptARR.get(count-2) == 'O')) && (scriptARR.get(count+1) == ' ' || isSymbol(scriptARR.get(count+1)))) && (scriptARR.get(count) == 'R')){
                  scriptARR.set(count, 'W');
                  scriptARR.addAll(count+1, ahARR);
              }
        }
        
        for (int count = 2 ; count < script.length() ; count ++){
            ArrayList<Character> ahARR = new ArrayList<Character>();
            ahARR.add('a');
            ahARR.add('h');
            if (((scriptARR.get(count-1) == 'e' && scriptARR.get(count-2) == 'e')) && (scriptARR.get(count+1) == ' ' || isSymbol(scriptARR.get(count+1)))){
                  scriptARR.set(count, 'y');
                  scriptARR.addAll(count+1, ahARR);
              }
        }
        
        for (int count = 2 ; count < script.length() ; count ++){
            ArrayList<Character> ahARR = new ArrayList<Character>();
            ahARR.add('A');
            ahARR.add('H');
            if (((scriptARR.get(count-1) == 'E' && scriptARR.get(count-2) == 'E')) && (scriptARR.get(count+1) == ' ' || isSymbol(scriptARR.get(count+1)))){
                  scriptARR.set(count, 'Y');
                  scriptARR.addAll(count+1, ahARR);
              }
        }  
        
        for (int count = 1 ; count < script.length() ; count++){
            if ((isVowel(scriptARR.get(count-1)))&&(scriptARR.get(count) == 'r') && ((scriptARR.get(count+1) == ' ') || isSymbol(scriptARR.get(count+1)))){
                scriptARR.set(count, 'h');
            }
        }
        
        for (int count = 1 ; count < script.length() ; count++){
            if ((isVowel(scriptARR.get(count-1)))&&(scriptARR.get(count) == 'R') && ((scriptARR.get(count+1) == ' ') || isSymbol(scriptARR.get(count+1)))){
                scriptARR.set(count, 'H');
            }
        }
        
        for (int count = 1 ; count < script.length() ; count++){
            if ((isLetter(scriptARR.get(count-1)))&&(scriptARR.get(count) == 'a') && ((scriptARR.get(count+1) == ' ') || isSymbol(scriptARR.get(count+1)))){
                scriptARR.add(count+1 , 'r');
            }
        }
        
        for (int count = 1 ; count < script.length() ; count++){
            if ((isLetter(scriptARR.get(count-1)))&&(scriptARR.get(count) == 'A') && ((scriptARR.get(count+1) == ' ') || isSymbol(scriptARR.get(count+1)))){
                scriptARR.add(count+1 , 'R');
            }
        }
        
        char [] finalARR = new char[scriptARR.size()];
        
        for (int count = 0 ; count < scriptARR.size() ; count++){
            finalARR[count] = scriptARR.get(count);
        }
        
        return finalARR; 
    }
    
    public static Boolean isSymbol(char s) {
        String symbols = "'!?.,;:)(";
        if (symbols.contains("" + s)) {
            return true;
        }
        return false;
    }
    
    public static Boolean isVowel(char s) {
        String vowels = "aeiouAEIOU";
        if (vowels.contains("" + s)) {
            return true;
        }
        return false;
    }
    
    public static Boolean isLetter(char s) {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (letters.contains("" + s)) {
            return true;
        }
        return false;
    }
}
