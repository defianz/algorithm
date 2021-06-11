package Programmers.Level3.입국심사;

import java.util.Arrays;

class Solution_Solving {
    long answer = Long.MAX_VALUE;

    void foo(int n, int idx,int[] gap,int[] times){
        if(n <= 0){
            long gMax = 0;
            for (int i = 0; i <idx; i++) {
                int tmp = gap[i]*times[i];
                gMax = Math.max(tmp,gMax);
            }
            System.out.println("gMax = " + gMax);
            answer = Math.min(answer,gMax);
            return;
        }
        if(idx>= gap.length) return;

        for (int i = 0; i <= n; i++) {
            gap[idx] = i;
            foo(n-times[idx]*i,idx+1,gap,times);
            gap[idx] = 0;
        }

    }

    public long solution(int n, int[] times) {


        Arrays.sort(times);
        int[] gap = new int[times.length];

        for (int i = 0; i <=n ; i++) {
            gap[0]=i;
            foo(n-times[0]*i,1,gap,times);
            gap[0]=0;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_Solving s = new Solution_Solving();
        System.out.println("s.solution(6,new int[]{7,10}) = " + s.solution(6, new int[]{7, 10}));
        System.out.println("s.solution(3, new int[]{1, 1,1}) = " + s.solution(3, new int[]{1, 1,1}));
        System.out.println("s.solution(3, new int[]{1, 2,3}) = " + s.solution(3, new int[]{1, 2,3}));
    }
}
