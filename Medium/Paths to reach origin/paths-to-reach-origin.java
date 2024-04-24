//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    public static int ways(int n, int m)
    {
        // Create a 2D array to store the number of paths
        int[][] dp = new int[n+1][m+1];
        
        // Base case: There is only one way to reach (0,0)
        dp[0][0] = 1;
        
        // Fill the first column (when n=0) with 1s
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the first row (when m=0) with 1s
        for (int i = 1; i <= m; i++) {
            dp[0][i] = 1;
        }
        
        // Fill the dp table using bottom-up dynamic programming
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Number of ways to reach (i,j) is the sum of
                // the number of ways to reach (i-1,j) and (i,j-1)
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
        
        // Return the number of ways to reach (n,m)
        return dp[n][m];
    }
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends