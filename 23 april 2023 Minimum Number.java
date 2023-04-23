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
            int res = obj.minimumNumber(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumNumber(int n, int[] arr) {
        if(n==1)return arr[0];
        if(n==2){
            int min=Integer.MAX_VALUE;
            int max=Integer.MIN_VALUE;
            int even=0;
            int odd=0;
            int e=0;
            for(int i=0;i<n;i++){
                if(arr[i]<min)min=arr[i];
                if(arr[i]>max)max=arr[i];
                if(arr[i]%2==0)e++;
                else odd++;
            }
            if(e==2 && max%min==0)return min;
            if(odd==2 && max%min==0)return min;
        }
        for(int i=0;i<n;i++){
            if(arr[i]%2==0)even++;
        }
        if(even==n)return 2;
        else return 1;
    }
}
