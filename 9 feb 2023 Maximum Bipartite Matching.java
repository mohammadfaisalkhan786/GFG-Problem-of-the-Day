//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int m = Integer.parseInt(S[0]);
            int n = Integer.parseInt(S[1]);
            int[][] G = new int[m][n];
            for(int i = 0; i < m; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    G[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            int ans = obj.maximumMatch(G);
            out.println(ans);
       }
       out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int maximumMatch(int[][] G){
        int m = G.length;
        int n = G[0].length;
        int match[]=new int[n];
        Arrays.fill(match,-1);
        int res = 0;
        for (int i = 0; i < m; i++) {
            boolean used[]=new boolean[n];
            if (dfs(G, i, used, match)) res++;
        }
        return res;
    }
    boolean dfs(int[][] G, int u, boolean[] used, int match[]) {
        for (int v = 0; v < G[0].length; v++) {
            if (G[u][v] == 1 && !used[v]) {
                used[v] = true;
                if (match[v] == -1 || dfs(G, match[v], used, match)) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }
}
