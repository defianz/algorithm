package Programmers_1st.Level2.다음큰숫자;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String currBinary = Integer.toBinaryString(n);
        System.out.println("currBinary = " + currBinary);

        int currOneCnt = 0;
        for (int i = 0; i < currBinary.length(); i++) {
            if(currBinary.charAt(i) == '1') currOneCnt++;
        }

        String nextBinary = "";
        boolean allOne = false;
        allOne = currBinary.indexOf("0") == -1;

        if(allOne) {
            nextBinary = "10"+currBinary.substring(1,currBinary.length());
            int nextLen = nextBinary.length();
            System.out.println("nextBinary = " + nextBinary);
            for (int i = nextLen-1; i >= 0; i--) {
                answer += (nextBinary.charAt(i)-'0')*Math.pow(2,nextLen-1-i);
                System.out.println("answer = " + answer);
            }
            return answer;
        }

        for (int i = n+1; i <= 1000000; i++) {
            nextBinary = Integer.toBinaryString(i);
            System.out.println("nextBinary = " + nextBinary);
            int nextOneCnt = 0;
            for (int j = 0; j < nextBinary.length(); j++) {
                if(nextBinary.charAt(j)=='1') nextOneCnt++;
            }

            if(nextOneCnt == currOneCnt) {
                return i;
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(78) = " + s.solution(78));
        System.out.println("s.solution(15) = " + s.solution(15));
    }
}
