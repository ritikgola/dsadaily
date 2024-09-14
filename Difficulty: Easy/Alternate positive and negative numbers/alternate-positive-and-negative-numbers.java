//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Step 1: Separate positive and negative numbers
        for (int num : arr) {
            if (num >= 0) {
                pos.add(num); // Consider 0 as positive
            } else {
                neg.add(num);
            }
        }

        // Step 2: Merge alternately
        int i = 0, j = 0, k = 0;
        while (i < pos.size() && j < neg.size()) {
            if (k % 2 == 0) {
                arr.set(k++, pos.get(i++)); // Place positive number
            } else {
                arr.set(k++, neg.get(j++)); // Place negative number
            }
        }

        // Step 3: Append remaining positive numbers
        while (i < pos.size()) {
            arr.set(k++, pos.get(i++));
        }

        // Step 4: Append remaining negative numbers
        while (j < neg.size()) {
            arr.set(k++, neg.get(j++));
        }
    }
}