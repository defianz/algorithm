package Programmers.Level3.합승택시요금;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] adj = new int[n+1][n+1];

        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int des = fares[i][1];
            int cost = fares[i][2];
            adj[start][des] = cost;
            adj[des][start] = cost;
        }

        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dist[i][j] = 2000001;
            }
        }

        boolean[][] check = new boolean[n+1][n+1];

        int[] tmparr = new int[]{a,b,s};


        for (int x : tmparr) {
            dist[x][x] = 0;
            for (int i = 1; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                int idx = -1;

                for (int j = 1; j <= n; j++) {
                    if (!check[x][j] && min > dist[x][j]) {
                        min = dist[x][j];
                        idx = j;
                    }
                }

                for (int j = 1; j <= n; j++) {
                    if (!check[x][j] && adj[idx][j] != 0 && dist[x][idx] + adj[idx][j] < dist[x][j]) {
                        dist[x][j] = dist[x][idx] + adj[idx][j];
                    }
                }
                check[x][idx] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            int tmp = dist[s][i] + dist[a][i] + dist[b][i];
            if (answer > tmp) answer = tmp;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(6,4,6,2,new int[]  {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}) = " + s.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
    }
}
