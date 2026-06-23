class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(num)) {
                result.add(num);
            } else {
                seen.add(num);
            }
        }

        return result;
    }
}