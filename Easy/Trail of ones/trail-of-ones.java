//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int numberOfConsecutiveOnes(int n) {
        // code here
        int MOD = 1000000007;
        
        // Edge case when n is very small
        if (n < 2) {
            return 0;
        }

        // dp0[i] means the number of valid strings of length i ending with 0
        // dp1[i] means the number of valid strings of length i ending with 1
        long[] dp0 = new long[n + 1];
        long[] dp1 = new long[n + 1];
        
        dp0[1] = 1; // "0"
        dp1[1] = 1; // "1"
        
        for (int i = 2; i <= n; i++) {
            dp0[i] = (dp0[i-1] + dp1[i-1]) % MOD;
            dp1[i] = dp0[i-1] % MOD;
        }
        
        // Total number of valid strings
        long validStrings = (dp0[n] + dp1[n]) % MOD;
        
        // Total number of binary strings of length n
        long totalStrings = 1;
        for (int i = 0; i < n; i++) {
            totalStrings = (totalStrings * 2) % MOD;
        }
        
        // Number of strings with consecutive 1s
        long result = (totalStrings - validStrings + MOD) % MOD;
        
        return (int) result;
    }
}
