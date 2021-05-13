package Programmers.Level1.시저암호;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] tmp= s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char a : tmp){
            if(a == ' ') {
                sb.append(' ');
                continue;
            }
            if((int) a < 91){
                sb.append((char)((a-65+n)%26+65));
            } else {
                sb.append((char)((a-97+n)%26+97));
            }
        }
        answer=sb.toString();
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println((char)((int)'a'+10));
//        System.out.println((int)'a');
//        System.out.println((int)'A');
//        for (int i =65; i <91 ; i++) {
//            System.out.println((char)i);
//        }
    }
}