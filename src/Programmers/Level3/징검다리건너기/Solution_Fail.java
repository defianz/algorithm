package Programmers.Level3.징검다리건너기;


class Solution_Fail {

    public int solution(int[] stones, int k) {
        int answer = 0;
        int stLen = stones.length;

        int minStone = Integer.MAX_VALUE;
        for (int i = 0; i < stLen; i++) {
            minStone = Math.min(stones[i],minStone);
        }


        while(true){
            answer += minStone;
            int nxtMinStone = Integer.MAX_VALUE;

            int cnt = 0;
            for (int i = 0; i < stLen ; i++) {
                if(stones[i] != 0) {
                    stones[i] -= minStone;
                    nxtMinStone = Math.min(nxtMinStone,stones[i]);
                }

                if(stones[i] == 0) cnt++;
                else cnt = 0;

                if(cnt == k) return answer;
            }
            minStone = nxtMinStone;
        }
    }

    public static void main(String[] args) {
        Solution_Fail s = new Solution_Fail();
        System.out.println("s.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3) = " + s.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
}