package Programmers_1st.Level2.Hindex;
import java.util.Arrays;


class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int hmax = citations[citations.length-1];

        for (int i=hmax; i>0; i--){
            if(i==0 || i > 1000) continue;
            if(i <= citations.length && citations[citations.length-i] >= i) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("new Solution().solution(new int[]{3,0,6,1,5}) = " + new Solution().solution(new int[]{3,0,6,1,5}));
        System.out.println("new Solution().solution(new int[]{3,0,6,1,5}) = " + new Solution().solution(new int[]{1,2,3,4,5,4,4,4,1,1,1,1}));
        System.out.println("new Solution().solution(new int[]{6,5,4,1,0}) = " + new Solution().solution(new int[]{6,5,4,1,0}));
    }
}