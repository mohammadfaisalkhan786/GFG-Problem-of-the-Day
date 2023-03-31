//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			Solution obj = new Solution();
			int [] b = obj.lexicographicallyLargest(arr, n);
			for(int x: b) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int [] lexicographicallyLargest(int [] arr, int n) {
		int[] ans = new int[n];
		int k = 0;
		int a = 0;
		for(int i=0; i<n; i++){
		    if( arr[a]%2 != arr[i]%2 ){
		        int[] subArr = Arrays.copyOfRange(arr,a,i);
		        Arrays.sort(subArr);
		        for(int j=subArr.length-1; j>=0; j--){
                    ans[k++] = subArr[j];
                }
		        a = i;
		    }
		}
		int[] subArr = Arrays.copyOfRange(arr,a,n);
		Arrays.sort(subArr);
        for(int j=subArr.length-1; j>=0; j--){
            ans[k++] = subArr[j];
        }
		return ans;
		
	}
}
