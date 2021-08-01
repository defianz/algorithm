package Programmers_1st.Level3.NQueen;

class Solution {
    int answer = 0;

    boolean isPossible(int[] board, int idx, int nxt){

        int tmp = nxt;
        int tmp2 = nxt;
        for (int i = idx-1; i >= 1; i--) {
            if(board[i] == nxt) return false;
            tmp -= 1;
            tmp2 += 1;
            if(tmp == board[i]) return false;
            if(tmp2 == board[i]) return false;
        }
        return true;
    }

    void foo(int cnt,int n, int[] board){
        if(cnt == n){
            answer++;

            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!isPossible(board,cnt+1, i)) continue;
            board[cnt+1]=i;
            foo(cnt+1,n,board);
        }
    }


    public int solution(int n) {

        int[] board = new int[n+1];

        for (int i = 1; i <= n; i++) {
            board[1] = i;
            foo(1,n, board);
        }


        return answer;
    }
}
