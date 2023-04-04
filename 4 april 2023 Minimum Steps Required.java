//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int minSteps(String str) {
        int n=str.length(), a=0,b=0;
        for(int i=1; i<n; i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                if(str.charAt(i-1)=='a') a++;
                if(str.charAt(i-1)=='b') b++;
            }
        }
        if(str.charAt(n-1)=='a') 
        a++;
        if(str.charAt(n-1)=='b') 
        b++;
        return (Math.min(a,b)+1);
    }
}
