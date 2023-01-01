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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.compute_value(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Solution
{
    public int modInverse(long A, long M)
    {
        long m0 = M;
        long y = 0, x = 1;
        if (M == 1)
            return 0;
        while (A > 1) {
            long q = A / M;
            long t = M;
            M = A % M;
            A = t;
            t = y;
            y = x - q * y;
            x = t;
        }
        if (x < 0)
        x += m0;
        return (int)x;
    }

	public int  compute_value(int n)
	{
	    long ans=1;
        long m = (long)(1e9 + 7);
        long com=1;
        for(int i=1;i<=n;++i){
            com =(long) (((((n+1-i)*com)%m)*modInverse(i,m))%m);
            long temp = (com*com)%m;
            ans = (ans+temp)%m;
        }
        return (int)ans;
	}
}
