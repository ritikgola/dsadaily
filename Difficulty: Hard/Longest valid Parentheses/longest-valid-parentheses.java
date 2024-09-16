//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int max_length=0;
        
        for(int i=0; i<S.length(); i++){
            char c =S.charAt(i);
            
            if(c=='('){
                s.push(i);
            }
            else{
                s.pop();
                
                if(s.isEmpty()){
                    s.push(i);
                }
                else{
                    int length = i-s.peek();
                    max_length=Math.max(max_length, length);
                }
            }
            
        }
        return max_length;
    }
}