package Programmers_1st.Level1.키패드누르기;


class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int l = 10;
        int r = 12;

        String[] tmp = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            int nxt = numbers[i] == 0 ? 11 : numbers[i];
            if(nxt == 1 || nxt == 4 || nxt == 7){
                tmp[i] = "L";
                l = nxt;
            } else if (nxt == 3 || nxt == 6 || nxt == 9){
                tmp[i] = "R";
                r = nxt;
            } else {
                int drow = (nxt-1) / 3;
                int dcol = (nxt-1) % 3;
                int rrow = (r-1) / 3;
                int rcol = (r-1) % 3;
                int lrow = (l-1) / 3;
                int lcol = (l-1) % 3;


                int rdist = Math.abs((drow - rrow)) + Math.abs((dcol-rcol));
                int ldist = Math.abs((drow - lrow)) + Math.abs((dcol-lcol));

                if(rdist < ldist) {
                    tmp[i] = "R";
                    r = nxt;
                } else if (rdist > ldist){
                    tmp[i] = "L";
                    l = nxt;
                } else {
                    tmp[i] = hand.toUpperCase().substring(0, 1);
                    if (hand.equals("right")) r = nxt;
                    else l = nxt;
                }
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            answer += tmp[i];
        }
        return answer;
    }

}
