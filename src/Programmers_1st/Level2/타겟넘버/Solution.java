package Programmers_1st.Level2.타겟넘버;

class Solution {
    int cnt = 0;


    void dfs(int idx, boolean[] plmi,int[] numbers,int target ){
        if(idx == numbers.length){
            if(cal(plmi, numbers,target)) cnt++;
            return;
        }

        plmi[idx] = true;
        dfs(idx+1,plmi,numbers, target);
        plmi[idx] = false;
        dfs(idx+1,plmi,numbers, target);

    }

    boolean cal(boolean[] plmi,int[] numbers,int target){
        int tmp = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(plmi[i]) {
                tmp += numbers[i];
            } else {
                tmp -= numbers[i];
            }
        }
        if(tmp == target) return true;
        return false;
    }

    public int solution(int[] numbers, int target) {

        int num = numbers.length;

        boolean[] plmi = new boolean[num];

        dfs(0,plmi,numbers,target);

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("new Solution().solution(new int[]{1,1,1,1,1},3) = " + new Solution().solution(new int[]{1,1,1,1,1},3));
    }
}