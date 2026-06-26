class Solution {
    static final int MOD = 1000000007;

    public static int countWays(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        if (m > n) return 0;

        long[] dp = new long[m + 1];
        dp[0] = 1; // empty s2

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = (dp[j] + dp[j - 1]) % MOD;
                }
            }
        }

        return (int) dp[m];
    }
}