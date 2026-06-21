class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Long, Integer> map = new HashMap<>();
        
        long prefixSum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            // Subarray from index 0 to i
            if (prefixSum == k) {
                maxLen = i + 1;
            }
            
            //Subarray ending at i with sum k
            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }
            
            // Store first occurrence of prefixSum
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        
        return maxLen;
    }
}
