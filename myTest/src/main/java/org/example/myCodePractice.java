package org.example;

import java.sql.SQLOutput;
import java.util.Arrays;

public class myCodePractice {

    public static void main(String args[])
    {
        //System.out.println(reverseString("Testing"));
        //reversing array
        //int[] x = {3,5,6,7,8};
        //revArray(x);
//        System.out.println(isPal("Test"));
//        System.out.println(isPal("Tggt"));
//        System.out.println(isPalNum(567));
//        System.out.println(isPalNum(565));
        int[] x = {4, 781, 8, 99, 103};
        maxminArray(x);

    }
    public static String reverseString(String str)
    {
        //Get the string and get the length and iterate
        String revStr = "";
        for(int i=0; i< str.length();i++)
        {
            revStr = str.charAt(i) + revStr ;
        }
        return revStr;
    }


    //reversing the arrary
    public static void revArray(int[] intarr)
    {
        System.out.println(Arrays.toString(intarr));
        int[] revarr  = new int[intarr.length];
        int j=0;
        for (int i=intarr.length-1;i>=0;i--)
        {
            revarr[j] = intarr[i];
            j++;
        }
        System.out.println(Arrays.toString(revarr));
    }


    public static boolean isPal(String str)
    {
        String revStr = reverseString(str);
        if (str.equalsIgnoreCase(revStr))
        {
            return true;
        }
        return false;
    }

    //Number palindrome
    public static boolean isPalNum(int num)
    {
        Integer x = num;
        String numStr = x.toString();
        String revStr = reverseString(numStr);
        x = Integer.parseInt(revStr);
        int palNum = x;
        if (num==palNum)
        {
            return true;
        }
        else{
            return false;
        }

    }

    public static void maxminArray(int[] intArr)
    {
        if (intArr.length > 0)
        {
            int maxNum = intArr[0];
            int minNum = intArr[0];
            for(int i=1;i<intArr.length;i++)
            {
                if (intArr[i] > maxNum)
                {
                    maxNum = intArr[i];
                }
                if (intArr[i] < minNum)
                {
                    minNum = intArr[i];
                }
            }
            System.out.println(Arrays.toString(intArr));
            System.out.println("Max Number - " + maxNum);
            System.out.println("Min Number - " + minNum);
        }
        else
        {
            System.out.println("Input is empty");
        }
    }

//Check why all methods have to be in statis
}
