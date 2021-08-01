package Programmers_1st.Level2.n개의최소공배수;

class Solution {
    public int solution(int[] arr) {

        int nxt = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(nxt < arr[i]) nxt = arr[i];
        }

        boolean allComplete = false;

        while(!allComplete){
            allComplete = true;
            for (int i = 0; i < arr.length; i++) {
                if(nxt % arr[i] != 0){
                    allComplete = false;
                    break;
                }
            }
            if(!allComplete) nxt++;
        }

        return nxt;
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        System.out.println("s.solution(new int[]{2,6,8,14}) = " + s.solution(new int[]{2, 6, 8, 14}));
        System.out.println("s.solution(new int[]{1,2,3}) = " + s.solution(new int[]{1, 2, 3}));
    }
}