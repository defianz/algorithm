package Programmers_1st.Level3.멀리뛰기;

class Solution {

     long dp(int n, long[] arr){

         if(arr[n] == 0){
             arr[n] = (dp(n-1,arr)+dp(n-2,arr) )% 1234567;
             return arr[n];
         } else{
             return arr[n];
         }
    }


    public long solution(int n) {
        long answer = 0;
        long[] arr = new long[n+1];
        arr[0] = 1;
        arr[1] = 1;

        answer = dp(n, arr) % 1234567;

        return answer;
    }
}