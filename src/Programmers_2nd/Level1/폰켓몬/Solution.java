package Programmers_2nd.Level1.폰켓몬;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;

        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            st.add(nums[i]);
        }
        if(answer>st.size()) answer = st.size();

        return answer;
    }
}