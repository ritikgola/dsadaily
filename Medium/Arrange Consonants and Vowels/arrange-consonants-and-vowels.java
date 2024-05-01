//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
         Node vowelsHead = null, vowelsTail = null;
        Node consonantsHead = null, consonantsTail = null;
        
        // Traverse the linked list
        Node curr = head;
        while (curr != null) {
            // Check if the current node is a vowel or consonant
            if (isVowel(curr.data)) {
                // Append to vowels list
                if (vowelsHead == null) {
                    vowelsHead = vowelsTail = curr;
                } else {
                    vowelsTail.next = curr;
                    vowelsTail = curr;
                }
            } else {
                // Append to consonants list
                if (consonantsHead == null) {
                    consonantsHead = consonantsTail = curr;
                } else {
                    consonantsTail.next = curr;
                    consonantsTail = curr;
                }
            }
            // Move to the next node
            curr = curr.next;
        }
        
        // Merge the two lists
        if (vowelsHead == null) {
            return consonantsHead;
        }
        vowelsTail.next = consonantsHead;
        if (consonantsTail != null) {
            consonantsTail.next = null;
        }
        
        // Return the head of the merged list
        return vowelsHead;
    }
    
    // Function to check if a character is a vowel
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}