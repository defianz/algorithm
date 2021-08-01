package Programmers_1st.Level3.브라이언의고민;

import java.util.ArrayList;

class Solution_Solving {

    boolean isLower(char c){
        if (c >= 'a' && c<='z'){
            return true;
        }
        return false;
    }

    boolean isUpper(char c){
        if( c>= 'A' && c<='z'){
            return true;
        }
        return false;
    }

    public String solution(String sentence) {
        String answer = "";

        int[] use = new int[26];
        boolean[] used = new boolean[26];
        int[] startpos = new int[26];
        int[] endpos = new int[26];
        int[] check = new int[1001];

        ArrayList<Integer> alphapos = new ArrayList<>();

        for (int i = 0; i < sentence.length() ; i++) {
            if(isLower(sentence.charAt(i))){
                use[sentence.charAt(i) - 'a']++;
                if(used[sentence.charAt(i)-'a'] == false){
                    used[sentence.charAt(i)-'a'] = true;
                    startpos[sentence.charAt(i) -'a'] = i;
                    alphapos.add(sentence.charAt(i)-'a');
                }
            }
            if(sentence.charAt(i) == ' '){
                return "invalid";
            }
        }
        used = new boolean[26];

        for (int i = sentence.length()-1; i >= 0; i--) {
            if(isLower(sentence.charAt(i))){
                if(used[sentence.charAt(i)-'a']==false){
                    used[sentence.charAt(i)-'a'] = true;
                    endpos[sentence.charAt(i)-'a'] = i;
                }
            }
        }

//        ArrayList<String> s = new ArrayList<>();
//        for (int i = 0; i < alphapos.size(); i++) {
//            char now = (char)(alphapos.get(i) + (int)'a');
//            if()
//        }



        return answer;
    }

    public static void main(String[] args) {

        System.out.println("(int)'A' = " + (int)'A');
    }
}
