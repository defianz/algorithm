package Programmers.Level2.소수찾기;

import java.util.HashSet;

class Solution {
    String[] tmp2;
    HashSet<Integer> tmp3 = new HashSet<>();
    boolean[] check;

    void dp(String tmp){
        if(!tmp.equals("")){
             int num = Integer.parseInt(tmp);
             if(num != 0 & num !=1){
                 boolean flag = true;
                 for (int i = 2; i < num; i++) {
                     if(num %i == 0) {
                         flag = false;
                         break;
                     }
                 }
                 if(flag) {
                     tmp3.add(num);
                 }
             }
        }
        if(tmp.length() == tmp2.length) return;

        for (int i = 0; i < tmp2.length; i++) {
            if(check[i] == false){
                check[i] = true;
                dp(tmp+tmp2[i]);
                check[i] = false;
            }
        }


    }



    public int solution(String numbers) {

        tmp2 = numbers.split("");
        check = new boolean[numbers.length()];
        dp("");

        return tmp3.size();
    }

    public static void main(String[] args) {
        System.out.println("new Solution().solution(\"17\") = " + new Solution().solution("17"));
        System.out.println("new Solution().solution(\"17\") = " + new Solution().solution("011"));
    }
}