package Programmers.Level2.영어끝말잇기;

import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {

        int[] answer = new int[2];
        HashSet<String> hs = new HashSet<>();
        String word = words[0];
        hs.add(word);
        int idx = 0;
        boolean flag = false;

        for (int i = 1; i < words.length; i++) {
            String nxt = words[i];
            if(word.charAt(word.length()-1) != nxt.charAt(0)){
                idx = i;
                flag = true;
                break;
            } else {
                if(hs.contains(nxt)){
                    idx = i;
                    flag =true;
                    break;
                } else {
                    hs.add(nxt);
                    word = nxt;
                }
            }
        }

        answer[0] = flag ? idx%n + 1 : 0;
        answer[1] = flag ? idx/n + 1 : 0;

        return answer;
    }
}