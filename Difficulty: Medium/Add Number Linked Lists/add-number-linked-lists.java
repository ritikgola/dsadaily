//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


// } Driver Code Ends
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution {
    static Node removeLeadingZeros(Node head) {
        // Initialize a dummy node to handle edge cases
        Node dummy = new Node(0);
        dummy.next = head;
        // Traverse the list to find the first non-zero node
        Node current = dummy;
        while (current.next != null && current.next.data == 0) {
            current = current.next;
        }
        // Update the head to the first non-zero node
        if (current.next == null) {
        current.next = new Node(0); // Store zero in the next node
        head = current.next;
    } else {
        head = current.next;
    }
        
        return head;}
    static Node reverseList(Node head){
      Node curr=head;
      Node prev=null;
      Node next=head;
      while(curr!=null){
          next=curr.next;
          curr.next=prev;
          prev=curr;
          curr=next;
      }
      return prev;
    }
    static Node addTwoLists(Node num1, Node num2){
      Node dummy=new Node(-1);
        Node temp=dummy;
        int carry=0;
       Node l1= reverseList(num1);
       Node l2= reverseList(num2);
        while(l1!=null ||l2!=null ||carry!=0){
            int data1=0;
            int data2=0;
          if(l1!=null) data1= l1.data;
          if(l2!=null) data2= l2.data;
          int ans=data1+data2+carry;
          carry=ans/10;
          Node sum=new Node(ans%10);
          temp.next=sum;
          temp=temp.next;
          if(l1!=null) l1=l1.next;
          if(l2!=null) l2=l2.next;
        }
        Node result=dummy.next;
       Node anss= reverseList(result);
       Node sol=removeLeadingZeros(anss);
     return sol;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends