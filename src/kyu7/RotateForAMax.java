package kyu7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Dell on 12/31/2016.
 */
public class RotateForAMax {

    /**
     * Take a number: 56789. Rotate left, you get 67895.
     Keep the first digit in place and rotate left the other digits: 68957.
     Keep the first two digits in place and rotate the other ones: 68579.
     Keep the first three digits and rotate left the rest: 68597. Now it is over since keeping the first four it remains only one digit which rotated is itself.
     You have the following sequence of numbers:
     56789 -> 67895 -> 68957 -> 68579 -> 68597  //
     and you must return the greatest: 68957.
     Calling this function max_rot (or maxRot or ... depending on the language)
     max_rot(56789) should return 68957
     */
    public static long maxRot (long n) {

        ArrayList<Character> listNum = longConvertToList(n);
        int listSize = listNum.size();

        long[] listResult = new long[listSize];
        listResult[0] = n;
        for(int i=0; i<listSize-1; i++){
            listNum.add(listNum.get(i));
            listNum.remove(i);
            String strNew = "";
            for(int j=0; j<listSize; j++){
                strNew=strNew+listNum.get(j);
            }
            listResult[i+1] = Long.parseLong(strNew);
        }
        Arrays.sort(listResult);
        return listResult[listNum.size()-1];
    }

    private static ArrayList<Character> longConvertToList(long n){
        String str = String.valueOf(n);
        ArrayList<Character> listNum = new ArrayList<Character>();
        for(int i=0; i<str.length(); i++){
            listNum.add(str.charAt(i));
        }
        return listNum;
    }

    //Other solution
    public static long maxRot2 (long n) {
        String num = String.valueOf(n);

        for (int i = 0; i < num.length() - 1; i++) {
            num = num.substring(0, i) +
                    num.substring(i + 1) +
                    num.charAt(i);

            if (Long.parseLong(num) > n) {
                n = Long.parseLong(num);
            }
        }

        return n;
    }

}
