// Link: https://leetcode.com/problems/01-matrix/
// coding decoded

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
                else mat[i][j] = -1;
            }
        }

        int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        int length = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            length++;

            while (size-- > 0){
                int[] cell = q.poll();

                for (int[] dir : dirs){
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];

                    if (r < 0 || c < 0 || r >= m || c >= n || mat[r][c] != -1) {
                        continue;
                    }

                    mat[r][c] = length;
                    q.add(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}

// TC O(m * n), SC: O(m * n)