class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        HashSet<Integer> set = new HashSet<>();
        int duplicate = -1;
        long sumUnique = 0;
        
        for (int num : arr) {
            if (set.contains(num)) {
                duplicate = num;
            } else {
                set.add(num);
                sumUnique += num;
            }
        }
        
        long expectedSum = (long) n * (n + 1) / 2;
        int missing = (int) (expectedSum - sumUnique);
        
        result.add(duplicate);
        result.add(missing);
        
        return result;
    }
}