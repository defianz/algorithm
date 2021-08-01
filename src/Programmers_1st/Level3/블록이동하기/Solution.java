package Programmers_1st.Level3.블록이동하기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class robot {
        int lx;
        int ly;
        int rx;
        int ry;
        int dir;
        int time;

        robot(int a, int b, int c, int d, int e, int f) {
            this.lx = a;
            this.ly = b;
            this.rx = c;
            this.ry = d;
            this.dir = e;
            this.time = f;
        }
    }

    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    boolean checkGo(int nlx, int nly, int nrx, int nry, int ndir, int n, int[][] board, boolean[][][] check) {

        if (nlx < 0 || nlx > n - 1 || nly < 0 || nly > n - 1 || nrx < 0 || nrx > n - 1 || nry < 0 || nry > n - 1)
            return false;
        if (board[nlx][nly] == 1 || board[nrx][nry] == 1) return false;
        if (check[nlx][nly][ndir] && check[nrx][nry][ndir]) return false;
        return true;
    }

    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        int n = board.length;
        boolean[][][] check = new boolean[n][n][2];

        Queue<robot> q = new LinkedList<>();
        q.add(new robot(0, 0, 0, 1, 0, 0));
        check[0][0][0] = check[0][1][0] = true;


        while (!q.isEmpty()) {
            robot cur = q.poll();
//            System.out.println("cur.lx = " + cur.lx);
//            System.out.println("cur.ly = " + cur.ly);
//            System.out.println("cur.rx = " + cur.rx);
//            System.out.println("cur.ry = " + cur.ry);
//            System.out.println("cur.dir = " + cur.dir);
//            System.out.println("cur.time = " + cur.time);
//            System.out.println();
            if ((cur.lx == n - 1 && cur.ly == n - 1) || (cur.rx == n - 1 && cur.ry == n - 1)) {
                if (answer > cur.time) answer = cur.time;
                break;
            }

            int nlx, nly, nrx, nry, ndir, ntime;
            for (int dir = 0; dir < 4; dir++) {
                nlx = cur.lx + dx[dir];
                nly = cur.ly + dy[dir];
                nrx = cur.rx + dx[dir];
                nry = cur.ry + dy[dir];
                ndir = cur.dir;
                ntime = cur.time + 1;

                if (!checkGo(nlx, nly, nrx, nry, ndir, n, board, check)) continue;
                check[nlx][nly][ndir] = check[nrx][nry][ndir] = true;
                q.add(new robot(nlx, nly, nrx, nry, ndir, ntime));
            }


            if (cur.dir == 0) {
                // 왼쪽 기준 90도 위로
                nlx = cur.lx - 1;
                nly = cur.ly;
                nrx = cur.lx;
                nry = cur.ly;
                ndir = 1;
                ntime = cur.time + 1;

                if (checkGo(nlx, nly, nrx, nry, ndir, n, board, check)) {
                    if (board[cur.rx - 1][cur.ry] == 0) {
                        check[nlx][nly][ndir] = check[nrx][nry][ndir] = true;
                        q.add(new robot(nlx, nly, nrx, nry, ndir, ntime));
                    }
                }


                // 왼쪽 기준 90도 아래로
                nlx = cur.lx;
                nly = cur.ly;
                nrx = cur.lx + 1;
                nry = cur.ly;
                ndir = 1;
                ntime = cur.time + 1;

                if (checkGo(nlx, nly, nrx, nry, ndir, n, board, check)) {
                    if (board[cur.rx + 1][cur.ry] == 0) {
                        check[nlx][nly][ndir] = check[nrx][nry][ndir] = true;
                        q.add(new robot(nlx, nly, nrx, nry, ndir, ntime));
                    }

                }


                //오른쪽 기준 90도 위로

                nlx = cur.rx - 1;
                nly = cur.ry;
                nrx = cur.rx;
                nry = cur.ry;
                ndir = 1;
                ntime = cur.time + 1;

                if (checkGo(nlx, nly, nrx, nry, ndir, n, board, check)) {
                    if (board[cur.lx - 1][cur.ly] == 0) {
                        check[nlx][nly][ndir] = check[nrx][nry][ndir] = true;
                        q.add(new robot(nlx, nly, nrx, nry, ndir, ntime));
                    }
                }


                // 오른쪽 기준 90도 아래로

                nlx = cur.rx;
                nly = cur.ry;
                nrx = cur.rx + 1;
                nry = cur.ry;
                ndir = 1;
                ntime = cur.time + 1;

                if (checkGo(nlx, nly, nrx, nry, ndir, n, board, check)) {
                    if (board[cur.lx + 1][cur.ly] == 0) {
                        check[nlx][nly][ndir] = check[nrx][nry][ndir] = true;
                        q.add(new robot(nlx, nly, nrx, nry, ndir, ntime));
                    }
                }

            } else {
                // 위쪽 기준 왼쪽으로
                nlx = cur.lx;
                nly = cur.ly - 1;
                nrx = cur.lx;
                nry = cur.ly;
                ndir = 0;
                ntime = cur.time + 1;
                if (checkGo(nlx, nly, nrx, nry, ndir, n, board, check)) {
                    if (board[cur.rx][cur.ry - 1] == 0) {
                        check[nlx][nly][ndir] = check[nrx][nry][ndir] = true;
                        q.add(new robot(nlx, nly, nrx, nry, ndir, ntime));
                    }
                }


                //위쪽 기준 오른쪽으로
                nlx = cur.lx;
                nly = cur.ly;
                nrx = cur.lx;
                nry = cur.ly + 1;
                ndir = 0;
                ntime = cur.time + 1;
                if (checkGo(nlx, nly, nrx, nry, ndir, n, board, check)) {
                    if (board[cur.rx][cur.ry + 1] == 0) {
                        check[nlx][nly][ndir] = check[nrx][nry][ndir] = true;
                        q.add(new robot(nlx, nly, nrx, nry, ndir, ntime));
                    }
                }

                // 아래쪽 기준 왼쪽으로
                nlx = cur.rx;
                nly = cur.ry - 1;
                nrx = cur.rx;
                nry = cur.ry;
                ndir = 0;
                ntime = cur.time + 1;
                if (checkGo(nlx, nly, nrx, nry, ndir, n, board, check)) {
                    if (board[cur.lx][cur.ly - 1] == 0) {
                        check[nlx][nly][ndir] = check[nrx][nry][ndir] = true;
                        q.add(new robot(nlx, nly, nrx, nry, ndir, ntime));
                    }
                }

                // 아래쪽 기준 오른쪽으로
                nlx = cur.rx;
                nly = cur.ry;
                nrx = cur.rx;
                nry = cur.ry + 1;
                ndir = 0;
                ntime = cur.time + 1;
                if (checkGo(nlx, nly, nrx, nry, ndir, n, board, check)) {
                    if (board[cur.lx][cur.ly + 1] == 0) {
                        check[nlx][nly][ndir] = check[nrx][nry][ndir] = true;
                        q.add(new robot(nlx, nly, nrx, nry, ndir, ntime));
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}}));
    }
}