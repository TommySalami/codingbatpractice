package dates;

/**
 * Created by Tommy on 7/27/2016.
 */
public class StringTwo {
    public static void main(String[] args) {
        System.out.println("Codingbat.com/java/String-2");


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

        if(str.length()<3) return true;
        else if((str.contains("dog")||str.contains("cat"))
                &&str.length()<6) return false;
        int [] counter = new int[2];
        for(int i =0;i<str.length()-2;i++) {
            if(str.charAt(i)=='c'&&str.charAt(i+1)=='a'&&str.charAt(i+2)=='t'){
                counter[0]+=1;
            }
            else if(str.charAt(i)=='d'&&str.charAt(i+1)=='o'&&str.charAt(i+2)=='g'){
                counter[1]+=1;
            }
        }
        if(counter[0]==counter[1]) return true;
        else return false;
    }


}
