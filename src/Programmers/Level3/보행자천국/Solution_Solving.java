package Programmers.Level3.보행자천국;

class Solution_Solving {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][][] go = new int[m][n][2];
        //  0 은 오른쪽
        // 1 은 위에서 아래
        for (int i = 0; i < m; i++) {
            if(cityMap[0][i] != 1 ) go[i][0][1] = 1;
            if(cityMap[i][0] == 0 ) go[i][0][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if(cityMap[0][i] != 1) go[0][i][0] = 1;
            if(cityMap[0][i] == 0) go[0][i][1] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(cityMap[i][j] == 1) continue;
                go[i][j][0] = go[i][j-1][0];

            }
        }


        return answer;
    }
}