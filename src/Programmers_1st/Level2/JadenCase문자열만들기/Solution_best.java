package Programmers_1st.Level2.JadenCase문자열만들기;

public class Solution_best {

        public String solution(String s) {
            String answer = "";

            String[] splitS = s.toLowerCase().split("");
            boolean flag = true;

            for (String oneString : splitS){
                answer +=  flag ? oneString.toUpperCase() : oneString;
                flag = oneString.equals(" ") ? true : false;
            }
            return answer;
        }

}
