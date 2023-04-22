//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static int binarySearch(int key,int arr[],int n)
    {
        int index=0,low=0,high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==key)
            {
                index=mid;
                high=mid -1;
            }
            else if(arr[mid]<key)
                low=mid+1;
            else
                high=mid-1;
        }
        return index;
    }
    public static long[] smallerSum(int n,int arr[])
    {
        long ans[] = new long[n];
        int temp[] = new int[n];
        temp = Arrays.copyOf(arr,n);
        Arrays.sort(temp);
        long sum[]=new long[n];
        sum[0]=0;
        sum[1]=temp[0];
        for(int i=2;i<n;i++)
            sum[i]=sum[i-1]+temp[i-1];
        for(int i=0;i<n;i++)
            ans[i]=sum[binarySearch(arr[i], temp, n)];
        return ans;
    }
}
