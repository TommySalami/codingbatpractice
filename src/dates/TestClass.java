package dates;

import java.util.ArrayList;

/**
 * Created by Tommy on 7/11/2016.
 */
public class TestClass {
    public static void main(String[] args) {


        //System.out.println(missingChar("Fzgdelgot"));

//        System.out.println(max1020(21,10));
       // String str = "HereKittybaby";
//        System.out.println(missingChar(str));
//        System.out.println(missingChar("nog"));


       // System.out.println(test("hexxllo"));

        int i= 2;
        int j = 5;

        String nig = "";
        nig = String.valueOf(j);

    }
    public static int[] maxEnd3(int[] nums) {
        int hi = 0;
        for(int i =0;i<nums.length-1;i++){
            if(hi<nums[i]) hi = nums[i];
        }
        int[] shit = new int[nums.length];
        for(int j = 0;j<nums.length-1;j++){
            nums[j] = hi;
        }

        return nums;
    }





}
