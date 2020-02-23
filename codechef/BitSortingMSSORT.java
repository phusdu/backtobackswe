/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
    public static void main (String[] args) {
        //code
        Scanner scnr=new Scanner(System.in);
        int t=scnr.nextInt();
        while(t>0)
        {
            int n=scnr.nextInt();
            ArrayList<Integer> arr=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                arr.add(scnr.nextInt());
            }

            Collections.sort(arr, new Comparator<Integer>()
            {
                public int compare(Integer one, Integer two)
                {
                    Integer n1=BitCount(one);
                    Integer n2=BitCount(two);
                    return -(n1.compareTo(n2));
                }
            });

            for(int i=0;i<n;i++)
            {
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();


            t--;
        }
    }

    public static int BitCount(int num) {

        int count = 0;
        while (num > 0) {

            if((num&1)!=0)
            {
                count++;
            }
            num=num>>1;

        }

        return count;
    }

}