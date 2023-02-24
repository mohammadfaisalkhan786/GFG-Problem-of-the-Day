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
            
            String S1[] = read.readLine().split(" ");
            int a = Integer.parseInt(S1[0]);
            int b = Integer.parseInt(S1[1]);
            
            ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
            
            for(int i=0; i<m; i++)
            {
                String S2[] = read.readLine().split(" ");
                int u = Integer.parseInt(S2[0]);
                int v = Integer.parseInt(S2[1]);
                int x = Integer.parseInt(S2[2]);
                int y = Integer.parseInt(S2[3]);
                
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edge.add(x);
                edge.add(y);
                
                edges.add(edge);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestPath(n,m,a,b,edges));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static class pair implements Comparable<pair> {
		int to;
		int number;
 
		pair(int t, int n) {
			number = n;
			to = t;
		}
 
		@Override
		public int compareTo(pair o) {
			return Integer.compare(number, o.number);
		}
 
	}
	
	static int[] dijkstra(int u, int b, int n, ArrayList<pair>[] adj) {
	    int[] dis = new int[n+1];
	    for(int i=0; i<=n; i++)
	        dis[i] = 1000000001;
	    
	    PriorityQueue<pair> pq = new PriorityQueue<>();
	    dis[u] = 0;
	    pq.add(new pair(u, 0));
	    
	    while (!pq.isEmpty())
		{
			pair cur = pq.poll();
			int v = cur.to;
			for (pair vs : adj[v])
			{
			    int y = vs.to;
			    int w = vs.number;
				if (dis[y] > dis[v] + w)
				{
					dis[y] = w + dis[v];
					pq.add(new pair(y,dis[y]));
				}
			}
		}
		
		return dis;
	}
	
    static int shortestPath(int n, int m, int a, int b, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<pair>[] adj = new ArrayList[n+1];
        ArrayList<ArrayList<Integer>> curved = new ArrayList<>();
        
        for(int i=0; i<=n; i++)
			adj[i] = new ArrayList<>();
			
		for(int i=0; i<m; i++)
		{
		    int u = edges.get(i).get(0);
		    int v = edges.get(i).get(1);
		    int w = edges.get(i).get(2);
		    int cw = edges.get(i).get(3);
		    adj[u].add(new pair(v, w));
			adj[v].add(new pair(u, w));
			
			ArrayList<Integer> temp = new ArrayList<>();
            temp.add(u);
            temp.add(v);
            temp.add(cw);
            curved.add(temp);
		}
		
		int[] da = dijkstra(a, b, n, adj);
        int[] db = dijkstra(b, a, n, adj);
        
        int ans = da[b];
        
        
        for(int i=0; i<m; i++)
        {
            int u = curved.get(i).get(0);
            int v = curved.get(i).get(1);
            int cw = curved.get(i).get(2);
    
            ans = Math.min(ans, da[u] + cw + db[v]);
            ans = Math.min(ans, da[v] + cw + db[u]);
        }
        
        if(ans>=1000000001) return -1;
        return ans;
    }
};
