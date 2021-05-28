package Programmers.Level2.프렌즈4블록;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {

    int rowM;
    int colN;

    void makeMap(char[][] map, ArrayList<Character> arl[]){

        for (int i = rowM-1; i >= 0; i--) {
            for (int j = 0; j < colN; j++) {
                if(arl[j].size()-1 >= i){
                    map[i][j] = arl[j].get(i);
                } else {
                    map[i][j] = '0';
                }
            }
        }


//        for (int i = rowM-1; i >= 0; i--) {
//            for (int j = 0; j < colN; j++) {
//                System.out.print(map[i][j]+ " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        rowM = m;
        colN = n;

        ArrayList<Character>[] arl = new ArrayList[colN];
        for (int i = 0; i < colN; i++) {
            arl[i] = new ArrayList<>();
        }
        boolean move = true;

        for (int i = rowM-1; i >= 0; i--) {
            for (int j = 0; j < colN; j++) {
                arl[j].add((board[i].charAt(j)));
            }
        }

        char[][] map = new char[m][n];
        HashSet<String> hs = new HashSet<>();
        boolean[][] remove = new boolean[m][n];


        while(move){
            move = false;

            makeMap(map, arl);

            for (int i = 0; i < rowM-1; i++) {
                for (int j = 0; j < colN-1; j++) {
                    if(map[i][j] == '0') continue;
                    char st = map[i][j];
                    if(map[i+1][j] == st && map[i+1][j+1] == st && map[i][j+1] == st){
                        hs.add(i + " " + j);
                        hs.add((i+1) + " " + j);
                        hs.add((i+1) + " " + (j+1));
                        hs.add(i + " " + (j+1));
                        move = true;
                    }
                }
            }

            if(move==true){
                answer += hs.size();
                for(String a: hs){
                    String[] tmp = a.split(" ");
                    int row = Integer.parseInt(tmp[0]);
                    int col = Integer.parseInt(tmp[1]);
                    remove[row][col] = true;
                }
                hs.clear();

                for (int i = m-1; i >= 0; i--) {
                    for (int j = 0; j < n; j++) {
                        if(remove[i][j]){
                            arl[j].remove(i);
                            remove[i][j] = false;
                        }
                    }
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(6,6,new String[]{\"TTTANT\", \"RRFACC\", \"RRRFCC\", \"TRRRAA\", \"TTMMMF\", \"TMMTTJ\"}) = " + s.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
        System.out.println("s.solution(4,5,new String[]{\"CCBDE\", \"AAADE\", \"AAABF\", \"CCBBF\"}) = " + s.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
    }
}
