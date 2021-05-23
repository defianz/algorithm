package Programmers.Level2.숫자의표현;

class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            for (int j = i; j <=n; j++) {
                tmp += j;
                if(tmp == n) {
                    answer++;
                    break;
                } else if( tmp > n){
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(15) = " + s.solution(15));
    }
}