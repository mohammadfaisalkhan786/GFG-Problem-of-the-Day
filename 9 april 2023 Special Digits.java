//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int A;
            A = Integer.parseInt(br.readLine());
            
            
            int B;
            B = Integer.parseInt(br.readLine());
            
            
            int C;
            C = Integer.parseInt(br.readLine());
            
            
            int D;
            D = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.bestNumbers(N, A, B, C, D);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
  public static long power(long x, int y, int p) {
    long res = 1;
    x = x % p;
    while (y > 0) {
      if ((y & 1) == 1)
        res = (res * x) % p;
      y = y >> 1; 
      x = (x * x) % p;
    }
    return res;
  }
 
  public static long modInverse(long n, int p) {
    return power(n, p - 2, p);
  }
 
  public static long mul(long x, long y, int p) {
    return x * 1L * y % p;
  }
 
  public static long divide(long x, long y, int p) {
    return mul(x, modInverse(y, p), p);
  }
 
  public static long nCrModPFermat(long n, long r, int p) {
    if (n < r)
      return 0;
    if (r == 0)
      return 1;
    if (n - r < r)
      return nCrModPFermat(n, n - r, p);
    long res = 1;
    for (long i = r; i >= 1; i--)
      res = divide(mul(res, n - i + 1, p), i, p);
    return res;
  }
    public static int bestNumbers(int N, int A, int B, int C, int D) {
        long ans=0L;
        for(int i=0;i<=N;i++)
        {
            int val=A*i+B*(N-i);
            boolean fl=true;
            int sum=val;
            while(sum!=0)
            {
                int m=sum%10;
                if(m!=C && m!=D)
                fl=false;
                sum/=10;
            }
            if(fl==true)
                ans=(ans+nCrModPFermat(N,i,1000000007))%1000000007;
        }
        return (int)ans;
    }
}    
