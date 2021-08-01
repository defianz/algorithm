package Programmers_1st.Level3.보석쇼핑;

import java.util.HashSet;

class Solution_Fail {
    public int[] solution(String[] gems) {

        int totalLen = gems.length;

        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < totalLen; i++) {
            if(!hs.contains(gems[i])) hs.add(gems[i]);
        }

        int st = 1, end = totalLen;
        int answerLen = totalLen;

        for (int i = 0; i <totalLen- hs.size()+1; i++) {
            HashSet<String> tmp = new HashSet<>();
            for (int j = i; j < totalLen ; j++) {
                 if(tmp.contains(gems[j])) continue;
                 tmp.add(gems[j]);
                 if(tmp.equals(hs) && j-i+1 < answerLen){
                    st = i+1;
                    end = j+1;
                    answerLen = j-i+1;
                 }
            }
        }
        int[] answer = new int[]{st,end};
        return answer;
    }

    public static void main(String[] args) {
        Solution_Fail s = new Solution_Fail();
        int[] tmp = s.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        System.out.println("tmp[0] = " + tmp[0]);
        System.out.println("tmp[1] = " + tmp[1]);
    }
}
