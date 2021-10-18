package HankerRank.TheBombermanGame;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here
       int r = grid.size();
       int c = grid.get(0).length();

       int[][][] map = new int[r][c][5];
       int[] dr = new int[]{-1,0,1,0};
       int[] dc = new int[]{0,1,0,-1};

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid.get(i).charAt(j) == 'O')
                    map[i][j][1] = 1;
                else map[i][j][1] = -1;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j][1] == 1 ){
                    map[i][j][2] = 2;
                } else map[i][j][2] = 0;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j][2] == 1 ){
                    map[i][j][3] = 2;
                } else if(map[i][j][2] == 0)
                    map[i][j][3] = 1;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j][2] == 2){
                    map[i][j][3] = -1;
                    for (int dir = 0; dir < 4; dir++) {
                        int nr = i + dr[dir];
                        int nc = j + dc[dir];
                        if(nr < 0 || nr > r-1 || nc < 0 || nc > c-1) continue;
                        map[nr][nc][3] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
               map[i][j][4] = 2;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j][1] == 1){
                    map[i][j][4] = -1;
                    for (int dir = 0; dir < 4; dir++) {
                        int nr = i + dr[dir];
                        int nc = j + dc[dir];
                        if(nr < 0 || nr > r-1 || nc < 0 || nc > c-1) continue;
                        map[nr][nc][4] = -1;
                    }
                }
            }
        }



        int mok = n % 4;
        if(mok == 1 ) return toAnswer(map,1,r,c);
        else if(mok == 2 ) return toAnswer(map,2,r,c);
        else if(mok == 3 ) return toAnswer(map,3,r,c);
        else return toAnswer(map,4,r,c);

    }

    private static List<String> toAnswer(int[][][] map, int i, int r, int c) {
        List<String> tmp = new ArrayList<>();
        for (int j = 0; j < r; j++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < c; k++) {
                if(map[j][k][i] != -1 ) sb.append("O");
                else sb.append(".");
            }
            tmp.add(sb.toString());
        }
        return tmp;
    }


}

public class Solution_Solving {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = IntStream.range(0, r).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.bomberMan(n, grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
