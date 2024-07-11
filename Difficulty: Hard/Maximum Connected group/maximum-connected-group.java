//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution {
    private int n;
    private int[][] grid;
    private int[][] visited;
    private int[] componentSize;
    private int componentId = 2; // Start component IDs from 2 because grid contains only 0s and 1s.
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};
    
    public int MaxConnection(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        this.visited = new int[n][n];
        this.componentSize = new int[n * n + 2]; // To hold size of each component
        
        // Find all components of 1's and their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int size = dfs(i, j, componentId);
                    componentSize[componentId] = size;
                    componentId++;
                }
            }
        }
        
        // Find the largest connected component if we flip one 0 to 1
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborComponents = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (isValid(ni, nj) && grid[ni][nj] == 1) {
                            neighborComponents.add(visited[ni][nj]);
                        }
                    }
                    int possibleSize = 1; // Changing this 0 to 1
                    for (int id : neighborComponents) {
                        possibleSize += componentSize[id];
                    }
                    maxSize = Math.max(maxSize, possibleSize);
                }
            }
        }
        
        // Consider the original component sizes as well, in case we don't flip any 0 to 1
        for (int id = 2; id < componentId; id++) {
            maxSize = Math.max(maxSize, componentSize[id]);
        }
        
        return maxSize;
    }
    
    private int dfs(int x, int y, int id) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = id;
        int size = 0;
        
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int i = cell[0];
            int j = cell[1];
            size++;
            for (int d = 0; d < 4; d++) {
                int ni = i + dx[d];
                int nj = j + dy[d];
                if (isValid(ni, nj) && grid[ni][nj] == 1 && visited[ni][nj] == 0) {
                    visited[ni][nj] = id;
                    stack.push(new int[]{ni, nj});
                }
            }
        }
        return size;
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}