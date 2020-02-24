/**
 *
 * Interesting Intersection Problem Code: BC20R104
 * Add problem to Todo list
 * Submit
 *
 *
 * An m×n array A of real numbers is an Intersecting array if for all i, j, k and l such that 0≤i<k<m and 0≤j<l<n, we have
 *
 * A[i,j]+A[k,l]≤A[i,l]+A[k,j]
 * In other words, whenever we pick two rows and two columns of an Intersecting array and consider the four elements at the intersections of the rows and columns, the sum of the upper-left and lower-right elements is less than or equal to the sum of the lower-left and upper-right elements. For example, the following array is Intersecting:
 *
 * 37215332432363413212473091532103168
 * The leftmost minimum element in each row of an Intersecting array can be computed as follows:
 *
 * Construct a submatrix A′ of A consisting of the even-numbered rows of A. Recursively determine the leftmost minimum for each row of A′. Then compute the leftmost minimum in the odd numbered rows of A.
 *
 * Given an Intersecting array, your task is to construct an algorithm which finds the leftmost minimum element of all rows of an m×n Intersecting array using the above information in O(m+n) time.
 *
 * Input:
 * The first line of input consists of an integer T denoting the number of test cases. The description of T test cases follow.
 * First line of each test case contains two space-separated integers m and n denoting the dimensions of the array. Then m lines follow.
 * Each line contains n space-separated integers denoting the row entries for that row of the array.
 * Output:
 * For each test-case, print on a single line m integers denoting the leftmost minimum elements of each row of the array.
 *
 * Constraints
 * 1≤T≤100
 * 2≤m≤100
 * 2≤n≤100
 * 0≤A[i]≤10000
 * Sample Input:
 * 1
 * 5 4
 * 37 23 24 32
 * 21 6 7 10
 * 53 34 30 31
 * 32 13 9 6
 * 43 21 15 8
 * Sample Output:
 * 23 6 30 6 8
 * EXPLANATION:
 * 23 is the leftmost minimum element in the first row, 6 is the leftmost minimum element in the second row and so on.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int m,n;
            m = sc.nextInt();
            n = sc.nextInt();
            int x = sc.nextInt();
            int[][] a = new Integer[m][n];
            for (int i = 0; i < m; i++) {
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                }

            }

            Array<Integer>out=mongeLeftmostMinimaIndices(a);
            System.out.println(out);

        }
    }

    /**
     * Returns the leftmost minimum indices in each row of a Monge array.
     * <p>Solution to problem 4-7(d).</p>
     *
     * @param A the Monge array
     * @return the array containing at the {@code i}-th position the leftmost minimum index in the {@code i}-th row of {@code A}
     */
    public static Array<Integer> mongeLeftmostMinimaIndices(Array<Array<Integer>> A) {
        int m = A.length;
        int n = A.at(1).length;
        Array<Integer> leftmostMinimaIndices = Array.ofLength(m);
        if (m >= 2) {
            Array<Integer> leftmostMinimaIndicesOfEvenRows = mongeLeftmostMinimaIndicesOfEvenRows(A);
            for (int i = 2; i <= m; i += 2) {
                leftmostMinimaIndices.set(i, leftmostMinimaIndicesOfEvenRows.at(i / 2));
            }
        }
        for (int i = 1; i <= m; i += 2) {
            int minimumIndexAbove = i > 1 ? leftmostMinimaIndices.at(i - 1) : 1;
            int minimumIndexBelow = i < m ? leftmostMinimaIndices.at(i + 1) : n;
            leftmostMinimaIndices.set(i, mongeLeftmostMinimumIndex(A, i, minimumIndexAbove, minimumIndexBelow));
        }
        return leftmostMinimaIndices;
    }

    private static Array<Integer> mongeLeftmostMinimaIndicesOfEvenRows(Array<Array<Double>> A) {
        int m = A.length;
        Array<Array<Double>> oddRows = Array.ofLength(m / 2);
        for (int i = 2; i <= m; i += 2) {
            int n = A.at(i).length;
            oddRows.set(i / 2, Array.ofLength(n));
            for (int j = 1; j <= n; j++) {
                oddRows.at(i / 2).set(j, A.at(i).at(j));
            }
        }
        Array<Array<Double>> A_ = Array.copyOf(oddRows);
        return mongeLeftmostMinimaIndices(A_);
    }

    private static int mongeLeftmostMinimumIndex(Array<Array<Double>> A, int row, int minimumIndexAbove, int minimumIndexBelow) {
        int leftmostMinimumIndex = minimumIndexAbove;
        double leftmostMinimum = A.at(row).at(leftmostMinimumIndex);
        for (int column = minimumIndexAbove + 1; column <= minimumIndexBelow; column++) {
            if (A.at(row).at(column) < leftmostMinimum) {
                leftmostMinimum = A.at(row).at(column);
                leftmostMinimumIndex = column;
            }
        }
        return leftmostMinimumIndex;
    }

}