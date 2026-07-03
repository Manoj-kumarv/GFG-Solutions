class Solution {
    static class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int i, int delta) {
            for (; i <= n; i += i & -i) {
                bit[i] += delta;
            }
        }

        int query(int i) {
            int sum = 0;
            for (; i > 0; i -= i & -i) {
                sum += bit[i];
            }
            return sum;
        }
    }

    public int countSubstring(String s) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : -1);
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int idx = 1;
        for (int val : sorted) {
            if (!rank.containsKey(val)) {
                rank.put(val, idx++);
            }
        }

        Fenwick fenwick = new Fenwick(rank.size());
        long count = 0;

        for (int i = 0; i <= n; i++) {
            int r = rank.get(prefix[i]);
            count += fenwick.query(r - 1);
            fenwick.update(r, 1);
        }

        return (int) count;
    }
}