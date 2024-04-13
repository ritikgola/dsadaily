//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
        // code here
        String s="";
        for(int i=0; i<=31; i++){
            if((x & (1L<<i)) !=0){
                s='1'+s;
            }
            else{
                s='0'+s;
            }
        }
        long ans=0;
        for(int i=0; i<=31; i++){
            if(s.charAt(i)=='1'){
                ans += Math.pow(2,i);
            }
        }
        return ans;
    }
};