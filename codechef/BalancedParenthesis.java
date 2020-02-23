/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class BalancedParanthesis
{
    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        directedGenerateBalancedParentheses(n, n, "", result);

        return result;

        List<Integer>ints=new ArrayList<>();
        ints.get(0).
    }

    private static void directedGenerateBalancedParentheses( int numLeftParensNeeded,
                                                             int numRightParensNeeded,
                                                             String parenStringInProgress,
                                                             List<String> result ){

        if(numLeftParensNeeded==0&&numRightParensNeeded==0){
            result.add(parenStringInProgress);
            return;
        }

        if(numLeftParensNeeded>0){
            directedGenerateBalancedParentheses(numLeftParensNeeded-1,numRightParensNeeded,parenStringInProgress+"(",result);
        }

        if(numLeftParensNeeded<numRightParensNeeded){
            directedGenerateBalancedParentheses(numLeftParensNeeded,numRightParensNeeded-1,parenStringInProgress+")",result);
        }

    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here

        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        List<String>list=generateParenthesis(n);
        for(String s: list){
            System.out.println(s);
        }


    }
}
