package Programmers.Level1.정수내림차순배치;

import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] tmp = String.valueOf(n).toCharArray();

        Arrays.sort(tmp);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            sb.append(tmp[i]);
        }
        sb.reverse();
        answer = Long.parseLong(sb.toString());
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution() = " + s.solution(70000000));
    }
}