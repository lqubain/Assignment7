import java.util.Arrays; 
import java.util.ArrayList;
import java.util.*; 
import java.io.*;
import java.net.*;

/* Laith Qubain
 * 10/27
 * Assignment 7
 * 1068
 */
public class Asssignment7 {
    public static void main(String[] args) {
        String script1= getWebContents("http://www.gutenberg.org/cache/epub/1661/pg1661.txt"); //This method imports the script from the URL to the the string.
        String script = addSpace(script1); 
        script = replaceVeryLC(script);
        script = replaceVeryUC(script);
        script = replaceVeryMC(script);
        String finalScript = new String(replace(script));
        saveDoc(finalScript, "brody-crib-sheet.txt");
    }
    public static String replaceVeryLC(String script) {
        String newScript = script.replace(" very", " wicked");
        return newScript;
    }
    public static String replaceVeryUC (String script) {
        String newScript = script.replace(" VERY", " WICKED");
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
            if (((scriptARR.get(count-1) == 'e' && scriptARR.get(count-2) == 'e')) && (scriptARR.get(count+1) == ' ' || isSymbol(scriptARR.get(count+1)))&& (scriptARR.get(count) == 'r')){
                  scriptARR.set(count, 'y');
                  scriptARR.addAll(count+1, ahARR);
              }
        }
        
        for (int count = 2 ; count < script.length() ; count ++){
            ArrayList<Character> ahARR = new ArrayList<Character>();
            ahARR.add('A');
            ahARR.add('H');
            if ((((scriptARR.get(count-1) == 'E' && scriptARR.get(count-2) == 'E')) && (scriptARR.get(count+1) == ' ' || isSymbol(scriptARR.get(count+1))))&& (scriptARR.get(count) == 'R')){
                  scriptARR.set(count, 'Y');
                  scriptARR.addAll(count+1, ahARR);
              }
        }  
        
        for (int count = 1 ; count < script.length() ; count++){
            if ((isVowel(scriptARR.get(count-1)))&&(scriptARR.get(count) == 'r')){
                scriptARR.set(count, 'h');
            }
        }
        
        for (int count = 1 ; count < script.length() ; count++){
            if ((isVowel(scriptARR.get(count-1)))&&(scriptARR.get(count) == 'R')){
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
    public static String getWebContents(String url) {
        BufferedReader br = null;
        String result = null;
        try {
            URL toFetch = new URL(url);
            br = new BufferedReader(new InputStreamReader(toFetch.openStream()));
            StringBuilder ret = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                ret.append(line+'\n');
                line = br.readLine();
            }
            result = ret.toString();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            System.err.println("Malformed URL:  " + url);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Error reading from URL:  " + url);
        } finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.err.println("Couldn't close connection to url properly:  " + url);
                }
        }
        return result;
        }
    }
    public static void saveDoc(String contents, String filename) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(new File(filename)));
            pw.print(contents);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.err.println("Error writing to file:  " + filename);
        } finally {
            if(pw!=null) {
                pw.close();
            }
        }
    }
    public static String addSpace (String script1){
        String script = script1 + "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t "+
        "\t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t";
        return script; 
    }
}
