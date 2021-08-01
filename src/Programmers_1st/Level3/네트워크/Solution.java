package Programmers_1st.Level3.네트워크;

class Solution {

    int totalN;

    void dfs(int start, int[][] computers, int[][] visited, int cnt){

        for (int i = 0; i<totalN; i++){
            if(visited[start][i] == 0 && computers[start][i] == 1){
                visited[start][i] = cnt;
                visited[i][start] = cnt;
                dfs(i,computers,visited, cnt);
            }
        }
        return;
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        totalN = n;

        int[][] visited = new int[n][n];

        int cnt = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] == 0 && computers[i][j] == 1) {
                    visited[i][j] = cnt;
                    visited[j][i] = cnt;
                    dfs(j,computers,visited,cnt);
                    cnt++;

                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(answer < visited[i][j]) answer = visited[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

    }
}