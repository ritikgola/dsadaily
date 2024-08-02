//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String str1, String str2) {
        // Code here
        int m = str1.length();
        int j = str2.length();
        
        // Create a 2D array to store results of subproblems
        int[][] dp = new int[m + 1][j + 1];
        
        // Fill dp[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int k = 0; k <= j; k++) {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i == 0) {
                    dp[i][k] = k;
                }
                // If second string is empty, only option is to
                // remove all characters of first string
                else if (k == 0) {
                    dp[i][k] = i;
                }
                // If last characters are the same, ignore last character
                // and recur for remaining strings
                else if (str1.charAt(i - 1) == str2.charAt(k - 1)) {
                    dp[i][k] = dp[i - 1][k - 1];
                }
                // If last character is different, consider all possibilities
                // and find the minimum
                else {
                    dp[i][k] = 1 + Math.min(dp[i - 1][k - 1], // Replace
                                            Math.min(dp[i - 1][k], // Remove
                                                     dp[i][k - 1])); // Insert
                }
            }
        }
        
        // The answer is the last cell of the matrix
        return dp[m][j];
    }
}