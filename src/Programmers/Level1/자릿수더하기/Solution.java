package Programmers.Level1.자릿수더하기;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        while(n!=0){
            answer += n%10;
            n = n/10;
        }

        return answer;
    }
}
