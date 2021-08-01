package Programmers_1st.Level1.이상한문자만들기;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tmp = s.split("");
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i].equals(" ")){
                cnt = 0;
                sb.append(" ");
                continue;
            } else {
                if(cnt % 2 == 0 ) sb.append(tmp[i].toUpperCase());
                else sb.append(tmp[i].toLowerCase());
                cnt++;
            }
        }

        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String a = "ddd  dd sff ax zz";
//        System.out.println("a.indexOf(\"ddd\") = " + a.indexOf("ddd"));
//        System.out.println("a.indexOf(\"ddd\") = " + a.indexOf("ddd"));
//        System.out.println("a.indexOf(\"dd\") = " + a.indexOf("dd"));
//        a.substring(a.indexOf("ddd")+"ddd".length(),a.indexOf("dd"));
        System.out.println("s.solution(\"ddd  dd  sff       ax zz\") = " + s.solution("ddd  dd  sff       ax zz"));
    }
}