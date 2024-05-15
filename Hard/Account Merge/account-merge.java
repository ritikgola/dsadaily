//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  static class DSU {
        Map<String, String> parent = new HashMap<>();
        
        public String find(String s) {
            if (!parent.containsKey(s)) {
                parent.put(s, s);
            }
            if (!s.equals(parent.get(s))) {
                parent.put(s, find(parent.get(s)));
            }
            return parent.get(s);
        }
        
        public void union(String s1, String s2) {
            String p1 = find(s1);
            String p2 = find(s2);
            if (!p1.equals(p2)) {
                parent.put(p1, p2);
            }
        }
    }
    
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();
        
        // Step 1: Build the union-find structure
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                dsu.union(firstEmail, email);
                emailToName.put(email, name);
            }
        }
        
        // Step 2: Group emails by their root parent
        Map<String, Set<String>> rootToEmails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = dsu.find(email);
            rootToEmails.computeIfAbsent(root, k -> new HashSet<>()).add(email);
        }
        
        // Step 3: Create the merged account lists
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : rootToEmails.entrySet()) {
            String rootEmail = entry.getKey();
            Set<String> emails = entry.getValue();
            List<String> account = new ArrayList<>(emails);
            Collections.sort(account);
            account.add(0, emailToName.get(rootEmail)); // Add the name at the front
            mergedAccounts.add(account);
        }
        
        return mergedAccounts;
    }
}
     