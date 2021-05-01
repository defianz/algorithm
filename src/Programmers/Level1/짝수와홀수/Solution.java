package Programmers.Level1.짝수와홀수;

class Solution {
    public String solution(int num) {
        String answer = "";
        answer = num % 2 == 0 ? "Even" : "Odd";
        return answer;
    }
}
