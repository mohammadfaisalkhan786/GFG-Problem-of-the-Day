//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static final int MOD = (int)1e9+7;
    static int uniquePaths(int n, int m, int[][] grid) {
        if(grid[0][0] == 0 || grid[n-1][m-1] == 0){
            return 0;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        for(int col = 1; col < m; col++){
            if(grid[0][col] == 1){
                dp[0][col] = dp[0][col-1];
            }
            else{
                dp[0][col] = 0;
            }
        }
        for(int row = 1; row < n; row++){
            if(grid[row][0] == 1){
                dp[row][0] = dp[row-1][0];
            }
            else{
                grid[row][0] = 0;
            }
        }
        for(int row = 1; row < n ; row++){
            for(int col = 1; col < m; col++){
                if(grid[row][col] == 1){
                    dp[row][col] = (dp[row-1][col]%MOD + dp[row][col-1]%MOD)%MOD;
                }
                else{
                    dp[row][col] = 0;
                }
            }
        }
        return dp[n-1][m-1];
    }
};
