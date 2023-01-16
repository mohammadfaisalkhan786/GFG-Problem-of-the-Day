//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}




// } Driver Code Ends


// User Function Template for JAVA


class Solution{
    public static long[] nextLargerElement(long[] arr, int n) { 
        Stack<Integer>stack=new Stack<>();
        long result[]=new long[n];
        Arrays.fill(result,-1);
        for(int i=0;i<n;i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()]=arr[i];
            }
            stack.push(i);
        }
        return result;
    } 
}
