//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int[] board = new int[n];
        solveNQueens(0, board, results, n);
        return results;
    }

    private void solveNQueens(int col, int[] board, ArrayList<ArrayList<Integer>> results, int n) {
        if (col == n) {
            addSolution(board, results, n);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, col, row)) {
                board[col] = row + 1; // +1 because we need 1-based index result
                solveNQueens(col + 1, board, results, n);
            }
        }
    }

    private boolean isSafe(int[] board, int col, int row) {
        for (int i = 0; i < col; i++) {
            int placedRow = board[i] - 1; // -1 to convert to 0-based index
            if (placedRow == row || Math.abs(placedRow - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }

    private void addSolution(int[] board, ArrayList<ArrayList<Integer>> results, int n) {
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            solution.add(board[i]);
        }
        results.add(solution);
    }
}