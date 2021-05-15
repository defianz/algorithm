package Programmers.Level1.신규아이디추천;

class Solution {
    public String solution(String new_id) {

        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9-_.]","");

        // 3단계
        String[] tmp = new_id.split("");
        for (int i = tmp.length-1; i >=2 ; i--) {
            String tmp2 = "";
            for (int j = 0; j < i; j++) {
                tmp2 += ".";
            }
            new_id = new_id.replace(tmp2,".");
        }

        // 4단계
        if(new_id.charAt(0) == '.'){
            new_id = new_id.substring(1, new_id.length());
        }
        if(new_id.length() > 0 && new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0,new_id.length()-1);
        }

        // 5단계
        if(new_id.length() == 0){
            new_id = "a";
        }

        // 6단계
        if(new_id.length() >= 16){
            if(new_id.charAt(14)== '.'){
                new_id = new_id.substring(0,14);
            } else {
                new_id = new_id.substring(0,15);
            }
        }

        // 7단계
        if(new_id.length() <= 2){
            String last = String.valueOf(new_id.charAt(new_id.length()-1));
            while(new_id.length() != 3){
                new_id += last;
            }
        }

        return new_id;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"...!@BaT#*..y.abcdefghijklm\") = " + s.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println("s.solution(\"z-+.^.\") = " + s.solution("z-+.^."));
        System.out.println("s.solution(\"=.=\") = " + s.solution("=.="));
        System.out.println("s.solution(\"123_.def\") = " + s.solution("123_.def"));
        System.out.println("s.solution(\"abcdefghijklmn.p\") = " + s.solution("abcdefghijklmn.p"));
    }
}
