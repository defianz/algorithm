package Programmers.Level1.로또의최고순위와최저순위;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];


        int cnt =0;
        int zero =0;
        for (int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0 ) zero++;
            for (int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == win_nums[j]) cnt++;
            }
        }

        answer[0] = (cnt+zero) >=2 ?7 - cnt - zero : 6;
        answer[1] = cnt >= 2 ? 7 - cnt : 6;



        return answer;
    }
}