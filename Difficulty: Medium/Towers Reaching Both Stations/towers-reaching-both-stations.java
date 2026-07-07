class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int countCoordinates(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] stationP = new boolean[n][m];
        boolean[][] stationQ = new boolean[n][m];

        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();

        for (int j = 0; j < m; j++) {
            stationP[0][j] = true;
            q1.offer(new int[]{0, j});
        }

        for (int i = 0; i < n; i++) {
            if (!stationP[i][0]) {
                stationP[i][0] = true;
                q1.offer(new int[]{i, 0});
            }
        }

        for (int j = 0; j < m; j++) {
            stationQ[n - 1][j] = true;
            q2.offer(new int[]{n - 1, j});
        }

        // Station Q -> Right column
        for (int i = 0; i < n; i++) {
            if (!stationQ[i][m - 1]) {
                stationQ[i][m - 1] = true;
                q2.offer(new int[]{i, m - 1});
            }
        }

        bfs(mat, q1, stationP);
        bfs(mat, q2, stationQ);

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (stationP[i][j] && stationQ[i][j])
                    ans++;
            }
        }

        return ans;
    }

    private void bfs(int[][] mat, Queue<int[]> q, boolean[][] vis) {

        int n = mat.length;
        int m = mat[0].length;

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m
                        && !vis[nx][ny]
                        && mat[nx][ny] >= mat[x][y]) {

                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}