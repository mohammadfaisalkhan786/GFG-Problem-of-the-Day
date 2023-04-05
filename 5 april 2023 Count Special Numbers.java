class Solution {
    public int countSpecialNumbers(int N, int arr[]) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] hash = new int[max+1];
        Arrays.fill(hash,0);
        for(int i=0;i<N;i++){
            int start = arr[i];
            if(hash[start]<=1){
                for(int j=start;j<=max;j=j+start){
                    hash[j]++;
                }
            }
        }
        int count = 0;
        for(int j=0;j<N;j++){
            if(hash[arr[j]]>1){
                count++;
            }
        }
        return count;
    }
}
