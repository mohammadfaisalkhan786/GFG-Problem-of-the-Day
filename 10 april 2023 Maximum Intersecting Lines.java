//{ Driver Code Starts
// Initial Template for Java
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());

            int lines[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (i = 0; i < N; i++) {
                    lines[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxIntersections(lines, N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxIntersections(int[][] lines, int N) {
        int sum=0;
        int temp=Integer.MIN_VALUE;
        Map<Integer,Integer>map = new TreeMap<>();
        for(int x[]:lines)
        {
            map.put(x[0],map.getOrDefault(x[0],0)+1);
            map.put(x[1]+1,map.getOrDefault(x[1]+1,0)-1);
        }
        for(int i:map.keySet())
        {
            sum += map.get(i);
            temp = Math.max(temp,sum);
        }
        return temp;
    }
}
