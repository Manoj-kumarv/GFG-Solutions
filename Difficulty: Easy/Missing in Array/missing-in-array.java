class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length + 1;
        int xorAll = 0;

        // XOR from 1 to n
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }

        // XOR array elements
        for (int num : arr) {
            xorAll ^= num;
        }

        return xorAll;
    }
}