//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int [] nearestSmallestTower(int [] arr){
        int length = arr.length;
        int [] arr2 = new int[length];
        int [] arr3 = new int[length];
        int [] finalArr = new int[length];
        Stack <Integer> stack1 = new Stack<>();
        Stack <Integer> stack2 = new Stack<>();
        ArrayList <Integer> list = new ArrayList<>();
        int num = arr[0];
        stack1.push(num);
        list.add(num);
        arr2[0] = -1;
        for(int i = 1; i < length; i++){
            num = arr[i];
            list.add(num);
            if(arr[i] > stack1.peek()){
                arr2[i] = list.lastIndexOf(stack1.peek());
                stack1.push(num);
            }
            else{
                while(stack1.size() > 0 && stack1.peek() >= num)
                    stack1.pop();
                if(stack1.isEmpty())
                    arr2[i] = -1;
                else
                    arr2[i] = list.lastIndexOf(stack1.peek()); 
                stack1.push(num);
            }
        }
        list.clear();
        num = arr[length-1];
        stack2.push(num);
        list.add(num);
        arr3[length-1] = -1;
        for(int i = length-2; i >= 0; i--){
            num = arr[i];
            list.add(num);       
            if(arr[i] > stack2.peek()){   
                arr3[i] = length - list.lastIndexOf(stack2.peek()) - 1;
                stack2.push(num);
            }
            else{
                while(stack2.size() > 0 && stack2.peek() >= num){
                    stack2.pop();                
                }
                if(stack2.isEmpty()){
                    arr3[i] = -1;
                }
                else{
                    arr3[i] = length - list.lastIndexOf(stack2.peek()) - 1;
                }
                stack2.push(num);
            }
        }
        
        for(int i = 0; i<length; i++){
            
            if(arr2[i] == -1 && arr3[i] == -1){
                finalArr[i] = -1;
            }
            else if(arr2[i] == -1 && arr3[i] != -1){
                finalArr[i] = arr3[i];
            }
            else if(arr2[i] != -1 && arr3[i] == -1){
                finalArr[i] = arr2[i];
            }
            else if(Math.abs(arr2[i] - i) == Math.abs(arr3[i] - i)){   
                if(arr[arr2[i]] > arr[arr3[i]]){
                    finalArr[i] = arr3[i];
                }
                else{
                    finalArr[i] = arr2[i];
                }  
            }
            else if(Math.abs(arr2[i] - i) > Math.abs(arr3[i] - i)){
                finalArr[i] = arr3[i];    
            }
            else{
                finalArr[i] = arr2[i];   
            }
        }
        return finalArr;
    }
}
