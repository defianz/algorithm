package Programmers_1st.Level3.보행자천국;

import java.util.LinkedList;
import java.util.Queue;

class Solution_Fail {
    int MOD = 20170805;

    int[] dx = new int[]{0, 1};
    int[] dy = new int[]{1, 0};

    class Car {
        int x;
        int y;
        int dir;

        Car(int a, int b, int c) {
            this.x = a;
            this.y = b;
            this.dir = c;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    '}';
        }
    }

    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        Queue<Car> q = new LinkedList<>();

        q.add(new Car(0, 0, 0));

        while (!q.isEmpty()) {
            Car cur = q.poll();
            if (cur.x == m - 1 && cur.y == n - 1) {
                answer++;
                answer %= MOD;
                continue;
            }

            if (cityMap[cur.x][cur.y] == 0) {
                for (int dir = 0; dir < 2; dir++) {
                    int nx = cur.x + dx[dir];
                    int ny = cur.y + dy[dir];
                    int ndir = dir;
                    if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1) continue;
                    if (cityMap[nx][ny] == 1) continue;
                    q.add(new Car(nx, ny, ndir));
                }
            } else {
                int nx = cur.x + dx[cur.dir];
                int ny = cur.y + dy[cur.dir];
                int ndir = cur.dir;
                if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1) continue;
                if (cityMap[nx][ny] == 1) continue;
                q.add(new Car(nx, ny, ndir));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_Fail s = new Solution_Fail();
        System.out.println("s.solution(3,3,new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}) = " + s.solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println("s.solution(3,6,\tnew int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}\t) = " + s.solution(3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
    }
}
