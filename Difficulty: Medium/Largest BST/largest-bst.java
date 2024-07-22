//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
   static class Info {
        int size; // size of the subtree
        int max;  // max value in the subtree
        int min;  // min value in the subtree
        int ans;  // size of the largest BST which is subtree of current node
        boolean isBST; // if the subtree is a BST
        
        Info(int size, int max, int min, int ans, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.ans = ans;
            this.isBST = isBST;
        }
    }
    
    public static Info largestBSTUtil(Node node) {
        // Base cases
        if (node == null) {
            return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }
        
        if (node.left == null && node.right == null) {
            return new Info(1, node.data, node.data, 1, true);
        }
        
        // Recursively get Info from left and right subtrees
        Info left = largestBSTUtil(node.left);
        Info right = largestBSTUtil(node.right);
        
        Info current = new Info(0, 0, 0, 0, false);
        
        current.size = 1 + left.size + right.size;
        
        // If the subtree rooted at node is a BST
        if (left.isBST && right.isBST && node.data > left.max && node.data < right.min) {
            current.min = Math.min(left.min, node.data);
            current.max = Math.max(right.max, node.data);
            current.ans = current.size;
            current.isBST = true;
            return current;
        }
        
        // If not a BST
        current.ans = Math.max(left.ans, right.ans);
        current.isBST = false;
        return current;
    }
    
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        return largestBSTUtil(root).ans;
    }
    
}