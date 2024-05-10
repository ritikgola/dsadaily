//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(arr, result, new ArrayList<>(), k, 0, 0);
        return result;
    }
    private void backtrack(int[] arr, List<List<Integer>> result, List<Integer> current, int target, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1])
                continue;
            
            if (sum + arr[i] <= target) {
                current.add(arr[i]);
                backtrack(arr, result, current, target, sum + arr[i], i + 1);
                current.remove(current.size() - 1);
            } else {
                break;
            }
        }
    }
}
