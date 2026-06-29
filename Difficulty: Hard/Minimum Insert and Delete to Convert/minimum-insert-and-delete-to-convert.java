class Solution {
    public int minInsAndDel(int[] a, int[] b) {
        int n = a.length, m = b.length;

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            indexMap.put(b[i], i);
        }

        List<Integer> transformed = new ArrayList<>();
        for (int val : a) {
            if (indexMap.containsKey(val)) {
                transformed.add(indexMap.get(val));
            }
        }

        List<Integer> lis = new ArrayList<>();
        for (int num : transformed) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) pos = -(pos + 1);
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }

        int lcs = lis.size();

        return (n - lcs) + (m - lcs);
    }
}