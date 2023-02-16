//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int dp[];
    public static int goodStones(int n, int[] arr) {
        dp=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++){
            if(dp[i]==-1)
            dp[i]=fun(i,arr);
        }
        int ans=0;
        for(int i:dp){
            if(i==1){
                ans++;
            }
        }
        return ans;
    }
    public static int fun(int i,int arr[])
    {
        if(i<0 || i>=arr.length)return 1;
        if(dp[i]!=-1){
            return dp[i];
        }
        dp[i]=0;
        return dp[i]=fun(i+arr[i],arr);
    }
}
