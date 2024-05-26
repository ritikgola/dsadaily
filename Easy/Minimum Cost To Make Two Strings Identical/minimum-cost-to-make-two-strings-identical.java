//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
       
       int m = x.length();
        int n = y.length();
        
        if (m < n) {
            // Ensure that x is the longer string to reduce space usage
            return findMinCost(y, x, costY, costX);
        }
        
        // dp arrays for the current and previous rows
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        
        // Initialize base case for dp[0][j]
        for (int j = 0; j <= n; j++) {
            prev[j] = j * costY;
        }
        
        // Fill the dp table row by row
        for (int i = 1; i <= m; i++) {
            curr[0] = i * costX; // Initialize base case for dp[i][0]
            for (int j = 1; j <= n; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    curr[j] = prev[j - 1]; // Characters match, no cost
                } else {
                    curr[j] = Math.min(prev[j] + costX, curr[j - 1] + costY); // Minimum cost of deleting from x or y
                }
            }
            // Swap curr and prev arrays
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        // The result is in prev[n] because we've swapped at the end of the loop
        return prev[n];
    }
}
