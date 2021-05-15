package Programmers.Level1.다트게임;

import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        char[] split = dartResult.toCharArray();
        int[] num = new int[]{0,0,0};

        int idx = 0;
        for (int i = 0; i < split.length ; i++) {
            int nxt = (int)split[i];
            if(nxt >= 48 && nxt <=57){
                num[idx]= num[idx]*10 + (nxt-48);
            } else if(nxt == 83){
                num[idx] = num[idx];
                idx++;
            } else if (nxt == 68){
                num[idx] = num[idx] * num[idx];
                idx++;
            } else if (nxt == 84) {
                num[idx] = num[idx] * num[idx] * num[idx];
                idx++;
            } else if (nxt == 42) {
                if (idx-1 == 0){
                    num[idx-1] *= 2;
                } else {
                    num[idx-2] *= 2;
                    num[idx-1] *= 2;
                }
            } else {
                num[idx-1] *= -1;
            }
        }
        answer = num[0] + num[1] + num[2];

        return answer;
    }

    public static void main(String[] args) {
        String tmp = "1S2D*3T";
        Solution s = new Solution();
        System.out.println("s.solution(tmp) = " + s.solution(tmp));
//        String[] tmp1 = tmp.split("[SDT]");
//        for (int i = 0; i < tmp1.length; i++) {
//            System.out.println("tmp1[i] = " + tmp1[i]);
//        }
//        System.out.println((int)'9');
//        System.out.println((int)'S'-'0');
//        System.out.println((int)'D');
//        System.out.println((int)'T');
//        System.out.println((int)'*');
//        System.out.println((int)'#');
    }
}
