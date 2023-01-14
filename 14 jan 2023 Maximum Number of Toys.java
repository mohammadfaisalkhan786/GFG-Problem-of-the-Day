class Solution {
    int fr[];
    
    class tree{
        int N;
        long bit[];
        tree(int N){
            this.N = N;
            bit = new long[N];
        }
        
        void add(int node, int v){
              while(node<N)
                {
                    bit[node]+=v;
                    node+=(node&(-node));
                }
        }
        
        long get(int node){
            long x = 0l;
            for(;node>0;node-=(node&(-node)))
                x+=bit[node];
            return x;
        }
    }
    
    ArrayList<Integer> maximumToys(int N, int A[], int Q, ArrayList<Integer> Queries[]){
        ArrayList<Integer> res = new ArrayList<>();
        fr = new int[1000 * 1000 + 5];
        for(int x : A) fr[x]++;
        tree obj1 = new tree(1000 * 1000 + 5);
        tree obj2 = new tree(1000 * 1000 + 5);
        for(int i=0;i<A.length;i++){
          obj1.add(A[i],A[i]);
          obj2.add(A[i],1);
        }
        for(ArrayList<Integer> i :Queries){
            long C=i.get(0);
            for(int j=2;j<i.size();j++){
                obj1.add(A[i.get(j)-1],-A[i.get(j)-1]);
                obj2.add(A[i.get(j)-1],-1);
            }
            int lw=1,hg=1000 * 1000;
            int pos=1000 * 1000;
            while(lw<=hg){
                int mid=lw + (hg - lw)/2;
                if(obj1.get(mid)>=C){
                    pos=mid;
                    hg=mid-1;
                }
                else
                    lw=mid+1;
                
            }
            long ans = obj2.get(pos - 1);
            long mx=Math.min((C-obj1.get(pos-1))/pos,(long)fr[pos]);
            ans+=mx;
            res.add((int)ans);
            for(int j=2;j<i.size();j++){
                obj1.add(A[i.get(j)-1],A[i.get(j)-1]);
                obj2.add(A[i.get(j)-1],1);
            }
        }
        return res;
    }
}
