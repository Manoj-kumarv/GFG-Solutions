class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] inc = new int[n];
        int[] dec = new int[n];

        // Build inc[]
        inc[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1])
                inc[i] = inc[i + 1];
            else
                inc[i] = i;
        }

        // Build dec[]
        dec[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1])
                dec[i] = dec[i + 1];
            else
                dec[i] = i;
        }

        ArrayList<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            int peak = inc[l];
            ans.add(dec[peak] >= r);
        }

        return ans;
    }
}