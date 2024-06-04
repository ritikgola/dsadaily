//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        // code here.
        s = s.replaceFirst("^0+(?!$)", "");

        // StringBuilder for the resultant binary string
        StringBuilder sb = new StringBuilder(s);
        int carry = 1;  // Initial carry as we are adding 1

        // Traverse the string from the end to the beginning
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                carry = 0;  // No carry forward needed
                break;
            } else {  // sb.charAt(i) == '1'
                sb.setCharAt(i, '0');
            }
        }

        // If there is still a carry, it means we need to add a new bit at the beginning
        if (carry == 1) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }
}