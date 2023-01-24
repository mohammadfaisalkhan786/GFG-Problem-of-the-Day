//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        HashMap<Integer,Integer> map=new HashMap<>(); 
        int[] b=new int[n]; 
        for(int i=0;i<n;i++){
            b[i]=arr[i]; 
        }
        for(int i=0;i<n;i++){
            map.put(arr[i],i); 
        }
        Arrays.sort(b); 
        int ind=0; 
        for(int i=0;i<n;i++){
            int k=map.get(b[i]); 
            arr[k]=ind; 
            ind++; 
        }
        
        
    }
}
