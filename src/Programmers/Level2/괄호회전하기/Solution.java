package Programmers.Level2.괄호회전하기;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;

        int len = s.length();
        Stack<Character> st = new Stack<>();

        int idx = 0;
        for (int i = 0; i < len; i++) {

            boolean flag = true;
            for (int j = idx; j < idx+len; j++) {
                char nxt = s.charAt(j % len);
                if(st.empty()){
                    if(nxt == ')' || nxt == '}' || nxt ==')') {
                        flag = false;
                        break;
                    }
                    st.add(nxt);
                }
                else {
                    if(nxt == '(' || nxt == '{' || nxt =='[') {
                        st.add(nxt);
                    } else {
                        char a = st.pop();
                        if(a == '(' && nxt == ')') {
                            continue;
                        } else if ( a == '[' && nxt ==']'){
                            continue;
                        } else if ( a == '{' && nxt == '}'){
                            continue;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            idx++;
            if(flag && st.empty()) answer++;
            st.clear();
        }

        return answer;
    }
}