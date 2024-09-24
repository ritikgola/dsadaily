//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p) {
        if (s.length() < p.length()) {
            return "-1";
        }

        // Frequency map of characters in p
        HashMap<Character, Integer> patternMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        // Sliding window parameters
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0; // To count how many characters of p are found in the current window
        int minStart = 0; // The starting index of the smallest window
        
        // Window frequency map
        HashMap<Character, Integer> windowMap = new HashMap<>();
        
        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            windowMap.put(endChar, windowMap.getOrDefault(endChar, 0) + 1);

            // If the current character matches the frequency in the patternMap, increase the count
            if (patternMap.containsKey(endChar) && windowMap.get(endChar).intValue() <= patternMap.get(endChar).intValue()) {
                count++;
            }

            // If all characters of p are found in the current window
            while (count == p.length()) {
                // Try to minimize the window
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                // Shrink the window by moving start pointer
                char startChar = s.charAt(start);
                windowMap.put(startChar, windowMap.get(startChar) - 1);

                // Check if shrinking causes the window to become invalid
                if (patternMap.containsKey(startChar) && windowMap.get(startChar).intValue() < patternMap.get(startChar).intValue()) {
                    count--;
                }

                start++;
            }
        }

        // If no valid window is found, return "-1"
        if (minLen == Integer.MAX_VALUE) {
            return "-1";
        }

        // Return the smallest window
        return s.substring(minStart, minStart + minLen);
}
}