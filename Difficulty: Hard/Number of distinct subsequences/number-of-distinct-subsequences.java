//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static final int MOD = 1000000007;
    int distinctSubsequences(String S) {
        // code here
        int n = S.length();
        int[] dp = new int[n + 1];
        int[] last = new int[26];
        
        dp[0] = 1; 
        for (int i = 1; i <= n; i++) {
            dp[i] = (2 * dp[i - 1]) % MOD;
            int ch = S.charAt(i - 1) - 'a';
            
            
            if (last[ch] != 0) {
                dp[i] = (dp[i] - dp[last[ch] - 1] + MOD) % MOD;
            }
            
            
            last[ch] = i;
        }
        return dp[n];
    }
}