package Programmers_1st.Level2.괄호변환;

import java.util.Stack;

class Solution {

    String foo(String p ){
        if(p.equals("")){
            return "";
        }

        // u, v 분리
        // u
        int i =0;
        int idx = 0;
        Stack<Integer> st = new Stack<>();
        boolean flag = true;
        for (; i < p.length();) {
            if(p.charAt(i) == '('){
                idx--;
                st.add(0);
            } else {
                idx++;
                if(st.empty()) {
                    flag = false;
                } else {
                    st.pop();
                }
            }
            i++;
            if(idx==0) break;
        }

        String u = p.substring(0,i);
        String v=  i < p.length() ? p.substring(i,p.length()) : "";

        if(flag) return u +foo(v);
        else {
            String tmp = "(";
            tmp += foo(v);
            tmp += ")";
            for (int j = 1; j < u.length()-1; j++) {
                if(u.charAt(j) == '(') tmp += ')';
                else tmp += '(';
            }
            return tmp;
        }
    }


    public String solution(String p) {
        String answer = foo(p);
        return answer;
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println("s.solution(\"(()())()\") = " + s.solution("(()())()"));
        System.out.println("s.solution(\")(\") = " + s.solution(")("));
        System.out.println("s.solution(\"()))((()\") = " + s.solution("()))((()"));
    }
}