/{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int carpetBox(int a, int b, int c, int d) { 
        int b1=b;int b2=b;int a1=a; int a2=a;
        int ans1=0,ans2=0,ans3=0,ans4=0;
        while(a1>c){
            ans1++;
            a1/=2;
        }
        while(b1>d){
            ans2++;
            b1/=2;
        }
        while(a2>d){
            a2/=2;
            ans3++;
        }
          while(b2>c){
            b2/=2;
            ans4++;
          }
        return Math.min(ans1+ans2,ans3+ans4);
    }
}
