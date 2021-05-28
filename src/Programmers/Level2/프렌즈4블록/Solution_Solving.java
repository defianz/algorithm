package Programmers.Level2.프렌즈4블록;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.Set;

class Solution_Solving {
    public int solution(int m, int n, String[] board) {
        int answer = 0;


        int rowN = board.length;
        int colN = board[0].length();

        char[][] boardChar = new char[rowN][colN];


        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                boardChar[i][j] = board[i].charAt(j);
            }
        }


        Set<Pair<Integer,Integer>> set = new HashSet<>();
        boolean move = true;

        while(move){
            move = false;

            for (int i = 0; i < rowN-1; i++) {
                for (int j = 0; j < colN-1; j++) {
                    char st = boardChar[i][j];
                    if(boardChar[i+1][j] == st && boardChar[i+1][j+1] == st && boardChar[i][j+1] == st ){
                        set.add(new Pair<>(i+1,j));
                        set.add(new Pair<>(i+1,j+1));
                        set.add(new Pair<>(i,j+1));
                    }
                }
            }
            if(set.size() != 0 ) {
                move = true;
                answer += set.size();

                for(Pair p : set){
                    p.
                }




            }

        }



        return answer;
    }
}
