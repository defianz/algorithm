package Programmers.Level2.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int i = 3; i <= total/3; i++) {
            if(total % i != 0) continue;
            int se = i;
            int ga = total/i;
            if( ga < se ) continue;
            if(brown - 2 *(ga+se) + 4 == 0){
                answer[0] = ga;
                answer[1] = se;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] tmp = new Solution().solution(24, 24);
    }
}
