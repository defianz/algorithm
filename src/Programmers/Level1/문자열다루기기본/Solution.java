package Programmers.Level1.문자열다루기기본;

class Solution {
    public boolean solution(String s) {
        if(!(s.length()==4 || s.length() ==6) ) return false;
        char[] tmp = s.toCharArray();
        for(char a : tmp){
            if(a-'0' < 0 || a-'0' > 9) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('1'-'0');
        System.out.println('2'-'0');
        System.out.println('3'-'0');
        System.out.println('4'-'0');

    }
}