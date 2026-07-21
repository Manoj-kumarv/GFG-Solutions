class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();

        int[] best = new int[26];
        for (int i = 0; i < 26; i++) best[i] = -1;

        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            if (c == 25) {
                dp[i] = i;
            } else if (best[c + 1] != -1) {
                dp[i] = best[c + 1];
            } else {
                dp[i] = i;
            }

            best[c] = Math.max(best[c], dp[i]);
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                ans = Math.max(ans, dp[i] - i);
            }
        }

        return ans;
    }
}