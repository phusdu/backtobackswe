/* package codechef; // don't place package name! */

import java.lang.Boolean;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc=new Scanner(System.in);
        int t;
        t=sc.nextInt();
        while(t-->0){
            int n;
            n=sc.nextInt();
            int [] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            if(solve(a))
                System.out.println("TRUE");
            else
                System.out.println("FALSE");
        }
    }

    private static Boolean solve(int a[]){
        int count=0;
        for(int i=0;i<a.length-1;i++){
            if(a[i]>=a[i+1]){
                count++;
            }
            if(count>1)
                return false;
            if(a[i-1]>=a[i+1]&&a[i]>=a[i+2])
                return false;
        }

        return true;
    }
}
