class Solution {
    int conflictFreeIndex(int[][]jb,int i)
    {
        for(int j=i-1;j>=0;j--)
            if(jb[j][1]<=jb[i][0])
                return j;
        return -1;
    }
    int help(int[][]j,int n)
    {
        int[] t = new int[n];
        t[0]=j[0][2];
        
        for(int i=1;i<n;i++)
        {
            int in = j[i][2],l=conflictFreeIndex(j,i);
            if(l!=-1)
                in += t[l];
                
            t[i]=Math.max(in,t[i-1]);
        }
        return t[n-1];
    }
    public int maximum_profit(int n, int[][] job) {
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(job[i][1]>job[j][1])
                {
                    int[] t = job[i];
                    job[i]=job[j];
                    job[j]=t;
                }
            }
        }
        return help(job,n);
    }
}
