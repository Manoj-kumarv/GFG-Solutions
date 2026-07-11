class Solution {

    int n, m;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {

        n = mat.length;
        m = mat[0].length;

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;

        boolean[][] vis = new boolean[n][m];

        return dfs(mat, xs, ys, xd, yd, vis);
    }

    private int dfs(int[][] mat, int x, int y, int xd, int yd, boolean[][] vis) {

        if (x == xd && y == yd)
            return 0;

        vis[x][y] = true;

        int ans = -1;

        for (int[] d : dir) {

            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                mat[nx][ny] == 1 && !vis[nx][ny]) {

                int cur = dfs(mat, nx, ny, xd, yd, vis);

                if (cur != -1)
                    ans = Math.max(ans, cur + 1);
            }
        }

        vis[x][y] = false;

        return ans;
    }
}