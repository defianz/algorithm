package Programmers.Level3.순위;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n+1][n+1];

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            map[winner][loser] = 1;
            map[loser][winner] = 2;

        }

        for(int j = 1; j <= n; j++) { //col
            for(int i = 1; i <= n; i++) { //row
                if( map[i][j] == 1 ) {
                    for(int k = 1; k <= n; k++) {
                        if( map[j][k] == 1 ) {
                            map[i][k] = 1;
                        }
                    }
                } else if ( map[i][j] == 2 ) {
                    for(int k = 1; k <= n; k++) {
                        if( map[j][k] == 2) {
                            map[i][k] = 2;
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            map[i][i] = 1;
        }

        for (int i = 1; i <= n ; i++) {
            boolean flag = true;
            for (int j = 1; j <= n; j++) {
                if(map[i][j] == 0) flag = false;
            }
            if(flag) answer++;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(5,new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}) = " + s.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
        System.out.println("s.solution(5,new int[][]{{3, 5}, {4, 2}, {4, 5}, {5, 1}, {5, 2}}) = " + s.solution(5, new int[][]{{3, 5}, {4, 2}, {4, 5}, {5, 1}, {5, 2}}));
        System.out.println("s.solution(5,new int[][]{{1, 4}, {4, 2}, {2, 5}, {5, 3}}) = " + s.solution(5, new int[][]{{1, 4}, {4, 2}, {2, 5}, {5, 3}}));
    }
}