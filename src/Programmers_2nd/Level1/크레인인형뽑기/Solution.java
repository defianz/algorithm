package Programmers_2nd.Level1.크레인인형뽑기;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;

        Stack<Integer>[] map = new Stack[n];
        for (int i = 0; i < n; i++) {
            map[i] = new Stack<>();
        }


        Stack<Integer> top = new Stack<>();

        for (int j = 0; j < n; j++) {
            for (int i = n-1; i >= 0; i--) {
                if(board[i][j] == 0) break;
                else map[j].add(board[i][j]);
            }
        }

        for (int chooseLine : moves){
            if(map[chooseLine-1].empty()) continue;
            int choosed = map[chooseLine-1].pop();

            if(top.empty()) {
                top.add(choosed);
                continue;
            }

            if(!top.empty() && top.peek() == choosed) {
                top.pop();
                answer += 2;
            } else {
                top.add(choosed);
            }

        }

        return answer;
    }
}