package Programmers.Level2.나라의숫자123;

class Solution {

    String foo(int n ){
        if(n == 0 || n == 3){
            return "4";
        } else if (n == 1){
            return "1";
        } else if (n == 2){
            return "2";
        }

        if(n % 3 == 0){
            return foo((n-1)/3) + foo(n%3);
        } else {
            return foo(n/3) + foo(n%3);
        }
    }

    public String solution(int n) {
        String answer = "";

        answer = foo(n);

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 1; i < 20; i++) {
            System.out.println("s.solution(i) = " + i + ": "+ s.solution(i));
        }
    }
}

//
//class Solution {
//    public String solution(int n) {
//        String[] num = {"4","1","2"};
//        String answer = "";
//
//        while(n > 0){
//            answer = num[n % 3] + answer;
//            n = (n - 1) / 3;
//        }
//        return answer;
//    }
//}