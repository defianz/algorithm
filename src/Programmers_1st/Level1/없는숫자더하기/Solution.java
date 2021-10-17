package Programmers_1st.Level1.없는숫자더하기;

class Solution {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int number : numbers) {
            answer -= number;
        }
        return answer;
    }
}
