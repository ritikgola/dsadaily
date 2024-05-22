//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
       private static int countIntervals(double x, int[] stations) {
        int ret = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            ret += (int)Math.ceil((stations[i + 1] - stations[i]) / x) - 1;
        }
        return ret;
    }

    public static double findSmallestMaxDist(int[] stations, int k) {
        Arrays.sort(stations);
        int n = stations.length;
        double low = 1e-9;
        double high = stations[n - 1] - stations[0];

        while ((high - low) > 1e-6) {
            double mid = low + (high - low) / 2.0;
            int intervals = countIntervals(mid, stations);
            if (intervals > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return Math.round(high * 100.0) / 100.0;
    }
}
