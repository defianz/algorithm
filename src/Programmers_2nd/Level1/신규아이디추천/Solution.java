package Programmers_2nd.Level1.신규아이디추천;


class Solution {
    public String solution(String new_id) {

        new_id = new_id.toLowerCase();

//        new_id = new_id.replaceAll("[^a-z,1-9,.,_,-]","");
        new_id = new_id.replaceAll("[\\~\\!\\@\\#\\$\\%\\&\\*\\(\\)\\=\\+\\^\\[\\{\\]\\}\\:\\?\\,\\<\\>\\/]","");

        new_id = new_id.replaceAll("[.]+",".");

        new_id = new_id.replaceAll("^[.]","");
        new_id = new_id.replaceAll("[.]$","");

        if(new_id.length()==0) new_id = "a";

        if(new_id.length() >= 16) {
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("[.]$","");
        }

        if(new_id.length() <= 2){
            char tmp = new_id.charAt(new_id.length()-1);
            while(new_id.length() < 3){
                new_id += tmp + "";
            }
        }


        return new_id;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"z-+.^.\") = " + s.solution("z-+.^."));

    }
}