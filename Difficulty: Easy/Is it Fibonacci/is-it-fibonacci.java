// User function Template for Java

// User function Template for Java

class Solution {
    static long solve(int N, int K, ArrayList<Long> GeekNum) {

        if (N <= K) {
            return GeekNum.get(N - 1);
        }

        long[] dp = new long[N];
        long windowSum = 0;

        for (int i = 0; i < K; i++) {
            dp[i] = GeekNum.get(i);
            windowSum += dp[i];
        }

        for (int i = K; i < N; i++) {
            dp[i] = windowSum;
            windowSum = windowSum + dp[i] - dp[i - K];
        }

        return dp[N - 1];
    }
}