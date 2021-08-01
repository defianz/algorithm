package Programmers_1st.Level3.기지국설치;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int idx = 1;
        int sidx = 0;

        while(sidx < stations.length){
            int tmp = stations[sidx] - w <1 ? 1 : stations[sidx] - w;
            if(idx < tmp ){
                answer += (tmp - idx) % (2*w+1) != 0 ? (tmp-idx) / (2*w+1) +1 : (tmp-idx)/(2*w+1);
            }
            idx = stations[sidx] + w+1;
            sidx++;
        }

        if(idx <= n ){
            int remain = n - idx + 1;
            answer += remain % (2*w+1) != 0 ? remain/(2*w+1) + 1 : remain/(2*w+1);
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(11,new int[]{4,11},1) = " + s.solution(11,new int[]{4,11},1));
        System.out.println("s.solution(16,new) = " + s.solution(16,new int[]{9},2));
    }
}