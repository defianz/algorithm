package Programmers_1st.Level2.짝지어제거하기;

import java.util.Stack;

class Solution
{
    public int solution(String s)
    {

       Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char nxt = s.charAt(i);
            if(st.empty()) st.add(nxt);
            else {
                if(st.peek() == nxt){
                    st.pop();
                } else {
                    st.add(nxt);
                }
            }
        }

        return st.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"baabaa\") = " + s.solution("baabaa"));
        System.out.println("s.solution(\"cdcd\") = " + s.solution("cdcd"));
    }
}
