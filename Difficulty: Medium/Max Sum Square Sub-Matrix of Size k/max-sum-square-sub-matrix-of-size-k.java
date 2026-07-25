class Solution {
    public int maximumSum(int[][] mat, int k) {
        int n = mat.length;

        // Prefix Sum Array
        int[][] prefix = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // Check every k x k submatrix
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                int r2 = i + k - 1;
                int c2 = j + k - 1;

                int sum = prefix[r2 + 1][c2 + 1]
                        - prefix[i][c2 + 1]
                        - prefix[r2 + 1][j]
                        + prefix[i][j];

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}