package Programmers.Level3.일10옮기기;

import java.util.Stack;

class Solution {


    String foo(String s ){

        s.indexOf("110");

        return "TODO";
    }

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];


        for (int i = 0; i < s.length; i++) {
            int cnt110 = 0;
            String num = s[i];
            Stack<Character> st = new Stack<>();

            for (int j = 0; j < num.length(); j++) {
                st.push(num.charAt(j));

                if(st.size() >= 3){
                    char first = st.pop();
                    if(first != '0'){
                        st.push(first);
                        continue;
                    }

                    char second = st.pop();
                    if(second != '1'){
                        st.push(second);
                        st.push(first);
                        continue;
                    }

                    char third = st.pop();
                    if(third != '1'){
                        st.push(third);
                        st.push(second);
                        st.push(first);
                        continue;
                    }
                    cnt110++;
                }
            }
            StringBuilder sb = new StringBuilder();
            int pos = st.size();
            boolean flag = false;

            while(!st.empty()){
                char pop = st.pop();
                if(!flag && pop == '1') pos--;
                if(pop == '0') flag = true;
                sb.insert(0,pop);
            }

            for (int z = 0; z < cnt110; z++) {
                sb.insert(pos,"110");
            }
            answer[i] = sb.toString();
        }


        return answer;
    }
}