class Solution {

    int n;
    int[][] ans;
    boolean[][] dead;

    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        n = mat.length;
        ans = new int[n][n];
        dead = new boolean[n][n];

        if (mat[0][0] == 0) {
            return new ArrayList<>(List.of(new ArrayList<>(List.of(-1))));
        }

        if (!dfs(mat, 0, 0)) {
            return new ArrayList<>(List.of(new ArrayList<>(List.of(-1))));
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(ans[i][j]);
            }
            res.add(row);
        }
        return res;
    }

    boolean dfs(int[][] mat, int i, int j) {

        // Invalid or blocked
        if (i < 0 || j < 0 || i >= n || j >= n || mat[i][j] == 0)
            return false;

        // Already known dead state
        if (dead[i][j])
            return false;

        // Destination
        if (i == n - 1 && j == n - 1) {
            ans[i][j] = 1;
            return true;
        }

        ans[i][j] = 1;

        // Try jumps in order
        for (int jump = 1; jump <= mat[i][j]; jump++) {

            // RIGHT first
            if (dfs(mat, i, j + jump))
                return true;

            // DOWN
            if (dfs(mat, i + jump, j))
                return true;
        }

        // Mark as dead & backtrack
        ans[i][j] = 0;
        dead[i][j] = true;
        return false;
    }
}