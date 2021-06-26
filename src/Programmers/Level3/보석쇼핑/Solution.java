package Programmers.Level3.보석쇼핑;

import java.util.HashMap;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};

        HashMap<String,Integer> hm = new HashMap<>();
        for (int i = 0; i < gems.length; i++) {
            if(!hm.containsKey(gems[i])) hm.put(gems[i],0);
        }

        int gemsCnt = hm.size();
        int gemsLen = gems.length;
        int checkGemCnt = 0;
        int ansL = 1;
        int ansR = gemsLen;
        int ansLen = gemsLen - ansL + 1;

        int l = 0;
        for (int r = 0; r < gemsLen; r++) {
            if(hm.get(gems[r]) == 0) {
                checkGemCnt++;
            }
            hm.put(gems[r],hm.get(gems[r])+1);

            while (checkGemCnt == gemsCnt) {
                if (r - l + 1 < ansLen) {
                    ansL = l + 1;
                    ansR = r + 1;
                    ansLen = r - l + 1;
                }
                hm.put(gems[l],hm.get(gems[l])-1);
                if(hm.get(gems[l]) == 0) checkGemCnt--;
                l++;
            }
        }

        answer = new int[]{ansL, ansR};

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        System.out.println("tmp[0] = " + tmp[0]);
        System.out.println("tmp[1] = " + tmp[1]);
    }
}