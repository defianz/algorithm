package Programmers_1st.Level1.폰켓몬;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Arrays.sort(nums);
        ArrayList<Integer> arl = new ArrayList<>();
        arl.add(nums[0]);

        int idx = 1;
        int end = nums.length/2;
        for (int i = 1; i < nums.length; i++) {
            if(idx == end) break;

            if(arl.get(idx-1) == nums[i]) continue;
            else {
                arl.add(nums[i]);
                idx++;
            }
        }

        answer = arl.size();

        return answer;
    }
}
