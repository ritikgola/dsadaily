//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // code here
         int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Create a 2D array to store the minimum effort to reach each cell
        int[][] effort = new int[rows][columns];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        // Priority Queue to store (effort, x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0}); // Starting with effort 0 at (0, 0)

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentEffort = current[0];
            int x = current[1];
            int y = current[2];

            // If we reached the bottom-right cell, return the effort
            if (x == rows - 1 && y == columns - 1) {
                return currentEffort;
            }

            // Explore all 4 possible directions
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check if the new position is within bounds
                if (nx >= 0 && nx < rows && ny >= 0 && ny < columns) {
                    int nextEffort = Math.max(currentEffort, Math.abs(heights[nx][ny] - heights[x][y]));

                    // If the new calculated effort is less than the stored effort, update and push to pq
                    if (nextEffort < effort[nx][ny]) {
                        effort[nx][ny] = nextEffort;
                        pq.offer(new int[]{nextEffort, nx, ny});
                    }
                }
            }
        }

        // Return the effort to reach the bottom-right cell
        return effort[rows - 1][columns - 1];
    }
}
