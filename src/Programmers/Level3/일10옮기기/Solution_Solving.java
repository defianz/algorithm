package Programmers.Level3.일10옮기기;

class Solution_Solving {


    String foo(String s ){

        s.indexOf("110");


    }

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i <s.length ; i++) {
            answer[i] = foo(s[i]);
        }

        return answer;
    }
}