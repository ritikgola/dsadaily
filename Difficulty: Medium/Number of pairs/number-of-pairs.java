//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
     public long countPairs(int x[], int y[], int M, int N) {
        Arrays.sort(y);

        int[] freq = new int[5];
        for (int i = 0; i < N; i++) {
            if (y[i] < 5) {
                freq[y[i]]++;
            }
        }

        long totalPairs = 0;
        for (int i = 0; i < M; i++) {
            totalPairs += count(x[i], y, N, freq);
        }

        return totalPairs;
    }

    static long count(int x, int y[], int N, int[] freq) {
        if (x == 0) return 0;
        if (x == 1) return freq[0];

        int idx = Arrays.binarySearch(y, x);
        if (idx < 0) {
            idx = Math.abs(idx + 1);
        } else {
            while (idx < N && y[idx] == x) {
                idx++;
            }
        }

        long count = N - idx;

        if (x == 2) {
            count -= (freq[3] + freq[4]);
        }

        if (x == 3) {
            count += freq[2];
        }

        count += (freq[0] + freq[1]);

        return count;
    }
}