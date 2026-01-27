class Solution {

    private boolean dfs(int i, int j, int idx, char[][] mat, String word, int[] dx, int[] dy) {
        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || mat[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = mat[i][j];
        mat[i][j] = '#'; // mark visited

        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];
            if (dfs(ni, nj, idx + 1, mat, word, dx, dy)) {
                mat[i][j] = temp; // restore before returning
                return true;
            }
        }

        mat[i][j] = temp; // restore
        return false;
    }

    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(i, j, 0, mat, word, dx, dy)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}