//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static final int MOD = 1000000007;

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[2][2];
        result[0][0] = (int)(((long)a[0][0] * b[0][0] + (long)a[0][1] * b[1][0]) % MOD);
        result[0][1] = (int)(((long)a[0][0] * b[0][1] + (long)a[0][1] * b[1][1]) % MOD);
        result[1][0] = (int)(((long)a[1][0] * b[0][0] + (long)a[1][1] * b[1][0]) % MOD);
        result[1][1] = (int)(((long)a[1][0] * b[0][1] + (long)a[1][1] * b[1][1]) % MOD);
        return result;
    }

    public static int[][] power(int[][] a, int n) {
        if (n == 1)
            return a;
        if (n % 2 == 1)
            return multiply(a, power(a, n - 1));
        int[][] halfPower = power(a, n / 2);
        return multiply(halfPower, halfPower);
    }

    static int firstElement(int n) {
        int[][] originalMatrix = {{1, 1}, {1, 0}};
        int[][] result = power(originalMatrix, n);
        return result[1][0] % MOD; // Returns a10 element mod 1000000007
    }
}