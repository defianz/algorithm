package Programmers.Level2.배달;

class Solution {

    int[][] map;
    int n;
    int[] d;
    boolean[] check;

    int getSmallIndex(){
        int min = 500000*10001;
        int index = 1;
        for (int i = 1; i <= n; i++) {
            if(d[i] < min && !check[i]){
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    void dijkstra(int start){
        for (int i = 1; i <= n; i++) {
            d[i] = map[start][i];
        }
        check[start] = true;

        for (int i = 1; i <= n-1; i++) {
            int cur = getSmallIndex();
            check[cur] = true;
            for (int j = 1; j <=n ; j++) {
                if(!check[j]){
                    if(d[cur] + map[cur][j] < d[j]){
                        d[j] = d[cur] + map[cur][j];
                    }
                }
            }
        }

    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                map[i][j] =500000*10001;
                if(i==j) map[i][j] = 0;
            }
        }

        n = N;
        d = new int[n+1];
        check = new boolean[n+1];

        for (int i = 0; i < road.length; i++) {
            int st = road[i][0];
            int dt = road[i][1];
            int cost = road[i][2];
            if(map[st][dt] > cost) {
                map[st][dt] = cost;
                map[dt][st] = cost;
            }
        }

        dijkstra(1);

        for (int i = 1; i <= n; i++) {
            if(d[i] <= K) answer++;
        }
        

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println("s.solution(5,new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}},3) = " + s.solution(5, new int[][]{{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3));
        System.out.println("s.solution(\t6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4) = " + s.solution(6, new int[][]{{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}}, 4));
    }
}