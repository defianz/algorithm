package Programmers.Level1.이상한문자만들기;

class Solution_Solving {
    public String solution(String s) {

        String[] tmp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.length; i++) {
            String[] tmp2 = tmp[i].split("");
            for (int j = 0; j < tmp2.length; j++) {
//                if(tmp2[j].equals(" ")) continue;
                if (j % 2 == 0) sb.append(tmp2[j].toUpperCase());
                else sb.append(tmp2[j].toLowerCase());
            }
            sb.append(" ");
        }
        String answer = sb.toString().trim();

        return answer;
    }

    public static void main(String[] args) {
        Solution_Solving s = new Solution_Solving();
        System.out.println("s.solution(\"ddd  dd  sff       ax zz\") = " + s.solution("ddd  dd sff ax zz"));
    }
}