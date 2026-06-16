class Solution {
    int majorityElement(int arr[]) {
        // code here
                int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check majority condition
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key;
            }
        }

        return -1;
    }
    
}