
package Programmers.Level2.조이스틱;

class Solution_best {
    public int solution(String name) {
        int answer = 0;


        int len = name.length();
        int min_move = len-1;

        for (int i = 0; i < len; i++) {
            char nxt = name.charAt(i);
            answer +=  nxt - 'A' <= 'Z' - nxt + 1 ? nxt-'A' : 'Z' - nxt + 1;

            int next = i+1;
            while(next < len && name.charAt(next) == 'A')
                next++;

            min_move = Math.min(min_move,i+len-next+i);
        }
        answer += min_move;

        return answer;
    }
}