//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution {
    long ans = 0L;

    Deque<Character> fi(int X, String S) {
        int n = S.length();
        Deque<Character> deque = new ArrayDeque<>();
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if (c == 'r') {
                if (!deque.isEmpty() && deque.peekLast() == 'p') {
                    deque.removeLast();
                    ans += X;
                } else
                    deque.addLast(c);
            } else
                deque.addLast(c);

        }
        this.ans += ans;
        return deque;
    }

    Deque<Character> find(int Y, String S) {
        int n = S.length();
        Deque<Character> deque = new ArrayDeque<>();
        long ans = 0L;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            if (c == 'p') {
                if (!deque.isEmpty() && deque.peekLast() == 'r') {
                    deque.removeLast();
                    ans += Y;
                } else
                    deque.addLast(c);
            } else
                deque.addLast(c);
        }
        this.ans += ans;
        return deque;
    }

    long solve(int X, int Y, String S) {
        ans = 0L;
        if (X >= Y) {
            Deque<Character> deque = fi(X, S);
            Deque<Character> deque1 = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                char c = deque.removeFirst();
                if (c == 'p') {
                    if (!deque1.isEmpty() && deque1.peekLast() == 'r') {
                        deque1.removeLast();
                        ans += Y;
                    } else
                        deque1.addLast(c);
                } else
                    deque1.addLast(c);
            }
        } else {
            Deque<Character> deque = find(Y, S);
            Deque<Character> deque1 = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                char c = deque.removeFirst();
                if (c == 'r') {
                    if (!deque1.isEmpty() && deque1.peekLast() == 'p') {
                        deque1.removeLast();
                        ans += X;
                    } else
                        deque1.addLast(c);
                } else
                    deque1.addLast(c);

            }
        }
        return ans;
    }
}
