package Programmers_2nd.Level1.소수만들기;

class Solution {

    void makeNotOdd(boolean[] notOdd){

        notOdd[0] = true;
        notOdd[1] = true;
        for (int i = 2; i*i< 3001; i++) {
            if(notOdd[i] == false){
                for (int j = i+i; j < 3001; j+=i) {
                    notOdd[j] = true;
                }
            }
        }
    }


    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;

       boolean[] notOdd = new boolean[3001];
       makeNotOdd(notOdd);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    int tmp = nums[i]+ nums[j] + nums[k];
                    if(!notOdd[tmp]) answer++;
                }
            }
        }

       return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 2, 3, 4}));
    }
}