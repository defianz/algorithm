package Study.weeklychallenge.week7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[leave.length];

        Map<Integer,Integer> enterMap = new HashMap();
        for (int i = 0; i < enter.length; i++) {
            enterMap.put(enter[i],i);
        }

        Map<Integer,Integer> leaveMap = new HashMap();
        for (int i = 0; i < leave.length; i++) {
            leaveMap.put(leave[i],i);
        }


        for (int curLeaveIdx = 0; curLeaveIdx < leave.length; curLeaveIdx++) {
            int cur = leave[curLeaveIdx];
            int curEnterIdx = enterMap.get(cur);

            // 먼저와서 나중에 떠난것들
            for (int i = 0; i < curEnterIdx; i++) {
                int comp = enter[i];
                int compLeaveIdx = leaveMap.get(comp);
                if(curLeaveIdx < compLeaveIdx) answer[cur-1]++;
            }

            // 나중에 와서 먼저 떠난 것들
            for (int i = 0; i < curLeaveIdx; i++) {
                int comp = leave[i];
                int compEnterIdx = enterMap.get(comp);
                if(compEnterIdx > curEnterIdx) answer[cur-1]++;
            }

            // comp가 x보다 나중에 와서 나중에 떠났지만, comp 보다 나중에 온 z가 x보다 먼저 떠나서 comp 와 x가 만났음을 증명해주는 경우
            for (int i = curLeaveIdx+1; i < leave.length; i++) {
                int comp = leave[i];
                int compEnterIdx = enterMap.get(comp);
                if(compEnterIdx < curEnterIdx) continue;

                for (int j = 0; j < curLeaveIdx; j++) {
                    int z = leave[j];
                    int zEnterIdx = enterMap.get(z);
                    if(zEnterIdx > compEnterIdx ) {
                        answer[cur-1]++;
                        break;
                    }
                }
            }

            // comp 가 x보다 먼저 와서 먼저 떠났지만, x보다 나중에 온 z가 comp 보다 먼저 떠나서 comp 와 x가 만났음을 증명해주는 경우
            for (int i = 0; i < curEnterIdx; i++) {
                int comp = enter[i];
                int compLeaveIdx = leaveMap.get(comp);
                if(compLeaveIdx > curLeaveIdx) continue;

                for (int j = 0; j < compLeaveIdx; j++) {
                    int z = leave[j];
                    int zEnterIdx = enterMap.get(z);
                    if(zEnterIdx > curEnterIdx ){
                        answer[cur-1]++;
                        break;
                    }
                }
            }

        }
        return answer;
    }

}