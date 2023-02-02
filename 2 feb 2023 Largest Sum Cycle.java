//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
      static int ans = -1;
    static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int curr, boolean visit[], boolean stack[], int par[], int park) {
        visit[curr] = true;
        stack[curr] = true;
        par[curr] = park + curr;
        for (int x: adj.get(curr)) {
            if (stack[x]) {
                ans = Math.max(ans, ((par[curr] + x) - par[x]));
                stack[curr] = false;
                return true;
            }
            if (!visit[x] && isCycle(adj, x, visit, stack, par, par[curr])) {
                stack[curr] = false;
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    public long largesSumCycle(int N, int Edge[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N; i++) {
            if (Edge[i] != -1) {
                adj.get(i).add(Edge[i]);
            }
        }
        boolean visit[] = new boolean[N+1];
        boolean stack[] = new boolean[N+1];
        int par[] = new int[N+1];
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                isCycle(adj, i, visit, stack, par, 0);
            }
        }
        int vk = ans;
        ans = -1;
        return vk;
        
    }
}
