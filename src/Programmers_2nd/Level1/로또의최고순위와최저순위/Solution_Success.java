package Programmers_2nd.Level1.로또의최고순위와최저순위;


import java.util.HashSet;

class Solution_Success {
    public int[] solution(int[] lottos, int[] win_nums) {

        int hitCnt = 0;
        int zeroCnt = 0;
        int[] rank = new int[]{6,6,5,4,3,2,1};

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < win_nums.length; i++) {
            hs.add(win_nums[i]);
        }

        for (int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                zeroCnt++;
            } else {
                if(hs.contains(lottos[i])){
                    hitCnt++;
                }
            }
        }

        int[] answer = new int[]{rank[zeroCnt+hitCnt], rank[hitCnt]};


        return answer;
    }
}
