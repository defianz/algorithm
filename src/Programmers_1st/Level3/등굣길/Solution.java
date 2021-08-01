package Programmers_1st.Level3.등굣길;

class Solution {

    int[] dr = new int[]{0,-1};
    int[] dc = new int[]{-1,0};

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] map = new int[m+1][n+1];
        map[1][1]= 1;
        for (int i = 0; i < puddles.length; i++) {
            int r = puddles[i][0];
            int c = puddles[i][1];
            map[r][c] = -1;
        }


        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                if(map[r][c] ==-1) continue;
                for (int i = 0; i < 2; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if(nr <= 0 || nr >m || nc <=0 || nc > n) continue;
                    if(map[nr][nc] == -1 ) continue;
                    map[r][c] += (map[nr][nc] % 1000000007);
                }
            }
        }

        answer = map[m][n] % 1000000007;

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(4,3,new int[][]{{2,2}}) = " + s.solution(4, 3, new int[][]{{2, 2}}));
    }
}
