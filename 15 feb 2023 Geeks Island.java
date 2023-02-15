//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int water_flow(int [][] mat, int N, int M) {
		 boolean[][] io = new boolean[N][M];
         boolean[][] as = new boolean[N][M];
 for(int i=0; i<N; i++){
     for(int j=0; j<M; j++){
         if((i==0 || j==0)){
             dfs(i, j, mat, i, j, io );
         }
         if((i==N-1 || j==M-1))
             dfs(i, j, mat, i, j, as);   
     }
 }
 int cnt=0;
 for(int i=0; i<N; i++){
     for(int j=0; j<M; j++){
         if(io[i][j] && as[i][j])
             cnt++;
     }
 }
 return cnt;
}
 void dfs(int i, int j, int[][] mat, int u, int v, boolean[][] res){
     if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || res[i][j] || mat[u][v] > mat[i][j]){
         return;
 }
     res[i][j] = true;
     dfs(i, j+1, mat, i, j, res);
     dfs(i+1, j, mat, i, j, res);
     dfs(i-1, j, mat, i, j, res);
     dfs(i, j-1, mat, i, j, res);
	}
}
