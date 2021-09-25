package Study.weeklychallenge.week3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution_Solving {


    List<List<point>> blocks = new ArrayList<>();
    boolean[][] check_table;
    int[][] game_board_clone;
    int answer;


    class point {
        int r;
        int c;
        int maxR;
        int maxC;
        int minR;
        int minC;

        point(int a, int b, int c, int d, int e, int f) {
            this.r = a;
            this.c = b;
            this.maxR = c;
            this.maxC = d;
            this.minR = e;
            this.minC = f;
        }
    }

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, 1, 0, -1};

    public int solution(int[][] game_board, int[][] table) {
        int table_row_length = table.length;
        check_table = new boolean[table_row_length][table_row_length];
        game_board_clone = game_board;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (check_table[i][j] == false && table[i][j] == 1) {
                    check_table[i][j] = true;
                    addBlock(i, j, table);
                }
            }
        }

        boolean[] check_block = new boolean[blocks.size()];
        dfs(0, check_block);

        return answer;
    }

    private void dfs(int blockCnt, boolean[] check_block) {
        if (blockCnt == blocks.size()) {
            checkAnswer();
            return;
        }

        for (int i = 0; i < blocks.size(); i++) {
            if (check_block[i] == false) {
                check_block[i] = true;
                List<dPoint> drawPoints = new ArrayList<>();
                for (int j = 0; j < 360; j += 90) {
                    drawPoints = drawGameBoard(blocks.get(i), j);
                }
                dfs(blockCnt + 1, check_block);
                check_block[i] = false;
                backGameBoard(drawPoints);
            }
        }
    }


    private List<dPoint> drawGameBoard(List<point> block, int blockDir) {


        block = rotate90(block, blockDir);

        boolean flag = false;
        for (int i = 0; i < game_board_clone.length; i++) {
            for (int j = 0; j < game_board_clone.length; j++) {
                if (game_board_clone[i][j] == 0) {
                    List<dPoint> drawPoint = new ArrayList<>();
                    for (point point : block) {
                        int cr = point.r + i;
                        int cc = point.c + j;
                        if (cr < 0 || cr > game_board_clone.length - 1 || cc < 0 || cc > game_board_clone.length - 1) {
                            backGameBoard(drawPoint);
                            flag = false;
                            break;
                        }
                        if (game_board_clone[cr][cc] == 0) {
                            drawPoint.add(new dPoint(cr, cc));
                            game_board_clone[cr][cc] = 2;
                        } else {
                            backGameBoard(drawPoint);
                            flag = false;
                            break;
                        }
                        flag = true;
                    }
                    if (flag) {
                        if (checkInj(drawPoint)) {
                            return drawPoint;
                        } else {
                            backGameBoard(drawPoint);
                        }
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private List<point> rotate90(List<point> block, int blockDir) {
        List<point> tmp = new ArrayList<>();
        for (point point : block) {
            switch (blockDir) {
                case 0:
                    break;
                case 90:
//                    rotate[i][j] = arr[5 - j][i];
                    int tmp90 = point.r;
                    point.r = point.maxR - point.c;
                    point.c = tmp90;
                    break;
                case 180:
//                    rotate[i][j] = arr[5 - i][5 - j];
                    point.r = point.maxR - point.r;
                    point.c = point.maxC - point.c;
                    break;
                case 270:
//                    rotate[i][j] = arr[j][5 - i];
                    int tmp270 = point.r;
                    point.r = point.c;
                    point.c = point.maxC - tmp270;
                    break;
            }
            tmp.add(point);
        }
        return tmp;
    }

    private boolean checkInj(List<dPoint> drawPoint) {
        for (dPoint point : drawPoint) {
            int cr = point.r;
            int cc = point.c;
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nr > game_board_clone.length - 1 || nc < 0 || nc > game_board_clone.length - 1) continue;
                if (game_board_clone[nr][nc] == 0) return false;
            }
        }
        return true;
    }

    private void backGameBoard(List<dPoint> drawPoint) {
        for (dPoint point1 : drawPoint) {
            game_board_clone[point1.r][point1.c] = 0;
        }
        return;
    }

    private void checkAnswer() {
        int tmp = 0;
        for (int i = 0; i < game_board_clone.length; i++) {
            for (int j = 0; j < game_board_clone.length; j++) {
                if (game_board_clone[i][j] == 2) tmp++;
            }
        }

        System.out.println();
        for (int i = 0; i < game_board_clone.length; i++) {
            for (int j = 0; j < game_board_clone.length; j++) {
                System.out.print(game_board_clone[i][j] + " ");
            }
            System.out.println();
        }

        answer = Math.max(tmp, answer);
        return;
    }

    private void addBlock(int i, int j, int[][] table) {
        List<point> block = new ArrayList<>();
        Queue<point> q = new LinkedList<>();

        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;

        q.add(new point(i, j, maxR, maxC, minR, minC));

        while (!q.isEmpty()) {
            point curPoint = q.poll();
            int cr = curPoint.r;
            int cc = curPoint.c;
            maxR = Math.max(curPoint.maxR, maxR);
            maxC = Math.max(curPoint.maxC, maxC);
            minR = Math.min(curPoint.minR, minR);
            minC = Math.min(curPoint.minC, minC);

            block.add(new point(cr, cc, maxR, maxC, minR, minC));

            for (int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                int nMaxR = Math.max(maxR, nr);
                int nMaxC = Math.max(maxC, nc);
                int nMinR = Math.max(minR, nr);
                int nMinC = Math.max(minC, nc);

                if (nr < 0 || nr > table.length - 1 || nc < 0 || nc > table.length - 1) continue;
                if (check_table[nr][nc] == false && table[nr][nc] == 1) {
                    q.add(new point(nr, nc, nMaxR, nMaxC, nMinR, nMinC));
                    check_table[nr][nc] = true;
                }
            }
        }

        for (point point : block) {
            point.r = point.r - minR;
            point.c = point.c - minC;
            point.maxR = maxR;
            point.maxC = maxC;
            point.minR = minR;
            point.minC = minC;
        }

        blocks.add(block);
        return;
    }

    public static void main(String[] args) {
        Solution_Solving s = new Solution_Solving();
        System.out.println(s.solution(new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}},
                new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}}));
    }

    private class dPoint {
        int r;
        int c;

        public dPoint(int cr, int cc) {
            this.r = cr;
            this.c = cc;
        }
    }
}
