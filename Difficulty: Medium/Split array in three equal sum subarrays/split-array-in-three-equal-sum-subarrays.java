//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    public List<Integer> findSplit(int[] arr) {
        // Return an array of possible answer, driver code will judge and return true or
        // false based on
        if(arr.length == 0) return Arrays.asList(-1, -1);
        
        int total = 0;
        for(int i : arr) total += i;
        
        if(total % 3 != 0) return Arrays.asList(-1, -1);
        
        int target = total / 3, i = -1, j = -1, count = 0, 
        currSum = 0;
        
        
        for(int end = 0; end < arr.length; end++) {
            currSum += arr[end];
            
            if(currSum == target) {
                count++; currSum = 0;
                
                if(count == 1) i = end;
                else if(count == 2){
                    j = end; break;
                }
            }
        }
        
        if(count >= 2 && j != -1) return Arrays.asList(i, j);
        
        return Arrays.asList(-1, -1);
    }
}