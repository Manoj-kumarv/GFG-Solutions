class Solution {
    public int fibSum(int n) {
        final int MOD = 1000000007;

        long a = 0; // f0
        long b = 1; // f1

        // compute f(n+2)
        for (int i = 2; i <= n + 2; i++) {
            long c = (a + b) % MOD;
            a = b;
            b = c;
        }

        // sum = f(n+2) - 1
        return (int)((b - 1 + MOD) % MOD);
    }
}