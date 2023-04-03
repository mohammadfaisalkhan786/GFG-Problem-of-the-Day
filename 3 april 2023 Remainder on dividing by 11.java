//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int xmod11(String s)
	{    
        char[] ch = s.toCharArray();
        int even = 0, odd = 0;
        for(int i=0;i<ch.length;i++){
            if(i%2==0)even += ch[i] - '0';
            else odd += ch[i] - '0';
        }

        return ((odd-even)%11 + 11)%11;
        
	}
} 
