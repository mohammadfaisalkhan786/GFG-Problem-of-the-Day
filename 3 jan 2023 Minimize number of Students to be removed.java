class Solution {
     int binary(int b[], int l, int h, int key)
    {
        while(l<h){
            int mid = (l+h)/2;
            if(b[mid]<key)
                l = mid+1;
            else
                h = mid;
        }
        return l;
    }
    int fun(int H[], int n)
    {
        int b[] = new int[n];
        b[0] = H[0];
        int k = 1;
        for(int i=1; i<n; i++)
        {
            if(H[i]>b[k-1])
                b[k++] = H[i];
            else{
                int ind = binary(b, 0, k, H[i]);
                b[ind] = H[i];
            }
        }
        return k;
    }
    public int removeStudents(int[] H, int N) {
        return N-fun(H, N);
    }

};
