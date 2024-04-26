//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int[] ans = ob.FindExitPoint(n, m, matrix);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        // code here
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0, dir = 0;
        while (true) {
            if (matrix[row][col] == 1) {
                dir = (dir + 1) % 4;
                matrix[row][col] = 0;
            }
            row += directions[dir][0];
            col += directions[dir][1];
            if (row < 0 || row >= n || col < 0 || col >= m) {
                if (row < 0) row++;
                else if (row >= n) row--;
                else if (col < 0) col++;
                else if (col >= m) col--;
                return new int[]{row, col};
            }
        }
    }
}