package Programmers.Level2.행렬테두리회전하기;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] map = new int[rows+1][columns+1];


        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = (i-1)*columns + j;
            }
        }


        for (int i = 0; i < queries.length; i++) {
            int str = queries[i][0];
            int stc = queries[i][1];
            int enr = queries[i][2];
            int enc = queries[i][3];

            int min = map[str][stc];

            // 맨 윗줄
            int tmp = map[str][enc];
            for (int j = enc; j >= stc+1; j--) {
                map[str][j] = map[str][j-1];
                if(min > map[str][j]) min = map[str][j];
            }

            // 오른쪽
            int tmp2 = map[enr][enc];
            for (int j = enr; j >= str+2; j--) {
                map[j][enc] = map[j-1][enc];
                if(min > map[j][enc]) min = map[j][enc];
            }
            map[str+1][enc] = tmp;


            // 아래
            int tmp3 = map[enr][stc];
            for (int j = stc; j <= enc-2; j++) {
                map[enr][j] = map[enr][j+1];
                if(min > map[enr][j]) min = map[enr][j];
            }
            map[enr][enc-1] = tmp2;

            // 왼쪽
            for (int j = str; j <= enr-2; j++) {
                map[j][stc] = map[j+1][stc];
                if(min > map[j][stc]) min = map[j][stc];
            }
            map[enr-1][stc] = tmp3;


            min = Math.min(Math.min(Math.min(min,tmp),tmp2),tmp3);
            answer[i] = min;
        }

        return answer;
    }
}
