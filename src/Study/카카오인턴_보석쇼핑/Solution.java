package Study.카카오인턴_보석쇼핑;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> hm = new HashMap<>();
        for (String gem : gems) {
            if(!hm.containsKey(gem)) hm.put(gem,0);
        }

        int gemsCnt = hm.size();
        int gemsLen = gems.length;
        int checkGemCnt = 0;
        int ansL = 1;
        int ansR = gemsLen;
        int ansLen = ansR - ansL + 1;

        int l = 0;
        for (int r = 0; r < gemsLen; r++) {
            if(hm.get(gems[r]) == 0) checkGemCnt++;
            hm.put(gems[r],hm.get(gems[r])+1);

            while(checkGemCnt == gemsCnt){
                if(r-l+1 < ansLen){
                    ansL = l + 1;
                    ansR = r + 1;
                    ansLen = r - l + 1;
                }
                hm.put(gems[l],hm.get(gems[l])-1);
                if(hm.get(gems[l]) == 0) checkGemCnt--;
                l++;
            }
        }

        return new int[]{ansL, ansR};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(new String[]{"A","B","B","B","B","B","B","C","B","A"});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
