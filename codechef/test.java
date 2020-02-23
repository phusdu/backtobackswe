/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        //code

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            Integer arr[]=new Integer[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Integer arrNew[]=sortBySetBitCount(arr,arr.length);
            printArr(arrNew,n);
            System.out.print("\n");
        }
    }


    private static void printArr(Integer[] arr, int n)
    {
        // TODO Auto-generated method stub
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        // cout << arr[i] << " ";
    }

    private static Integer[] sortBySetBitCount(Integer[] arr, int n)
    {
        // TODO Auto-generated method stub
        Arrays.sort(arr, new Comparator<Integer>()
        {

            @Override
            public int compare(Integer arg0, Integer arg1)
            {
                // TODO Auto-generated method stub
                int c1 = Integer.bitCount(arg0);
                int c2 = Integer.bitCount(arg1);
                if (c1 <= c2)
                    return 1;
                else
                    return -1;
            }

        });
        return arr;
    }
}