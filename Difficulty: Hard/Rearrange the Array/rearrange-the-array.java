class Solution {
    static final int MOD = 1000000007;

    int minOperations(int[] b) {
        int n = b.length;
        boolean[] vis = new boolean[n];
        HashMap<Integer, Integer> maxPower = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int curr = i;
                int len = 0;

                while (!vis[curr]) {
                    vis[curr] = true;
                    curr = b[curr] - 1;
                    len++;
                }

                int x = len;
                for (int p = 2; p * p <= x; p++) {
                    if (x % p == 0) {
                        int cnt = 0;
                        while (x % p == 0) {
                            x /= p;
                            cnt++;
                        }
                        maxPower.put(p, Math.max(maxPower.getOrDefault(p, 0), cnt));
                    }
                }
                if (x > 1) {
                    maxPower.put(x, Math.max(maxPower.getOrDefault(x, 0), 1));
                }
            }
        }

        long ans = 1;

        for (Map.Entry<Integer, Integer> e : maxPower.entrySet()) {
            ans = (ans * modPow(e.getKey(), e.getValue())) % MOD;
        }

        return (int) ans;
    }

    long modPow(long a, int b) {
        long res = 1;
        a %= MOD;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % MOD;

            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }
}