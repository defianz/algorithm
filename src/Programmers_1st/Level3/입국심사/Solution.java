package Programmers_1st.Level3.입국심사;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {


        Arrays.sort(times);
        long l = 0;
        long r = (long)times[times.length-1]*(long)n;
        long answer = r;
        long mid,hap;

        while(l<=r){
            mid = (l+r)/2;
            hap = 0;
            for (int i = 0; i < times.length; i++) {
                hap += mid/times[i];
                if(hap>=n) break;
            }

            if(hap >= n){
                r = mid -1;
                answer = Math.min(answer,mid);
            } else {
                l = mid +1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(6,new int[]{7,10}) = " + s.solution(6, new int[]{7, 10}));
    }
}
