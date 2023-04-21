//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public int prefixSuffixString(String s1[],String s2[])
    {
        HashSet<String> set = new HashSet<>();
        HashSet<Integer> sets = new HashSet<>();
        int c=0;
        for(int i=0; i<s2.length; i++) {
            sets.add(s2[i].length());
        }
        for(int i : sets){
            for(int j=0; j<s1.length; j++){
                if(s1[j].length() >= i){
                    set.add(s1[j].substring(0,i));
                    set.add(s1[j].substring(s1[j].length()-i,s1[j].length()));
                }
            }
        }
        for(int i=0; i<s2.length; i++){
            if(set.contains(s2[i]))
                c++;
        }
        return c;
    }
}
