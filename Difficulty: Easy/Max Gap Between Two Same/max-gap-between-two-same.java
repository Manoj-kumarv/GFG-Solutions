class Solution {
    public int maxCharGap(String s) {
        int[] firstIndex = new int[26];
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1;
        }

        int maxGap = -1;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            if (firstIndex[idx] == -1) {
                firstIndex[idx] = i; // first occurrence
            } else {
                int gap = i - firstIndex[idx] - 1;
                maxGap = Math.max(maxGap, gap);
            }
        }

        return maxGap;
    }
}