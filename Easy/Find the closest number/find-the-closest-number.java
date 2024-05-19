//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findClosest(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findClosest(int n, int k, int[] arr) {
        // code here
        int low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == k) {
                return arr[mid];
            } else if (arr[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        int leftCandidate = (high >= 0) ? arr[high] : Integer.MIN_VALUE;
        int rightCandidate = (low < n) ? arr[low] : Integer.MAX_VALUE;
        
        if (leftCandidate == Integer.MIN_VALUE) {
            return rightCandidate;
        } else if (rightCandidate == Integer.MAX_VALUE) {
            return leftCandidate;
        } else {
            int leftDiff = Math.abs(leftCandidate - k);
            int rightDiff = Math.abs(rightCandidate - k);
            
            if (leftDiff < rightDiff) {
                return leftCandidate;
            } else if (rightDiff < leftDiff) {
                return rightCandidate;
            } else {
                return Math.max(leftCandidate, rightCandidate);
            }
        }
    }
}
        
