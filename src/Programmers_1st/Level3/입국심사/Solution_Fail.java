package Programmers_1st.Level3.입국심사;

import java.util.Arrays;

class Solution_Fail {
    long answer = Long.MAX_VALUE;

    void foo(int n, int idx,int[] gap,int[] times){
        if(n == 0){
            long gMax = 0;
            for (int i = 0; i <idx; i++) {
                int tmp = gap[i]*times[i];
                gMax = Math.max(tmp,gMax);
            }
            answer = Math.min(answer,gMax);
            return;
        }
        if(idx>= gap.length) return;

        for (int i = 0; i <= n; i++) {
            gap[idx] = i;
            if(n-gap[idx]<0) continue;
            foo(n-gap[idx],idx+1,gap,times);
        }

    }

    public long solution(int n, int[] times) {


        Arrays.sort(times);
        int[] gap = new int[times.length];

        for (int i = 0; i <=n ; i++) {
            gap[0]=i;
            foo(n-gap[0],1,gap,times);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_Fail s = new Solution_Fail();
        System.out.println("s.solution(6,new int[]{7,10}) = " + s.solution(6, new int[]{7, 10}));
        System.out.println("s.solution(3, new int[]{1, 1,1}) = " + s.solution(3, new int[]{1, 1,1}));
        System.out.println("s.solution(3, new int[]{1, 2,3}) = " + s.solution(3, new int[]{1, 2,3}));
    }
}
