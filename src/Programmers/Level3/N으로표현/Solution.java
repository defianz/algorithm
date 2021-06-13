package Programmers.Level3.N으로표현;

class Solution {

    int Target;
    int n;
    int answer;

    void foo(int cnt, int prev){
        if(cnt>8) return;
        if(prev == Target){
            answer = Math.min(answer,cnt);
            return;
        }

        int tempN = n;
        for (int i = 0; i < 8; i++) {
            int newCount = cnt + 1 +i;
            foo(newCount, prev + tempN);
            foo(newCount, prev - tempN);
            foo(newCount, prev / tempN);
            foo(newCount, prev * tempN);
            tempN = 10*tempN + n;
        }

    }

    public int solution(int N, int number) {
        answer = 10;
        Target = number;
        n = N;

        foo(0,0);

        if(answer == 10 ) answer = -1;

        return answer;
    }
}