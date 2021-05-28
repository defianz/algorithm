package Programmers.Level2.점프와순간이동;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n != 0){
            if(n%2==0){
                n /= 2;
            } else {
                n = (n-1)/2;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(5) = " + s.solution(5));
        System.out.println("s.solution(6) = " + s.solution(6));
        System.out.println("s.solution(5000) = " + s.solution(5000));
    }
}
