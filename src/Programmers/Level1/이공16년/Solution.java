package Programmers.Level1.이공16년;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] day = new String[]{"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] months = new int[]{0,31,29,31,30,31,30,31,31,30,31,30,31};
        int days =0;
        for(int i=1;i<=a-1; i++){
           days += months[i];
        }
        days = ( days + b) % 7;
        answer = day[days];

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(1,2) = " + s.solution(1, 2));
//        for (int i = 1; i <= 12; i++) {
//            for (int j = 1; j <= 31; j++) {
//                if(i % 2 !=0 ){
//                    System.out.println("s.solution(i,j) = " + s.solution(i, j));
//                } else {
//                    if(i==2 && j>29) continue;
//                    System.out.println("s.solution(i,j) = " + s.solution(i, j));
//                }
//            }
//        }
    }
}