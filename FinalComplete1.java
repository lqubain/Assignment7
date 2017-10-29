/*John Mancini
 * Assignment 7
 * 10/25/2017
 * Section 7
 * This program creates a string based on the words from a url and alters this string to give
it a "Boston" accent. Then the program saves the new altered string into a a text file.
 */
package finalcomplete1;
import java.io.*;
import java.net.*;
public class FinalComplete1 {

    public static void main(String[] args) throws ConnectException {
        String s = getWebContents("http://www.gutenberg.org/files/76/76-0.txt");
        
        //Runs the initial string throug the very method to replace very / VERY with wicked/ WICKED
        String replacevery = (replacevery(s));
	String replaceVery = replaceVery(replacevery);
        String replaceVERY = (replaceVERY(replaceVery));
        
        //Creates an array of r's with their respecfive location within the string
        int countR = (numOccurences(replaceVERY, 'r'));
        int[] anArrayR = indexArray(countR, replaceVERY, 'r');
        
        //replaces r wah if the preceding letters of r were "oo" in string replaceVERY
        String replaceWAH = replaceWAH(replaceVERY, anArrayR);
        
        //Creates an array of R's with their respective location in String replaceWAH
        int countCapR = (numOccurences(replaceWAH, 'R'));
        int [] anArrayRCap = (indexArray(countCapR, replaceWAH, 'R'));
        
        //replaces R with WAH if the preceding letters of R were "OO" in string replaceWAH
        String replaceWAHCap = replaceWAHCap(replaceWAH, anArrayRCap);
        
        //Creates new array just like one above but using string replaceWAHCap
        int countR2 = (numOccurences(replaceWAHCap, 'r'));
        int [] anArrayR2 = indexArray(countR2, replaceWAHCap, 'r');
        
        //replaces the letter r with "yah" if r is preceeded by "ee" or 'I'
        String replaceYAH = replaceYAH(replaceWAHCap, anArrayR2);
        
        //Creates new array just like one above but using string replaceYAH
        int countRCap2 = (numOccurences(replaceYAH, 'R'));
        int [] anArrayRCap2 = indexArray(countRCap2, replaceYAH, 'R');
        
        //replaces the letter R with "YAH" if R is preceeded by "EE" or 'I'
        String replaceYAHCap = replaceYAHCap(replaceYAH, anArrayRCap2);
        
        //This replaces the letter r with h if r is preceeded by a vowel usign string replaceYAHCap
        String replaceRH = replaceRH(replaceYAHCap);
        
        //This creates an array for the letter a and its respective location using string replaceRH
        int countA = (numOccurences(replaceRH, 'a'));
        int [] anArrayA = indexArray(countA,replaceRH, 'a');
        
        //This appends an 'r' to any word ending with 'a' using the string replaceRH
        String appendAR = appendAR(replaceRH, anArrayA);
        
        //This creates an array for the letter A and its respective location using the string appendAR 
        int countACap = (numOccurences(appendAR, 'A'));
        int [] anArrayACap = indexArray(countACap, appendAR, 'A');
        
        //This appends an 'R' to any word ending with 'A' using the string appendAR 
        String finalScriptMarkTwain = appendARCap(appendAR, anArrayACap);
        
        //This saves the final altered string into a text file
        saveDoc(finalScriptMarkTwain, "Brody-Crib-Sheet.txt");
        }
    //this replaces lowercase very with wicked
    public static String replacevery(String s) {
        String newS = s.replace(" very", " wicked");
        return newS;
    }
    //this replaces a Very at the beginning of a sentence with Wicked
    public static String replaceVery (String s) {
	String newS = s.replace("Very", "Wicked");
	return newS;
    }
    //this replaces upperse VERY with WICKED
    public static String replaceVERY (String s) {
        String newS = s.replace(" VERY", " WICKED");
        return newS;
    }
    //replaces 'r' with "wah" if "oo" preceedes 
        public static String replaceWAH (String s, int [] anArray) {
        s = addSpace(s);
        int count = 0;
        StringBuilder str = new StringBuilder(s);
        int arrLength = anArray.length; 
        for (int i=0; i<arrLength; i++){
            if (((s.charAt(anArray[i] - 1) == 'o' && s.charAt(anArray[i] - 2) == 'o')) && (s.charAt(anArray[i] + 1) == ' ' || isSymbol(s.charAt(anArray[i] + 1)))) {
                str.setCharAt(anArray[i] + count, 'w');
                str.insert(anArray[i] + 1 + count,"ah");
                count += 2;
        
            }
        
        }
        return str.toString();
    }
        //replaced 'R' with "WAH" if preceeded by "OO"
    public static String replaceWAHCap (String s, int [] anArray) {
        int count = 0;
        StringBuilder str = new StringBuilder(s);
        int arrLength = anArray.length;
        for (int i = 0; i < arrLength; i++) {
            if  ((((s.charAt(anArray[i] - 1) == 'O' && s.charAt(anArray[i] - 2) == 'O')) && (s.charAt(anArray[i] + 1) == ' ' || isSymbol(s.charAt(anArray[i] + 1))))) {
                str.setCharAt(anArray[i] + count, 'W');
                str.insert(anArray[i] + 1 + count,"AH");
                count += 2;
            }
        }
        return str.toString();
    }
         //replaces 'r' with "yah" if preceeded by "ee" and 'i'
    public static String replaceYAH (String s, int [] anArray){
        s = addSpace(s);
        int count = 0;
        StringBuilder str = new StringBuilder(s);
        int arrLength = anArray.length; 
        for (int i=0; i<arrLength; i++){
            if ((testiI(s.charAt(anArray[i] - 1)) || (s.charAt(anArray[i] - 1) == 'e' && s.charAt(anArray[i] - 2) == 'e')) && (s.charAt(anArray[i] + 1) == ' ' || isSymbol(s.charAt(anArray[i] + 1)))) {
                str.setCharAt(anArray[i] + count, 'y');
                str.insert(anArray[i] + 1 + count,"ah");
                count += 2;
        
            }
        
        }
        return str.toString();
    }
    //replaces 'R' with "YAH" if preceeded by "EE" or 'I'
    public static String replaceYAHCap(String s, int [] anArray) {
        int count = 0;
        StringBuilder str = new StringBuilder(s);
        int arrLength = anArray.length; 
        for (int i=0; i<arrLength; i++){
            if ((testiI(s.charAt(anArray[i] - 1)) || (s.charAt(anArray[i] - 1) == 'E' && s.charAt(anArray[i] - 2) == 'E')) && (s.charAt(anArray[i] + 1) == ' ' || isSymbol(s.charAt(anArray[i] + 1)))) {
                str.setCharAt(anArray[i] + count, 'Y');
                str.insert(anArray[i] + 1 + count,"AH");
                count += 2;
        
            }
        
        }
        return str.toString();
    }
    //replaces r/R with h/H if r/R is preceeded by vowel
    public static String replaceRH(String s) {
        StringBuilder newS = new StringBuilder(s);
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i + 1) == 'r' && isVowel(s.charAt(i))) {
                newS.setCharAt(i + 1, 'h');
            } 
            if (s.charAt(i+1) == 'R' && isVowel(s.charAt(i))) {
                newS.setCharAt(i+1, 'H');
            }
        }
        return newS.toString();
      
    }
    //appends 'r' to a word ending with 'a'
    public static String appendAR (String s, int [] anArray){
        s = addSpace(s);
        StringBuilder str = new StringBuilder(s);
        int arrLength = anArray.length; 
        int counter = 1; 
        for (int i=0; i<arrLength; i++){
            if ((s.charAt(anArray[i]-1))!=' ' && (s.charAt((anArray[i]+1))==' ' || (isSymbol(s.charAt((anArray[i]+1))))) ) {
                str.insert(anArray[i] + counter, 'r');
                counter++; 
            } 
                             
        } 
        return str.toString();  
    }
    //appends 'R' if word ends with 'A'
    public static String appendARCap(String s, int [] anArray) {
        s = addSpace(s);
        StringBuilder str = new StringBuilder(s);
        int arrLength = anArray.length; 
        int counter = 1; 
        for (int i=0; i<arrLength; i++){
            if ((s.charAt(anArray[i]-1))!=' ' && (s.charAt((anArray[i]+1))==' ' || (isSymbol(s.charAt((anArray[i]+1))))) ) {
                str.insert(anArray[i] + counter, 'R');
                counter++; 
            } 
                             
        } 
        return str.toString();  
    }
    //counts the number of occurences a character appears in a string
    public static int numOccurences(String s, char a) {
        int count = 0;        
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == a) {
                count++;
            }
        }
        return count;
    }
            //creates an array for for a specific character and its place in a string
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
  //returns true if character is i or I
    public static Boolean testiI(char s) {
        String replaceLetters = "iI";
        if (replaceLetters.contains("" + s)) {
            return true;
        }
        return false;
    }


    //returns true if character is vowel
    public static Boolean isVowel(char s) {
        String vowels="aeiouAEIOU";
        if (vowels.contains("" + s)) {
            return true;
        }
        return false;
    }
    //returns true if character is certain symbol
    public static Boolean isSymbol(char s) {
        String letters = "'!?.,;:)(";
        if (letters.contains("" + s)) {
            return true;
        }
        return false;
    }
    //adds space to end of string because Stringoutofbounds error occured
    public static String addSpace(String s) {
        s+= " ";
        return s;
    }
    //extracts all of the words from a url
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
        /* Saves the String contents into a file with name filename.
 * 
 * If the file did not previously exist, it is created.
 * If the file with the same name existed previously, it is overwritten. */
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
        
    
}       

