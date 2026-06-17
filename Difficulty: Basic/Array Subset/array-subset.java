class Solution {
    public boolean isSubset(int a[], int b[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count elements of array a
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check elements of array b
        for (int num : b) {
            if (!map.containsKey(num) || map.get(num) == 0) {
                return false;
            }
            map.put(num, map.get(num) - 1);
        }

        return true;
    }
}