//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
     int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> a.profit == b.profit ? b.deadline-a.deadline : b.profit-a.profit);
        int maxDeadline = 0;
        for(int i=0; i<n; i++)
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        boolean[] hash = new boolean[maxDeadline+1];
        int profitCount = 0, jobCount = 0;
        for(int i=0; i<n; i++){
            Job curr = arr[i];
            int currDL = curr.deadline;
            while(currDL > 0 && hash[currDL])
                currDL--;
            if(currDL > 0){
                hash[currDL]=true;
                profitCount+=curr.profit;
                jobCount++;
            }
        }
        return new int[]{jobCount, profitCount};
    }
}
