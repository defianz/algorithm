package Programmers.Level2.Hindex;

import java.util.Arrays;

class Solution_Solving {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int tmp = citations[citations.length-1];

        for (int i = tmp; i >= 0; i--) {
            citations[citations.length]
        }



        return answer;
    }

    public static void main(String[] args) {
        System.out.println("new Solution().solution(new int[]{3,0,6,1,5}) = " + new Solution_Solving().solution(new int[]{3,0,6,1,5}));
        System.out.println("new Solution().solution(new int[]{3,0,6,1,5}) = " + new Solution_Solving().solution(new int[]{1,2,3,4,5,4,4,4,1,1,1,1}));
    }
}
