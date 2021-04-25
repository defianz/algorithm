package Programmers.Level1.평균구하기;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;

        for(double a: arr){
            answer += a;
        }
        answer /= arr.length;

        return answer;
    }
}

//# 특별한 답
//
//import java.util.Arrays;
//
//public class GetMean {
//    public int getMean(int[] array) {
//        return (int) Arrays.stream(array).average().orElse(0);
//    }
//
//    public static void main(String[] args) {
//        int x[] = {5, 4, 3};
//        GetMean getMean = new GetMean();
//        // 아래는 테스트로 출력해 보기 위한 코드입니다.
//        System.out.println("평균값 : " + getMean.getMean(x));
//    }
//}