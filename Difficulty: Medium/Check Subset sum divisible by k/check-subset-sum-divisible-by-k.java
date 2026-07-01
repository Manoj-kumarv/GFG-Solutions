class Solution {
    public boolean divisibleByK(int[] arr, int k) {
        boolean[] dp = new boolean[k];

        for (int num : arr) {
            boolean[] nextDp = new boolean[k];
            int mod = num % k;

            nextDp[mod] = true;

            for (int r = 0; r < k; r++) {
                if (dp[r]) {
                    nextDp[(r + mod) % k] = true;
                }
            }

            for (int i = 0; i < k; i++) {
                dp[i] = dp[i] || nextDp[i];
            }

            if (dp[0]) {
                return true;
            }
        }
        return false;
    }
}