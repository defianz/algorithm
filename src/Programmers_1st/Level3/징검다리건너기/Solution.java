package Programmers_1st.Level3.징검다리건너기;

class Solution {

    boolean cross(int[] stones, int k, int mid){
        int cnt = 0;
        for (int stone : stones){
            if(stone - mid < 0) cnt++;
            else cnt = 0;

            if(cnt == k ) return false;
        }
        return true;
    }

    public int solution(int[] stones, int k) {
        int answer = 0;



        int l = 0;
        int r = 200000001;

        while(l<=r){
            int mid = (l+r)/2;
            if(!cross(stones, k,mid)){
                r = mid -1;
            } else{
                l = mid + 1 ;
                answer = Math.max(answer,mid);
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1},3) = " + s.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }
}
