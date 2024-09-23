//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
       int n = arr.length;
        
        // Using long to prevent overflow
        long S_n = (long) n * (n + 1) / 2;  // Sum of first n natural numbers
        long S_sq_n = (long) n * (n + 1) * (2 * n + 1) / 6;  // Sum of squares of first n natural numbers

        long sum_actual = 0, sum_sq_actual = 0;
        
        // Calculate actual sum and sum of squares from the array
        for (int i = 0; i < n; i++) {
            sum_actual += arr[i];
            sum_sq_actual += (long) arr[i] * arr[i];
        }

        // Calculating the differences
        long diff_sum = S_n - sum_actual;  // A - B
        long diff_sq_sum = S_sq_n - sum_sq_actual;  // A^2 - B^2
        
        // A^2 - B^2 = (A - B)(A + B) => (A + B) = (A^2 - B^2) / (A - B)
        long sum_A_B = diff_sq_sum / diff_sum;  // A + B

        // Solve for A and B
        int A = (int) (sum_A_B + diff_sum) / 2;
        int B = (int) sum_A_B - A;

        return new int[] {B, A};
    }
}