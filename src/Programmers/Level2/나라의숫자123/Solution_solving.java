package Programmers.Level2.나라의숫자123;

class Solution_solving {
    public String solution(int n) {
        String answer = "";

        int smax = 1;

        while(n > smax ){
            smax *= 3;
        }

        if(n != smax) smax /= 3;

        while( smax != 0){
            int tmp = 0;
            boolean flag = false;
            while( n-smax > 0){
                n -= smax;
                tmp++;
                flag = true;
            }

            if( n == smax ) {
                flag = true;
                n = 0;
                tmp++;
            }
            if(flag) answer += String.valueOf(tmp);

            smax /= 3;
        }



        return answer;
    }

    public static void main(String[] args) {
        Solution_solving s = new Solution_solving();
        System.out.println("s.solution(1) = " + s.solution(1));
        System.out.println("s.solution(2) = " + s.solution(2));
        System.out.println("new Solution().solution(1) = " + new Solution_solving().solution(3));
    }
}