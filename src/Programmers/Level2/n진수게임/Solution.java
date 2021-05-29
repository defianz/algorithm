package Programmers.Level2.n진수게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int num = 0;
        int cnt = 0;


        while(answer.length() < t){
            
            int doNum = num;
            StringBuilder sb = new StringBuilder();
            if(doNum == 0) sb.append("0");

            while(doNum != 0){
                if(doNum%n >= 10) sb.append((char)(doNum % n + 55));
                else sb.append(String.valueOf((doNum % n)));
                doNum /= n;
            }

            String makeStr = sb.reverse().toString();

            for (int i = 0; i < makeStr.length(); i++) {

                cnt++;

                if(cnt % m == p || (cnt % m == p %m )) {
                    answer += makeStr.charAt(i)+"";
                    if(answer.length() == t) break;
                }
            }
            num++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(2,4,2,1) = " + s.solution(2, 4, 2, 1));
        System.out.println("s.solution(16,16,2,1) = " + s.solution(16, 16, 2, 1));
        System.out.println("s.solution(16,16,2,2) = " + s.solution(16,16,2,2));
    }
}
