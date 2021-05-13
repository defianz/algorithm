package Programmers.Level1.나누어떨어지는숫자배열;


import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {

        Arrays.sort(arr);
        int[] answer = Arrays.stream(arr).filter(e -> e % divisor ==0).toArray();
        if(answer.length==0) return new int[]{-1};

        return answer;
    }
}
