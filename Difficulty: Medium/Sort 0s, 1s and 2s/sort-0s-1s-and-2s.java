class Solution {
    public void sort012(int[] arr) {
        // code here
        int c0 = 0, c1 = 0, c2 = 0;

        for (int x : arr) {
            if (x == 0) c0++;
            else if (x == 1) c1++;
            else c2++;
        }

        int idx = 0;
        while (c0-- > 0) arr[idx++] = 0;
        while (c1-- > 0) arr[idx++] = 1;
        while (c2-- > 0) arr[idx++] = 2;
    }
}