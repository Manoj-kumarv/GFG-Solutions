class Solution {
    public int maxSumSubarray(int[] arr) {
        int noSkip = arr[0];
        int oneSkip = Integer.MIN_VALUE;
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {

            int prevNoSkip = noSkip;
            noSkip = Math.max(arr[i], noSkip + arr[i]);

            if (oneSkip != Integer.MIN_VALUE) {
                oneSkip = Math.max(prevNoSkip, oneSkip + arr[i]);
            } else {
                oneSkip = prevNoSkip;
            }

            ans = Math.max(ans, Math.max(noSkip, oneSkip));
        }

        return ans;
    }
}