//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        // Your code goes here
        int n = pattern.length();
        int m = str.length();
        
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = false;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char p = pattern.charAt(i - 1);
                char s = str.charAt(j - 1);
                
                if (p == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p == '?' || p == s) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[n][m] ? 1 : 0;
    }
}
