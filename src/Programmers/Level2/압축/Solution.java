package Programmers.Level2.압축;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class Solution {

    public int[] solution(String msg) {

        int len = msg.length();

        HashMap<String,Integer> hm = new HashMap<>();
        ArrayList<Integer> arl = new ArrayList<>();

        // 1번 해결
        for (int i = 1; i <= 26; i++) {
                hm.put((char)(64+i)+"",i);
        }

        Stack<Character> st = new Stack<>();
        for (int i = len-1; i >= 0; i--) {
            st.add(msg.charAt(i));
        }

        String nxt = "";
        int cnt = 27;

        while(!st.empty()){
            nxt += st.pop();
            if(hm.containsKey(nxt)){
                continue;
            } else {
                hm.put(nxt,cnt++);
                arl.add(hm.get(nxt.substring(0,nxt.length()-1)));
                st.add(nxt.substring(nxt.length()-1,nxt.length()).toCharArray()[0]);
                nxt = "";
            }
        }

        if(!nxt.equals("")) arl.add(hm.get(nxt));

        int[] answer = new int[arl.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arl.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] tmp = s.solution("KAKAO");
        int[] tmp = s.solution("TOBEORNOTTOBEORTOBEORNOT");
        for (int i = 0; i < tmp.length; i++) {
            System.out.println("tmp[i] = " + tmp[i]);
        }
    }
}