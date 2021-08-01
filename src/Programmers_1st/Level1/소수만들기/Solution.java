package Programmers_1st.Level1.소수만들기;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        boolean[] odd = new boolean[3001];
        for (int i = 2; i <= 3000; i++) {
            for (int j = i+i; j <= 3000 ; j+=i) {
                odd[j] = true;
            }
        }

        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(odd[nums[i] + nums[j] + nums[k]]==false) answer++;
                }
            }
        }

        return answer;
    }
}
