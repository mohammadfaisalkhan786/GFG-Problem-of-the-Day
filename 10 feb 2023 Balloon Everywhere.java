//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        int chars[] = new int[26];
        for (int i=0; i<s.length(); i++) {
            char presentChar = s.charAt(i);
            int index = (int)(presentChar - 'a');
            chars[index]++;
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<chars.length; i++) {
            int presentMin = Integer.MAX_VALUE;
            if (i == 14 || i == 11) presentMin = (int)chars[i] / 2;
            else if (i == 0 || i == 1 || i == 13) presentMin = chars[i];
            else continue;
            if(presentMin < min) min = presentMin;
        }
        return min;
    }
}
