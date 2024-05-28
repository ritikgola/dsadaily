//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int w;
            w = Integer.parseInt(br.readLine());

            int[] cost = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumCost(n, w, cost);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int[] dp = new int[w + 1];
        for (int i = 0; i <= w; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // Base case: minimum cost to get 0 kg of oranges is 0
        dp[0] = 0;

        // Fill dp array
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= n; j++) {
                if (j <= i && cost[j - 1] != -1 && dp[i - j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - j] + cost[j - 1]);
                }
            }
        }

        // If dp[w] is still infinity, it means we can't get exactly w kg of oranges
        return dp[w] == Integer.MAX_VALUE ? -1 : dp[w];
    }
}
