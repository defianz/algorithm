package Programmers_1st.Level3.보행자천국;

class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {

        int[][][] go = new int[m+1][n+1][2];
        //  0 이 위에서 아래로
        //  1 가 왼쪽에서 오른쪽으로

        go[1][1][0] = 1;
        go[1][1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(cityMap[i-1][j-1] == 0){
                    go[i][j][0] += (go[i-1][j][0] + go[i][j-1][1]) % MOD;
                    go[i][j][1] += (go[i-1][j][0] + go[i][j-1][1]) % MOD;
                } else if (cityMap[i-1][j-1] == 1){
                    go[i][j][0] = 0;
                    go[i][j][1] = 0;
                } else {
                    go[i][j][0] = go[i-1][j][0];
                    go[i][j][1] = go[i][j-1][1];
                }
            }
        }

        return go[m][n][0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(3,3,new int[][]{{0,0,0},{0,0,0},{0,0,0}}) = " + s.solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println("s.solution(3,6,new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}) = " + s.solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
    }
}