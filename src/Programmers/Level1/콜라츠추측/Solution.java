package Programmers.Level1.콜라츠추측;

class Solution {
    public int solution(long num) {

        int cnt = 0;
        if(num == 1 ) return 0;
        while(true){
            cnt++;
            if(num % 2 == 0 ) num /= 2;
            else num = num * 3 + 1;

            if(num == 1) return cnt;
            else if (cnt == 500) return -1;
        }

    }
}
