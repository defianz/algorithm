package Study.weeklychallenge.week3;


import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {


    List<List<point>> blocks = new ArrayList<>();
    boolean[][] check_table;
    int[][] game_board_clone;
    int answer;


    class point{
        int r;
        int c;
        int maxR;
        int maxC;

        point(int a, int b, int c, int d){
            this.r = a;
            this.c = b;
            this.maxR = c;
            this.maxC = d;
        }
    }

    int[] dr = new int[]{-1,0,1,0};
    int[] dc = new int[]{0,1,0,-1};

    public int solution(int[][] game_board, int[][] table) {
        int table_row_length = table.length;
        check_table = new boolean[table_row_length][table_row_length];
        game_board_clone = game_board;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if(check_table[i][j] == false && table[i][j] == 1){
                    check_table[i][j] = true;
                    addBlock(i,j,table);
                }
            }
        }

        boolean[] check_block = new boolean[blocks.size()];
        dfs(0, check_block);

        return answer;
    }

    private void dfs(int blockCnt, boolean[] check_block) {
        if(blockCnt == blocks.size()){
            checkAnswer();
            return;
        }

        for (int i = 0; i < blocks.size(); i++) {
            if(check_block[i] == false){
                check_block[i] = true;
                List<point> drawPoints = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    drawPoints = drawGameBoard(blocks.get(i),j);
                }
                dfs(blockCnt+1, check_block);
                check_block[i] = false;
                backGameBoard(drawPoints);
            }
        }
    }


    private List<point> drawGameBoard(List<point> block, int blockDir) {

        List<point> tmp = new ArrayList<>();
        int maxR = block.get(0).maxR;
        int maxC = block.get(0).maxC;
        for (int i = 0; i < block.size(); i++) {
            point cur = block.get(i);
            tmp.add()
        }
        block = tmp;

        boolean flag = false;
        for (int i = 0; i < game_board_clone.length; i++) {
            for (int j = 0; j < game_board_clone.length; j++) {
                if(game_board_clone[i][j] == 0){
                    List<point> drawPoint = new ArrayList<>();
                    for (point point : block) {
                        int cr = point.r + i;
                        int cc = point.c + j;
                        if(cr < 0 || cr > game_board_clone.length-1 || cc < 0 || cc > game_board_clone.length-1) {
                            backGameBoard(drawPoint);
                            flag = false;
                            break;
                        }
                        if(game_board_clone[cr][cc] == 0){
                            drawPoint.add(new point(cr,cc));
                            game_board_clone[cr][cc] = 2;
                        } else {
                            backGameBoard(drawPoint);
                            flag = false;
                            break;
                        }
                        flag = true;
                    }
                    if(flag) {
                        if(checkInj(drawPoint)){
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

    private boolean checkInj(List<point> drawPoint) {
        for (point point : drawPoint) {
            int cr = point.r;
            int cc = point.c;
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr <0 || nr > game_board_clone.length-1 || nc < 0 || nc > game_board_clone.length-1) continue;
                if(game_board_clone[nr][nc] == 0) return false;
            }
        }
        return true;
    }

    private void backGameBoard(List<point> drawPoint) {
        for (point point1 : drawPoint) {
            game_board_clone[point1.r][point1.c] = 0;
        }
        return;
    }

    private void checkAnswer() {
        int tmp = 0;
        for (int i = 0; i < game_board_clone.length; i++) {
            for (int j = 0; j < game_board_clone.length; j++) {
                if(game_board_clone[i][j] == 2) tmp++;
            }
        }

        System.out.println();
        for (int i = 0; i < game_board_clone.length; i++) {
            for (int j = 0; j < game_board_clone.length; j++) {
                System.out.print(game_board_clone[i][j] + " ");
            }
            System.out.println();
        }

        answer = Math.max(tmp,answer);
        return;
    }

    private void addBlock(int i, int j, int[][] table) {
        List<point> block = new ArrayList<>();
        Queue<point> q = new LinkedList<>();

        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;

        q.add(new point(i,j,maxR,maxC));

        while(!q.isEmpty()){
            point curPoint = q.poll();
            int cr = curPoint.r;
            int cc = curPoint.c;
            maxR = Math.max(curPoint.maxR,maxR);
            maxC = Math.max(curPoint.maxC,maxC);
            block.add(new point(cr-i,cc-j, maxR - i, maxC - j));

            for (int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                int nMaxR = Math.max(maxR,nr);
                int nMaxC = Math.max(maxC,nc);

                if(nr <0 || nr > table.length-1 || nc < 0 || nc > table.length-1) continue;
                if(check_table[nr][nc] == false && table[nr][nc] == 1){
                    q.add(new point(nr,nc,nMaxR,nMaxC));
                    check_table[nr][nc] = true;
                }
            }
        }
        block.get(0).maxR = maxR;
        block.get(0).maxC = maxC;
        blocks.add(block);
        return;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}},
                new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}}));
    }
}
