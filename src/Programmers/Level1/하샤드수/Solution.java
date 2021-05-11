package Programmers.Level1.하샤드수;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int tmp = 0;
        int tmp2 = x;
        while(tmp2 != 0){
            tmp += tmp2%10;
            tmp2 /= 10;
        }
        if(x % tmp != 0 ) answer = false;

        return answer;
    }
}
