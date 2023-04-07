//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
   public static boolean checkpalindrome(String str ,int e){
        int s = 0;
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
                return false;
            }
            else {
                s++;
                e--;
            }
        }
        return true;
    }
	public static int addMinChar(String str){
		int e=str.length()-1;
        int ans =0;
        for(int i=e;i>0;i--){
            if(checkpalindrome(str, i)) {
                return str.length()-i-1; 
            }
        }
        return str.length()-1;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends
