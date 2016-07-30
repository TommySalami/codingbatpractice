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
    


}
