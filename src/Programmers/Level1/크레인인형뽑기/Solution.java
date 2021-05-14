package Programmers.Level1.크레인인형뽑기;

import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        Stack<Integer>[] bst = new Stack[board[0].length];

        for (int i = 0; i < bst.length; i++) {
            bst[i] = new Stack<>();
        }

        for (int j = 0; j < board[0].length; j++) {
            for (int i = board.length-1 ; i >= 0; i--) {
                if(board[i][j] == 0) continue;
                bst[j].add(board[i][j]);
            }
        }


        for (int i = 0; i < moves.length; i++) {
            int idx = moves[i]-1;
            if(bst[idx].empty()) continue;

            int nxt = bst[idx].peek();
            bst[idx].pop();

            if(!st.empty() && st.peek() == nxt){
                st.pop();
                answer += 2;
            } else {
                st.add(nxt);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1,5,3,5,1,2,1,4}));
    }
}
