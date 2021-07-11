package Programmers.Level3.외벽점검;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int answer = Integer.MAX_VALUE;

    boolean checkEnd(boolean[] check, int[] weak){
        for (int i = 0; i < weak.length; i++) {
            if(check[weak[i]] == false ) return false;
        }
        return true;
    }

    void foo(int idx, boolean[] check, int[] dist, int[] weak, int n){
        if(idx >= dist.length || idx+1 >= answer){
            return;
        }
        for (int i = 0; i < weak.length; i++) {
            if(check[weak[i]]) continue;
            ArrayList<Integer> arl = new ArrayList<>();
            for (int j = weak[i]; j <= weak[i]+dist[idx]; j++) {
                if( check[j%n] == true) continue;
                check[j%n] = true;
                arl.add(j%n);
            }
            if(checkEnd(check,weak)){
                if( answer > idx+1) answer = idx+1;
            }

            foo(idx+1,check,dist,weak,n);

            for(int a : arl){
                check[a] = false;
            }
        }

    }

    public int solution(int n, int[] weak, int[] dist) {

        boolean[] check = new boolean[n];

        Arrays.sort(dist);
        int[] distReverse = new int[dist.length];

        for (int i = 0; i < dist.length ; i++) {
            distReverse[i] = dist[dist.length-1-i];
        }

        foo(0, check,distReverse,weak, n);

        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(12,new int[]{1,5,6,10},new int[]{1,2,3,4}) = " + s.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
        System.out.println("s.solution(12,new int[]{1,3,4,9,10},new int[]{3,5,7}) = " + s.solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
    }
}