package dates;

/**
 * Created by Tommy on 8/14/2016.
 */
public class StringThree {
    public static void main(String[] args) {
        System.out.println("hi");
    }

    public static int countYZ(String str) {
        str = str.toLowerCase() + " ";
        int count = 0;
        for(int i = 0; i<str.length()-1;i++) {
            if ((str.charAt(i) == 'y' || str.charAt(i) == 'z')
            && !Character.isLetter(str.charAt(i+1)))
                count++;
        }
        return count;
    }

}
