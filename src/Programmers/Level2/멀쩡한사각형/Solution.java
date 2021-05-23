package Programmers.Level2.멀쩡한사각형;

class Solution {
    public long solution(long w, long h) {
        long answer = 0;

        for (int i = 1; i < w; i++) {
            answer += Math.floor((double) h * i/ (double) w);
        }

        return answer * 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(8,12) = " + s.solution(8, 12));
    }
}