//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    Node primeList(Node head){
        Node res=head;
        while(head!=null){
            int x=head.val;
            if(prime(x)){
                head=head.next;
                continue;
            }
            for(int i=1;i<=50;i++){
                boolean a=prime(x-i),b=prime(x+i);
                if((a&&b)||a){
                    head.val=x-i;
                    break;
                }else if(b){
                    head.val=x+i;
                    break;
                }
            }
            head=head.next;
        }
        return res;
    }
    boolean prime(int x){
        if(x<=1)
            return false;
        
        for(int i=2;i*i<=x;i++){
            if(x%i==0)return false;
        }
        return true;
    }
}
