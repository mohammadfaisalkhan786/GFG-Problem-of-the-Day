//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to perform case-specific sorting of strings.
    public static String caseSort(String str)
    {
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();
        for(char c : str.toCharArray()){
            if(c>='a' && c<='z') lower.append(c);
            else upper.append(c);
        }
        char[] low = lower.toString().toCharArray();
        Arrays.sort(low);
        char[] up = upper.toString().toCharArray();
        Arrays.sort(up);
        StringBuilder ans = new StringBuilder();
        int i=0, j=0;
        for(char c : str.toCharArray()){
            if(c>='a' && c<='z') ans.append(low[i++]);
            else ans.append(up[j++]);
        }
        return ans.toString();
    }
}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) {
		
    	try {
    	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    PrintWriter out=new PrintWriter(System.out);
    	    String[] words = br.readLine().split("\\s+");
    	    int numTestCases = Integer.parseInt(words[0]);
    	    
    	    for (int tIdx = 0; tIdx < numTestCases; tIdx++) {
    	        words = br.readLine().split("\\s+");
    	        int size = Integer.parseInt(words[0]);
    	        String str = br.readLine();
    	        String sortedStr = new Solution().caseSort(str);
    	        out.println(sortedStr);
    	    }
    	    out.close();
    	}
    	catch (IOException e) {
    	    System.out.println(e);
    	}
	}
}
// } Driver Code Ends
