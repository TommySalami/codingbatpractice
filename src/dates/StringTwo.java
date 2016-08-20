package dates;

/**
 * Created by Tommy on 7/27/2016.
 */
public class StringTwo {
    public static void main(String[] args) {
        System.out.println("Codingbat.com/java/String-2");
        System.out.println("Test123".substring("Test123".lastIndexOf("t")));


    }
    public static String doubleChar(String str){
        //Given a string, return a string where for every char in the original, there are two chars.
        char[] charz = str.toCharArray();
        String newString = "";
        for(int i=0;i<str.length();i++) {
        newString= newString + charz[i] + charz[i];
        }
        return newString;
    }
    public static int countHi(String str){
        //Return the number of times that the string "hi" appears anywhere in the given string.
        String newString = "";
        newString="" +str.replaceAll("hi", "");

        int count = str.length() - newString.length();
        return count/2;
    }
    public static boolean catDog(String str) {
        //Return true if the string "cat" and "dog" appear the same number of times in the given string.
        if(str.length()<3) return true;
        else if((str.contains("dog")||str.contains("cat")) && str.length()<6) return false;
        int cat = 0, dog =0;
        for(int i =0;i<str.length()-2;i++) {
            if(str.charAt(i)=='c'&&str.charAt(i+1)=='a'&&str.charAt(i+2)=='t') cat+=1;
            else if(str.charAt(i)=='d'&&str.charAt(i+1)=='o'&&str.charAt(i+2)=='g') dog+=1;
        }
        if(cat==dog) return true;
        else return false;
    }
    public static int countCode(String str) {
        //Return the number of times that the string "code" appears anywhere in the given string,
        //except we'll accept any letter for the 'd', so "cope" and "cooe" count.
        if (str.length()<4) return 0;
        int count = 0;
        for(int i =0;i<str.length()-3;i++){
            if(str.charAt(i)=='c'&&str.charAt(i+1)=='o'&&str.charAt(i+3)=='e') count++;
        }
        return count;
    }

    public static boolean endOther(String a, String b) {
        /* Given two strings, return true if either of the strings appears at the very end of the other string,
    ignoring upper/lower case differences (in other words, the computation should not be "case sensitive").
    Note: str.toLowerCase() returns the lowercase version of a string. */
        a = a.toLowerCase();
        b = b.toLowerCase();
        int aLen = a.length(), bLen = b.length();
        if (a.contains(b)&&a.substring(aLen-bLen,aLen).equals(b)) return true;
        else if (b.contains(a)&&b.substring(bLen-aLen,bLen).equals(a)) return true;
        else return false;
    }
    public static boolean xyzThere(String str) {
        //Return true if the given string contains an appearance of "xyz" where the xyz is not directly
        // preceded by a period (.). So "xxyz" counts but "x.xyz" does not.
        if(str.length()<3) return false;
        else if(str.length()==3&&str.contains("xyz")) return true;
        for(int i =0;i<str.length()-3;i++){
            if(str.charAt(0)=='x'&&str.charAt(1)=='y'&&str.charAt(2)=='z') return true;
            else if (str.charAt(i)!='.'&&str.charAt(i+1)=='x'&&str.charAt(i+2)=='y'&&str.charAt(i+3)=='z') return true;
        }
        return false;
    }
    public static boolean bobThere(String str) {
        //Return true if the given string contains a "bob" string, but where the middle 'o' char can be any char.
        if(str.length()<3) return false;
        for(int i = 0;i<str.length()-2;i++){
            if(str.charAt(i)=='b'&&str.charAt(i+2)=='b')return true;
        }
        return false;
    }
    public static boolean xyBalance(String str) {
        /* A String is xy-balanced if for all the 'x' chars in the string,
        there exists a 'y' char somewhere later in the string. So "xxy" is
        balanced, but "xyx" is not. One 'y' can balance multiple 'x's.
        Return true if the given string is xy-balanced. */

        if(str.contains("x")&&!str.contains("y")) return false;
        else if(!str.contains("x")) return true;
        String ysub = str.substring(str.lastIndexOf("y"));
        return(ysub.contains("x"));
    }
    public static String mixString(String a, String b) {
        /*Given two strings, a and b, create a bigger string made of the first char
        of a, the first char of b, the second char of a, the second char of b,
        and so on. Any leftover chars go at the end of the result.*/
        String mix = "";
        if(a.length()>b.length()){
            for(int i =0;i<b.length();i++){
                mix = mix+a.charAt(i);
                mix = mix+b.charAt(i);
            }
            mix = mix + a.substring(b.length());
        }
        else if(b.length()>a.length()){
            for(int i =0;i<a.length();i++){
                mix = mix+a.charAt(i);
                mix = mix+b.charAt(i);
            }
            mix = mix + b.substring(a.length());
        }
        else{
            for(int i =0;i<a.length();i++){
                mix = mix+a.charAt(i);
                mix = mix+b.charAt(i);
            }
        }
        return mix;
    }
    public static String repeatEnd(String str, int n) {
        /*Given a string and an int n, return a string made of n repetitions of the last n characters
        of the string. You may assume that n is between 0 and the length of the string, inclusive.*/
        String repeat ="";
        for(int i=0;i<n;i++){
            repeat = repeat+str.substring(str.length()-n,str.length());
        }
        return repeat;
    }
    public static String repeatFront(String str, int n) {
        /*Given a string and an int n, return a string made of the first n
        characters of the string, followed by the first n-1 characters of the
        string, and so on. You may assume that n is between 0 and the length of
        the string, inclusive (i.e. n >= 0 and n <= str.length()).*/
        String repeat ="";
        for(int i=0;i<n;i++){
            repeat = repeat+str.substring(0,n-i);
        }
        return repeat;
    }
    public static String repeatSeparator(String word, String sep, int count) {
        /*Given two strings, word and a separator sep, return a big string made of count
        occurrences of the word, separated by the separator string.*/
        String repeat =word;
        if (count<1) return "";
        else if(count==1) return word;
        for(int i=0;i<count-1;i++){
            repeat=repeat+sep+word;
        }
        return repeat;
    }
    public static boolean prefixAgain(String str, int n) {
        /*Given a string, consider the prefix string made of the first N chars of the string.
         Does that prefix string appear somewhere else in the string? Assume that the strin
         g is not empty and that N is in the range 1..str.length().*/
        String pref = str.substring(0,n);
        String remainder = str.substring(n,str.length());
        return(remainder.contains(pref));
    }
    public static boolean xyzMiddle(String str) {
        /*Given a string, does "xyz" appear in the middle of the string? To define middle,
         we'll say that the number of chars to the left and right of the "xyz" must differ
         by at most one.*/
        int strL=str.length();
        if(strL<3) return false;
        else if(strL<5&&str.contains("xyz")) return true;
        else if(strL<5&&!str.contains("xyz")) return false;
        else if(strL%2==0) return (str.substring((strL/2)-2,strL/2+2).contains("xyz"));
        else return (str.substring((strL/2)-1,strL/2+2).contains("xyz"));
    }
    public static String getSandwich(String str) {
        /*A sandwich is two pieces of bread with something in between. Return the string that
         is between the first and last appearance of "bread" in the given string, or return
         the empty string "" if there are not two pieces of bread.*/
        if(str.length()<10) return "";
        else return str.substring(str.indexOf("bread")+5,str.lastIndexOf("bread"));
    }
    public static boolean sameStarChar(String str) {
        for(int i =0;i<str.length()-2;i++){
            if(str.charAt(i)!=str.charAt(i+2)&&str.charAt(i+1)=='*') return false;
        }
        return true;
    }
    public static String oneTwo(String str) {
        /*Given a string, compute a new string by moving the first char to come after the next two chars,
        so "abc" yields "bca". Repeat this process for each subsequent group of 3 chars, so "abcdef"
        yields "bcaefd". Ignore any group of fewer than 3 chars at the end. */
        String piece = "";
        String mix = "";
        if(str.length()<3) return "";
        for(int i =0;i<str.length()-2;i+=3){
            piece = str.substring(i+1,i+3) + str.charAt(i);
            mix = mix + piece;
        }
        return mix;
    }
    public static String zipZap(String str) {
        /*Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with
         'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp". */
        if(str.length()<3) return str;
        char[] charz = str.toCharArray();
        for(int i = 0;i<charz.length-2;i++){
            if (charz[i]=='z'&&charz[i+2]=='p') charz[i+1] =' ';
        }
        String a = new String(charz);
        return a.replaceAll(" ","");

    }
    public static String starOut(String str) {

//        Return a version of the given string, where for every star (*) in the string the star and the chars
//        immediately to its left and right are gone. So "ab*cd" yields "ad" and "ab**cd" also yields "ad".
        char[] charz = str.toCharArray();
        for (int i = 0; i < charz.length - 1; i++) {
            if (str.charAt(i) == '*' || str.charAt(i + 1) == '*') {
                charz[i] = ' ';
                charz[i + 1] = ' ';
            }
        }
        String a = new String(charz);
        a = a.replaceAll("\\*", "");
        return a.replaceAll(" ", "");
    }
    public static String plusOut(String str, String word) {

//        Given a string and a non-empty word string, return a version of the original String where all chars have
//        been replaced by pluses ("+"), except for appearances of the word string which are preserved unchanged.
        if(str.contains(word)){
            str = str.replace(word,"  ");
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)!=' ')
                    str=str.replace(str.substring(i,i+1),"+");
            }
        }
        str=str.replace("  ",word);
        return str;
    }
    public static String wordEnds(String str, String word) {
        /* Given a string and a non-empty word string, return a string made of each char just before and just
         after every appearance of the word in the string. Ignore cases where there is no char before or after
         the word, and a char may be included twice if it is between two words.*/
        char[] charz = str.toCharArray();
        if(!str.contains(word)) return "";
        else if(str.equals(word)) return "";
        int wl = word.length();
        String nstr = "";
        if(str.substring(0,wl).equals(word)) nstr = "" + str.charAt(wl);
        for(int i = 1;i<str.length()-wl;i++){
            if (str.substring(i, i + wl).equals(word)) {
                nstr = nstr + str.charAt(i-1) + str.charAt(i + wl);
            }
        }
        if(str.substring(str.length()-wl).equals(word)) nstr = nstr + str.charAt(str.length()-wl-1);
        return nstr;

        }









}
