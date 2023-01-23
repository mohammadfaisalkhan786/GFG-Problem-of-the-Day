//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(!st.isEmpty() && st.peek() == c) st.pop();
            else st.push(c);
        }
        if(st.isEmpty()) return "-1";
        String ans = "";
        while(!st.isEmpty())
            ans = st.pop() + ans;
        return ans;
    }
}
