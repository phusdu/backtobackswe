/**
 O(nlogn) Array Problem Code: BC20R103
 Add problem to Todo list
 Submit


 Given a set of n integers S and an integer x, your task is to determine whether there exist two elements in S whose sum is x. In case no such elements exist in the array, print “NOT AVAILABLE” without the quotes. Otherwise, print “AVAILABLE” without the quotes and the two elements, space-separated.

 Note that the two elements need to be the smallest elements that sum up to x.

 Your solution should run in O(n∗log2n) time.

 Input:
 The first line of the input consists of an integer T denoting the number of test cases. The description of T lines follow.
 The first line of each test case contains an integer n denoting the number of elements in the set and an integer x denoting the summed number, space-separated. The second line contains n space-separated integers denoting the elements of S.
 Output:
 For each testcase, if there exist two elements such that their sum equals x, print “AVAILABLE” with the two elements on the same line. If no such elements exist, print “NOT AVAILABLE” without the quotes.

 Constraints
 2≤n≤740
 −10000≤S[i]≤10000
 −20000≤x≤20000
 Sample Input:
 2
 10 5
 1 2 3 4 5 6 7 8 9 10
 5 -1
 -2 -5 6 8 -10
 Sample Output:
 AVAILABLE 1 4
 NOT AVAILABLE
 EXPLANATION:
 Example test case 1: x=5 and 1+4=5.

 Example test case 2: There is no way to select two elements in the set such that their sum is −1*/


/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        // your code goes here
        Scanner sc=new Scanner(System.in);
        int t;
        t=sc.nextInt();
        while(t-->0){
            int n;
            n=sc.nextInt();
            int x=sc.nextInt();
            int [] a = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }

            if(!hasArrayTwoCandidates(a,n,x))
                System.out.println("NOT AVAILABLE");

        }
    }

    static boolean hasArrayTwoCandidates(int A[],
                                         int arr_size, int sum)
    {


        int l=0,r=0;
        /* Sort the elements */
        Arrays.sort(A);

        /* Now look for the two candidates
        in the sorted array*/
        l = 0;
        r = arr_size - 1;
        while (l < r) {
            if (A[l] + A[r] == sum) {
                System.out.println("AVAILABLE "+(l+1)+" "+(r+1));
                return true;
            }
            else if (A[l] + A[r] < sum)
                l++;
            else // A[i] + A[j] > sum
                r--;
        }
        return false;
    }

    static void printpairs(int arr[], int sum)
    {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.length; ++i) {
            int temp = sum - arr[i];

            // checking for condition
            if (s.contains(temp)) {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
            }
            s.add(arr[i]);
        }
    }

}
