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
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // code here
         int [] maxsuffix = new int[n+1];
         int [] minsuffix =  new int[n+1];
         
          maxsuffix[n]=-1000000000;
          minsuffix[n]=1000000000;
          maxsuffix[n-1]=arr[n-1];
          minsuffix[n-1]=arr[n -1];
          for(int  i=n-2; i>=0; --i){
              maxsuffix[i]=Math.max(maxsuffix[i+1],arr[i]);
              minsuffix[i]=Math.min(minsuffix[i+1],arr[i]);
          }
          int minprefix=arr[0];
          int maxprefix=arr[0];
          int mindiff=maxsuffix[k]-minsuffix[k];
          for(int i=0; i<n;i++){
              if(i+k<=n){
                  int maximum=Math.max(maxsuffix[i+k],maxprefix);
                  int minimum=Math.min(minsuffix[i+k],minprefix);
                  mindiff=Math.min(mindiff,maximum-minimum);
              }
              maxprefix=Math.max(maxprefix,arr[i]);
              minprefix=Math.min(minprefix,arr[i]);
          }
          return mindiff;
    }
}
        
