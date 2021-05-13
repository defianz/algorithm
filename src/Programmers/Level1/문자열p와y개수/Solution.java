package Programmers.Level1.문자열p와y개수;


class Solution {
    boolean solution(String s) {
        int pcnt=0 ,ycnt =0;
        String[] tmp = s.toLowerCase().split("");
        for(String a : tmp){
            if(a.equals("p")) pcnt++;
            if(a.equals("y")) ycnt++;
        }

        return pcnt==ycnt;
    }
}
