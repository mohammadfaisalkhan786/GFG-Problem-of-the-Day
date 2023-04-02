//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            s = br.readLine().trim().split(" ");

            int start_x = Integer.parseInt(s[0]);
            int start_y = Integer.parseInt(s[1]);
            int arr[][] = new int[n][m];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    arr[i][j] = Integer.parseInt(s[j]);
            }

            Solution soln = new Solution();
            ot.println(soln.knightInGeekland(arr, start_x, start_y));
            
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    class pair{
        int r,c,s; 
        public pair(int r, int c, int s){
            this.r =r; 
            this.c =c;
            this.s =s;             
        }
    }
    int[] delR ={-2,-2,2,2,1,1,-1,-1};
    int[] delC ={1,-1,1,-1,2,-2,2,-2};
    public int knightInGeekland(int a[][], int x, int y){
        int[] dp = new int[1001];
        Queue<pair> q =new LinkedList<>(); 
        int n=a.length; 
        int m=a[0].length; 
        boolean[][] vis =new boolean[n][m];
        q.offer(new pair(x,y,0)); 
        vis[x][y]= true;
        while(!q.isEmpty()){
            pair cur = q.poll(); 
            dp[cur.s]+=a[cur.r][cur.c];
            for(int i=0; i<8; i++){
                int R =cur.r + delR[i]; 
                int C =cur.c + delC[i]; 
                if(R>=0 && R<n && C>=0 && C<m && !vis[R][C]){
                    vis[R][C]=true;
                    q.offer(new pair(R,C,cur.s+1));
                }
            }
        }
        int max = -1; 
        int ans =-1; 
        for(int i=1000; i>=0; i--){
            if(dp[i]+i < 1000){
              dp[i] += dp[dp[i]+i]; 
            }
            if(dp[i]>=max){
                max = dp[i]; 
                ans =i; 
            }
        }
        return ans;
    }
} 
