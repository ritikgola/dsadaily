//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
        // add your code here
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        
        int current_sum = 0; // To store the running sum
        int count = 0;       // To count the number of valid subarrays
        
        // Initialize the hashmap with prefix sum 0 occurring once (important for subarrays starting from index 0)
        prefixSumMap.put(0, 1);
        
        // Traverse the array
        for (int num : arr) {
            current_sum += num; // Add the current element to the running sum
            
            // Check if (current_sum - tar) exists in the map
            if (prefixSumMap.containsKey(current_sum - tar)) {
                count += prefixSumMap.get(current_sum - tar);
            }
            
            // Add current_sum to the map (or update its frequency)
            prefixSumMap.put(current_sum, prefixSumMap.getOrDefault(current_sum, 0) + 1);
        }
        
        return count;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int tar = Integer.parseInt(br.readLine());
            Solution obj = new Solution();
            int res = obj.subArraySum(arr, tar);

            System.out.println(res);
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends