package Programmers.Level3.자물쇠와열쇠;


class Solution {
    int m;
    int n;

    int[][] rotate(int[][] key){
        int[][] tmp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = key[m-1-j][i];
            }
        }
        return tmp;
    }

    boolean tryMatch(int[][] tmp, int[][] lock){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(tmp[n+i][n+j] == 0 && lock[i][j] == 0) return false;
                if(tmp[n+i][n+j] == 1 && lock[i][j] == 1) return false;
            }
        }
        return true;
    }

    boolean matchLock(int[][] key, int[][] lock) {

        for (int i = 0; i < 2*n; i++) {
            for (int j = 0; j < 2*n; j++) {

                int[][] tmp = new int[2*n+m][2*n+m];
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < m; l++) {
                        tmp[i + k][j + l] = key[k][l];
                    }
                }
                if (tryMatch(tmp, lock)) return true;
            }
        }
        return false;
    }


    public boolean solution(int[][] key, int[][] lock) {
        m = key.length;
        n = lock.length;

        for (int i = 0; i < 4; i++) {
            key = rotate(key);
            if(matchLock(key,lock)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}) = " + s.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }
}