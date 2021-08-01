package Programmers_1st.Level1.약수의개수와덧셈;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            int cnt =0;
            for (int j = 1; j <= i; j++) {
                if(i % j == 0) cnt++;
            }
            if(cnt % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(13,17) = " + s.solution(13,17));
    }
}
