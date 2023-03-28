//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        

        while(t-->0){
            Shop shop = new Shop();

            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            long k = Long.parseLong(s[1]);

            s = br.readLine().trim().split(" ");

            for(String x: s){
                shop.addChocolate(Integer.parseInt(x));
            }
            
            ot.println(new Solution(shop).find(n, k));
        }
        ot.close();
    }
    
    
}
class Shop{
    private static List<Integer> chocoloates;
    private static int countOfCalls;
    Shop(){
        chocoloates = new ArrayList<>();
        countOfCalls = 0;
    }
    public static void addChocolate(int price){
        chocoloates.add(price);
    }

    public static int get(int i){
        countOfCalls++;
        if(countOfCalls > 50 || i >= chocoloates.size() || i < 0)
            return -1;
        return chocoloates.get(i);
    }
}
// } Driver Code Ends


//User function Template for Java

/*
Instructions - 

    1. 'shop' is object of class Shop.
    2. User 'shop.get(int i)' to enquire about the price
            of the i^th chocolate.
    3. Every chocolate in shop is arranged in increasing order
            i.e. shop.get(i) <= shop.get(i + 1) for all 0 <= i < n - 1
*/
class Solution{
    static Shop shop;
    Solution(Shop shop){
        this.shop = shop;
    }
    static long find(int n, long k){
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0l;
        int p = shop.get(0);
        while(k >= p){
            int s = 0; int e = n-1;
            while(s<=e){
                int mid = s + (e-s)/2;
                int val;
                if( map.containsKey(mid) ){ val = map.get(mid);
                    
                }
                else{ val = shop.get(mid); map.put(mid, val); 
                }
                if(val <= k){ 
                    s = mid+1; 
                }
                else{ e = mid-1; }
            }
            long val;
            if( map.containsKey(e) ){ val = (long) map.get(e); }
            else{ val = (long) shop.get(e); map.put(e, (int) val); }
            ans += k/val;
            k %= val;
            n = e;
        }
        return ans;
    }
}
