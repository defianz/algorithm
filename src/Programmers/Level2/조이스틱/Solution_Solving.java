package Programmers.Level2.조이스틱;

class Solution_Solving {
    public int solution(String name) {
        int answer = 0;


        for (int i = 0; i < name.length(); i++) {

        }


        for (int i = 0; i < name.length(); i++) {
            char nxt = name.charAt(i);

            if(nxt - 'A' < 'Z' - nxt +1){
                answer += nxt-'A';
            } else {
                answer += 'Z'-nxt+1;
            }

        }

        return answer;
    }
}