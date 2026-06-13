class Solution {
    int maxSubarraySum(int[] arr) {
        // Code here
        int currentsum = arr[0];
        int maxsum = arr[0];
        if (arr.length == 1){
            return maxsum;
        }
        for (int i = 1; i< arr.length; i++){
            currentsum = Math.max(arr[i], currentsum + arr[i]);
            maxsum = Math.max(currentsum, maxsum);
        }
        return maxsum;
    }
}
