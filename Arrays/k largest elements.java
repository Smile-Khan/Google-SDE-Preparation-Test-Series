Question :- k largest elements
https://practice.geeksforgeeks.org/batch/gts-1/track/GTS-ARRAY/problem/k-largest-elements4206


Solution:-

//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        
        
       // Create a min-heap to store the K largest elements.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        
        
        // Add the first K elements to the min-heap.
        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }
        
        
        
        // Continue adding elements to the min-heap and removing the smallest element if necessary.
        for (int i = k; i < n; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        
        
        
        // Convert the min-heap to an array and reverse it to get the K largest elements in decreasing order.
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }
        
        return result;
    }
}